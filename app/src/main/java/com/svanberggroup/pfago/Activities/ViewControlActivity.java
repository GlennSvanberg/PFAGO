package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.Fault;
import com.svanberggroup.pfago.Models.Goods;
import com.svanberggroup.pfago.Models.Quantity;
import com.svanberggroup.pfago.Models.SafetyAdvisor;
import com.svanberggroup.pfago.Models.TransportDocumentRows;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.TransportRows;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ViewControlActivity extends AppCompatActivity {
    private Control control;
    private boolean isApprovalMode;
    private LinearLayout  cardsLinearLayout;

    private static final int REQUEST_CONTROL_APPROVAL = 5;

    private LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_control);

        control = (Control) getIntent().getSerializableExtra("control");
        isApprovalMode =getIntent().getBooleanExtra("approvalMode", false);
        ControlRepository repo = ControlRepository.get();
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService((Context.LAYOUT_INFLATER_SERVICE));

        cardsLinearLayout = findViewById(R.id.cards_linear_layout);

        setCards();
    }

    private void setCards() {
        List<View> cards = new ArrayList<>();

        setHeaderCard(addCardView(cards));
        setVehicleCard(addCardView(cards));
        setTransporterCard(addTransporterCardView(cards));
        setDestinationsCard(addCardView(cards));
        setCargoCard(addCardView(cards));

        setTdCard(addRowsCardView((cards)));
        setTCard(addRowsCardView(cards));

        setGoodsCard(addRowsCardView(cards));
        setFaultsCard(addRowsCardView(cards));
        setSafetyAdvisorCard(addCardView(cards));
        setProhibitionCard(addCardView(cards));
        setSubmissionCard(addCardViewFullWidth(cards));
        setReportsCard(addCardView(cards));
        if(isApprovalMode){
            setApprovalButtons(cards);
        }

        displayViews(cardsLinearLayout, cards);
    }
    private TextView cardLeft(View card) {
        return card.findViewById(R.id.card_body_left);
    }

    private TextView cardRight(View card) {
        return card.findViewById(R.id.card_body_right);
    }

    private TextView cardTitle(View card) {
        return card.findViewById(R.id.card_title);
    }

    private void setHeaderCard(View card) {

        setText(cardTitle(card), "Kontroll");

        StringBuilder str = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String startDate = "";
        if(control.getStartDate() != null){
            startDate = formatter.format(control.getStartDate());
        }
        String place = "";
        if (control.getLocation() != null){
            place = control.getLocation();
        }

        str.append(line("Datum:", startDate));
        str.append(line("Plats:", place));
        String p = "";
        if(control.getLocationType() != null){
            p = getString(control.getLocationType().label);
        }
        str.append(line("Platstyp:", p));
        setText(cardLeft(card), str.toString());

        str = new StringBuilder();
        formatter = new SimpleDateFormat("HH:mm");

        str.append(line("Start:", startDate));

        String endDate = "";
        if(control.getEndDate() != null){
            endDate = formatter.format(control.getEndDate());
        }
        str.append(line("Slut:", endDate));

        setText(cardRight(card), str.toString());
    }

    private void setVehicleCard(View card) {
        setText(cardTitle(card), "Fordon");
        setText(cardLeft(card), vehicleText(control.getTruck()));
        setText(cardRight(card), vehicleText(control.getTrailer()));
    }

    private String vehicleText(Vehicle vehicle) {

        StringBuilder str = new StringBuilder();
        if(vehicle != null){
            if(vehicle.getVehicleType()!= null){
                str.append(line("", getString(vehicle.getVehicleType().label)));
            } else {
                str.append(line("", "Ingen fodrdonstyp angedd"));
            }
            str.append(line("RegNr:", vehicle.getRegNr()));
            str.append(line("Nationalitet:", vehicle.getNationality()));
        } else {
            str.append("Ej tillagt");
        }

        return str.toString();
    }

    private void setTransporterCard(View card){
        setText(cardTitle(card), "Transportör");
        setCarrier(card);
        TextView driverTextView = card.findViewById(R.id.driver_text);
        TextView passengerTextView = card.findViewById(R.id.passenger_text);

        setText(driverTextView, setTransporterText(control.getDriver(), "Förare"));
        setText(passengerTextView, setTransporterText((control.getPassenger()), "Passagerare"));
    }

    private void setCarrier(View card){
        StringBuilder str = new StringBuilder();
        Transporter carrier = control.getCarrier();
        TextView left = card.findViewById(R.id.carrier_text_left);
        TextView right = card.findViewById(R.id.carrier_text_right);

        if(carrier != null){
            str.append(line("Företag:", carrier.getName()));
            str.append(line("Tel:", carrier.getPhone()));
        } else {
            str.append("Företag ej tillagt<br>");
        }

        setText(left, str.toString());
        setText(right, address(carrier));
    }

    private String setTransporterText(Transporter transporter, String title) {
        StringBuilder str = new StringBuilder();
        if(transporter != null){
            str.append(line("", title));
            str.append(line("Namn:", transporter.getName()));
            str.append(line("Tel:", transporter.getPhone()));
            str.append(address(transporter));
        } else {
            str.append(title + " ej tillagd");
        }

        return str.toString();
    }

    private void setDestinationsCard(View card) {
        setText(cardTitle(card), "Destinationer");
        setText(cardLeft(card), destinationText(control.getSender(), true));
        setText(cardRight(card), destinationText(control.getReceiver(), false));
    }

    private String destinationText(TransportLocation location, boolean isSender) {
        StringBuilder str = new StringBuilder();
        if(location != null){
            if(isSender) {
                str.append(line("", "Avsändare"));
                str.append(line("Adress:", location.getAddress()));
                str.append(line("Lastplats:", location.getPlace()));
            } else {
                str.append(line("", "Mottagare"));
                str.append(line("Adress:", location.getAddress()));
                str.append(line("Lossnigsplats:", location.getPlace()));
            }
            str.append(line("Tel:", location.getPhone()));
        } else {
            str.append((isSender ? "Avsändare " : "Mottagare ") + "ej tillagd");
        }
        return str.toString();
    }

    private void setCargoCard(View card){
        StringBuilder str = new StringBuilder();
        setText(cardTitle(card), "Gods");
        Quantity qty = control.getQuantity();
        if(qty != null){
            if(qty.getQuantityType() != null) {
                str.append(line("Mängd:", qty.getQuantity() + getString(qty.getQuantityType().label)));
            }else {
                str.append(line("Mängd:", ""));
            }
            if(qty.getPackagingStandard()!= null){
                str.append(line("Standard:", getString(qty.getPackagingStandard().label)));
            }else {
                str.append(line("Mängd:",  ""));
            }
            str.append(line("Värdeberäknad mängd:", "" + control.getValueQuantity()));

            str.append(line("Överskriden:", control.isValueQuantityExceeded() ? "Ja" : "Nej"));
            setText(cardLeft(card), str.toString());

            str = new StringBuilder();
            if(control.getTransportType()!=null){
                str.append(line("Transport med:", getString(control.getTransportType().label)));
            } else {
                str.append(line("Transport med:", ""));
            }
            if(control.getTransportStandard()!=null){
                str.append(line("Transport enligt:", getString(control.getTransportStandard().label)));
            }else {
                str.append(line("Transport enligt:", ""));
            }

            setText(cardRight(card), str.toString());
        } else {
            str.append("Ej tillagt");
            setText(cardLeft(card), str.toString());
        }

    }

    private void setTdCard(View card) {
        LinearLayout layout = card.findViewById(R.id.card_rows);
        ArrayList<View> views = new ArrayList<>();
        TransportDocumentRows tdRows = control.getTdRows();
        setText(cardTitle(card), "Transporthandlingar");
        String declaration = "";
        if(tdRows.getDeclaration() != null){
            declaration = Html.fromHtml(line("", getString(tdRows.getDeclaration().label))).toString();
        }
        setControlRow(tdRows.getGoodsDeclarationRow(), addRowView(layout,views),declaration);
        setControlRow(tdRows.getWrittenInstructionsRow(), addRowView(layout,views));
        if(tdRows.getApproval()!= null){
            tdRows.getApprovalRow().setName("15." + getString(tdRows.getApproval().label));
        }
        setControlRow(tdRows.getApprovalRow(), addRowView(layout,views));
        setControlRow(tdRows.getApprovalCertificateRow(), addRowView(layout,views));
        setControlRow(tdRows.getDriverCertificationRow(), addRowView(layout,views));
        setControlRow(tdRows.getOtherADRTrainingRow(), addRowView(layout,views));
        displayViews(layout, views);
    }
    private void setTCard(View card) {
        LinearLayout layout = card.findViewById(R.id.card_rows);
        ArrayList<View> views = new ArrayList<>();
        TransportRows tRows = control.getTRows();

        setText(cardTitle(card), "Transport");

        setControlRow(tRows.getRow18(), addRowView(layout,views));
        setControlRow(tRows.getRow19(), addRowView(layout,views));
        setControlRow(tRows.getRow20(), addRowView(layout,views));
        setControlRow(tRows.getRow21(), addRowView(layout,views));
        setControlRow(tRows.getRow22_1(), addRowView(layout,views));
        setControlRow(tRows.getRow22_2(), addRowView(layout,views));
        setControlRow(tRows.getRow22_3(), addRowView(layout,views));
        setControlRow(tRows.getRow23_1(), addRowView(layout,views));
        setControlRow(tRows.getRow23_2(), addRowView(layout,views));
        setControlRow(tRows.getRow24(), addRowView(layout,views));
        setControlRow(tRows.getRow25_1(), addRowView(layout,views));
        setControlRow(tRows.getRow25_2(), addRowView(layout,views));
        setControlRow(tRows.getRow26(), addRowView(layout,views));
        setControlRow(tRows.getRow27(), addRowView(layout,views));
        setControlRow(tRows.getRow28_1(), addRowView(layout,views));
        setControlRow(tRows.getRow28_2(), addRowView(layout,views));
        setControlRow(tRows.getRow28_3(), addRowView(layout,views));
        setControlRow(tRows.getRow28_4(), addRowView(layout,views));
        setControlRow(tRows.getRow29(), addRowView(layout,views));
        setControlRow(tRows.getRow31(), addRowView(layout,views));
        int counter = 1;
        for(ControlRow row : tRows.getRows40()){
            row.setName("40." + counter + ". " + row.getTitle());
            setControlRow(row, addRowView(layout,views));
            counter++;
        }
        String risk = "";
        if(tRows.getRiskCategory() != null){
            risk = getString(tRows.getRiskCategory().label);
        }
        setControlRowRisk(risk,addRowView(layout, views));

        displayViews(layout, views);
    }

    private void setGoodsCard(View card){

        setText(cardTitle(card), "Gods");
        LinearLayout layout = card.findViewById(R.id.card_rows);
        ArrayList<View> views = new ArrayList<>();
        List<Goods> goods = control.getGoodsList();
        if(goods.size() == 0){
            View v = addRowView(layout, views);
            setText((TextView) v.findViewById(R.id.left), "Ej tillagt");
        }
        for(int i = 0; i < goods.size(); i++){
            setGoodsRow(goods.get(i), addRowView(layout, views));
        }
        displayViews(layout, views);
    }
    private void setGoodsRow(Goods goods, View card){
        StringBuilder str = new StringBuilder();
        TextView left = card.findViewById(R.id.left);
        TextView right = card.findViewById(R.id.right);

        str.append(line("Pos:", goods.getPosition()));
        str.append(line("UN-nr:", goods.getUnNr()));
        str.append(line("Godsbeskrivning:", goods.getDescription()));
        str.append(line("Klass/Etikett:", goods.getLabel()));
        setText(left, str.toString());

        str = new StringBuilder();
        str.append(line("PG:", goods.getPG()));
        str.append(line("Mängd:", goods.getQty()));
        str.append(line("Fraktsedel:", goods.getWayBill()));
        str.append(line("LQ:", goods.isLq() ? "Ja" : "Nej"));
        setText(right, (str.toString()));
    }
    private void setFaultsCard(View card){

        setText(cardTitle(card), "Brister");
        LinearLayout layout = card.findViewById(R.id.card_rows);
        ArrayList<View> views = new ArrayList<>();
        List<Fault> faults = control.getFaultList();
        if(faults.size() == 0){
            View v = addRowView(layout, views);
            setText((TextView) v.findViewById(R.id.left), "Ej tillagt");
        }
        for(int i = 0; i < faults.size(); i++){
            setFaultRow(faults.get(i), addRowView(layout, views));
        }
        displayViews(layout, views);
    }

    private void setFaultRow(Fault fault, View card){
        StringBuilder str = new StringBuilder();
        TextView left = card.findViewById(R.id.left);
        TextView right = card.findViewById(R.id.right);

        str.append(line("Fältnr:", String.valueOf(fault.getFieldNr())));
        str.append(line("Anmärkning:", fault.getFault()));

        setText(left, str.toString());

        str = new StringBuilder();
        str.append(line("Gods pos:", fault.getGoodsPos()));
        str.append(line("Marginalnummer i ADR/ADR-S:", fault.getMarginal()));

        setText(right, (str.toString()));
    }
    private void setSafetyAdvisorCard(View card){
        setText(cardTitle(card), "Säkerhetsrådgivare");
        SafetyAdvisor carrier = control.getSafetyAdvisorCarrier();
        SafetyAdvisor sender = control.getSafetyAdvisorSender();

        setText(cardLeft(card), safetyAdvisorText(carrier, "Transportör"));
        setText(cardRight(card), safetyAdvisorText(sender, "Avsändare"));
    }
    private String safetyAdvisorText(SafetyAdvisor safetyAdvisor, String title){
        StringBuilder str = new StringBuilder();
        if(safetyAdvisor != null) {
            str.append(line("", title));
            str.append(line("Namn:", safetyAdvisor.getName()));
            str.append(line("Svar:", getString(safetyAdvisor.getAnswer().label)));
        } else {
            str.append(title + " ej tillagd");
        }

        return str.toString();
    }

    private void setProhibitionCard(View card){
        StringBuilder str = new StringBuilder();
        setText(cardTitle(card), "Beslut om förbud");

        List<Integer> prohibitions = control.getProhibitetFieldNrList();
        if(prohibitions.size() > 0){
            str.append("Med stöd av 14 i lag (2006:263) om transport av farligt gods förbjuds fortsatt transport så länge som position");
            str.append(prohibitions.size() > 1 ? "erna" : "");
            str.append(" enligt fält nr <strong>");
            for(int i = 0; i < prohibitions.size(); i++){
                str.append(prohibitions.get(i));
                if(prohibitions.size() > i+1){
                    str.append(", ");
                }
            }
            str.append("</strong> i kontrollist" + (prohibitions.size() > 1 ? "or" : "a"));
            str.append(" upptagna brister inte avhjälpts");

            setText(cardLeft(card), str.toString());
            str = new StringBuilder();


            if(control.isAllowedToContinueTrip()) {
                str.append("Trots meddelat förbud medges färd kortast lämpliga väg till uppställning-/omlastning-/lossningslats:<br>");
                str.append("<strong>" + control.getDestination() + "</strong>");
            }
            setText(cardRight(card), str.toString());
        } else {
            setText(cardLeft(card), "Ej tillagt");
        }

    }
    private void setSubmissionCard(View card){
        StringBuilder str = new StringBuilder();
        setText(cardTitle(card), "Beslut om föreläggande");
        List<Integer> submissions = control.getSubmissionFieldNrList();

        if(submissions.size() > 0){
            str.append("Med stöd av 14 i lag (2006:263) om transport av farligt gods meddelas föreläggande att snarast avhjälpa brister under position");
            str.append(submissions.size() > 1 ? "erna" : "");
            str.append(" enligt fält nr <strong>");
            for(int i = 0; i < submissions.size(); i++){
                str.append(submissions.get(i));
                if(submissions.size() > i+1){
                    str.append(", ");
                }
            }
            str.append("</strong> i kontrollista");


        } else {
            str.append("Ej tillagt");
        }
        TextView body = card.findViewById(R.id.card_body);
        setText(body, str.toString());

    }
    private void setReportsCard(View card){

        setText(cardTitle(card), "Rapporter (antal rapporterade brott)");
        String entity = "";
        if(control.getReportedEntity() != null){
            entity = getString(control.getReportedEntity().label);
        }
        setText(cardLeft(card), line("Rapporterad entitet: ", entity));
        StringBuilder str = new StringBuilder();
        str.append(line("OF-koder:", ""));
        for(String of : control.getPenaltiesList()){
            str.append(line("", of));
        }
        setText(cardRight(card), str.toString());
    }

    private void setApprovalButtons(List<View> views){
        View view = layoutInflater.inflate(R.layout.control_approval_buttons, cardsLinearLayout,false);
        Button approvalButton = view.findViewById(R.id.approve_button);
        approvalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approveControl(true);
            }
        });
        Button declineButton = view.findViewById(R.id.decline_button);
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approveControl(false);
            }
        });
        views.add(view);

    }
    private void approveControl(boolean decision){
        Intent intent = new Intent();
        intent.putExtra("approved", decision);
        setResult(REQUEST_CONTROL_APPROVAL, intent);
        finish();
    }

    private View addCardView(List<View> views){
        View view = layoutInflater.inflate(R.layout.view_control_card, cardsLinearLayout,false);
        views.add(view);
        return view;
    }
    private View addCardViewFullWidth(List<View> views){
        View view = layoutInflater.inflate(R.layout.view_control_card_full_width, cardsLinearLayout,false);
        views.add(view);
        return view;
    }
    private View addTransporterCardView(List<View> views){
        View view = layoutInflater.inflate(R.layout.view_control_transporter_card, cardsLinearLayout,false);
        views.add(view);
        return view;
    }

    private View addRowsCardView(List<View> views){
        View view = layoutInflater.inflate(R.layout.view_control_rows_card, cardsLinearLayout,false);
        views.add(view);
        return view;
    }

    private View addRowView(LinearLayout linearLayout, List<View> views) {
        View view;
        if(views.size() == 0) {
            view = layoutInflater.inflate(R.layout.view_control_row_first, linearLayout,false);
        } else {
            view = layoutInflater.inflate(R.layout.view_control_row, linearLayout,false);
        }
        views.add(view);
        return view;
    }

    private void displayViews(LinearLayout layout, List<View> views) {
        for(View v : views) {
            layout.addView(v);
        }
    }
    private void setControlRowRisk(String category, View view){
        TextView left = view.findViewById(R.id.left);
        TextView right = view.findViewById(R.id.right);
        setText(left, "Riskkategori vid brister ovan: ");
        setText(right, line("", category));
    }
    private void setControlRow(ControlRow row, View view){
        setControlRow(row,view, "");
    }
    private void setControlRow(ControlRow row, View view, String text){
        TextView left = view.findViewById(R.id.left);
        TextView right = view.findViewById(R.id.right);

        setControlRowLeft(row, left);
        setControlRowRight(row,right, text);
    }

    private void setControlRowLeft(ControlRow row, TextView textView) {
        StringBuilder str = new StringBuilder();
        if(row != null){
            str.append(line("",row.getName()));
            if(row.getField() == ControlRow.Field.BreakingTheLaw) {
                str.append(line("Riskkategori:", row.getRiskCategory()));
                str.append(line("Anteckningar:", row.getNotes()));
            }
        }   else {
            str.append(row.getName());
        }
        setText(textView, str.toString());

    }
    private void setControlRowRight(ControlRow row, TextView textView, String text){
        StringBuilder str = new StringBuilder();
        if(row != null){
            if(row.getField() != null){
                str.append(line("", getString(row.getField().label)));
            }else {
                //str.append(line("", "Ej kontrollerat"));
            }

            if(row.getField() == ControlRow.Field.BreakingTheLaw) {
                str.append(line("Förbud:", row.isBanned() ? "Ja" : "Nej"));
                str.append(line("Föreläggande:", row.isImposed() ? "Ja" : "Nej"));
                if (text != null) {
                    str.append(text);
                }
            }
        }else {
            str.append("Ej tillagt");
        }
        setText(textView, str.toString());
    }

    private String address(Transporter transporter){
        StringBuilder str = new StringBuilder();
        if(transporter != null){
            str.append(line("Adress:", transporter.getAddress()));
            str.append(line("Postnummer:", String.valueOf(transporter.getZipNr())));
            str.append(line("Postort:", transporter.getCity()));
            str.append(line("Land:", transporter.getNationality()));
        }

        return str.toString();
    }

    private void setText(TextView textView, String str) {
        textView.setText(Html.fromHtml(str));
    }

    private String line(String title, String data) {
        return title + " <strong>" + data + "</strong>" + "<br>";
    }
}
