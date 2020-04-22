package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.Goods;
import com.svanberggroup.pfago.Models.Quantity;
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
    private LinearLayout  cardsLinearLayout;

    private LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_control);
        int id = getIntent().getIntExtra("control_id", 0);

        ControlRepository repo = ControlRepository.get();
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        control = repo.getControlById(id);

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

        String date = formatter.format(control.getStartDate());
        String place = control.getLocation();

        str.append(line("Datum:", date));
        str.append(line("Plats:", place));
        str.append(line("Platstyp:", getString(control.getLocationType().label)));
        setText(cardLeft(card), str.toString());

        str = new StringBuilder();
        formatter = new SimpleDateFormat("HH:mm");

        String startDate = formatter.format(control.getStartDate());
        String endDate = formatter.format(control.getEndDate());

        str.append(line("Start:", startDate));
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

        str.append(line("", getString(vehicle.getVehicleType().label)));
        str.append(line("RegNr:", vehicle.getRegNr()));
        str.append(line("Nationalitet:", vehicle.getNationality()));

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

        str.append(line("Företag:", carrier.getName()));
        str.append(line("Tel:", carrier.getPhone()));

        setText(left, str.toString());
        setText(right, address(carrier));
    }

    private String setTransporterText(Transporter transporter, String title) {
        StringBuilder str = new StringBuilder();

        str.append(line("", title));
        str.append(line("Namn:", transporter.getName()));
        str.append(line("Tel:", transporter.getPhone()));
        str.append(address(transporter));

        return str.toString();
    }

    private void setDestinationsCard(View card) {
        setText(cardTitle(card), "Destinationer");
        setText(cardLeft(card), destinationText(control.getSender(), true));
        setText(cardRight(card), destinationText(control.getReceiver(), false));
    }

    private String destinationText(TransportLocation location, boolean isSender) {
        StringBuilder str = new StringBuilder();
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

        return str.toString();
    }

    private void setCargoCard(View card){
        StringBuilder str = new StringBuilder();
        Quantity qty = control.getQuantity();
        setText(cardTitle(card), "Gods");

        str.append(line("Mängd:", qty.getQuantity() + getString(qty.getQuantityType().label)));
        str.append(line("Standard:", getString(qty.getPackagingStandard().label)));
        str.append(line("Värdeberäknad mängd:", "" + control.getValueQuantity()));

        str.append(line("Överskriden:", control.isValueQuantityExceeded() ? "Ja" : "Nej"));
        setText(cardLeft(card), str.toString());

        str = new StringBuilder();
        str.append(line("Transport med:", getString(control.getTransportType().label)));
        str.append(line("Transport enligt:", getString(control.getTransportStandard().label)));
        setText(cardRight(card), str.toString());
    }

    private void setTdCard(View card) {
        LinearLayout layout = card.findViewById(R.id.card_rows);
        ArrayList<View> views = new ArrayList<>();
        TransportDocumentRows tdRows = control.getTdRows();

        String declaration = Html.fromHtml(line("", getString(tdRows.getDeclaration().label))).toString();
        setControlRow(tdRows.getGoodsDeclarationRow(), addRowView(layout,views), "13. Godsdeklaration",declaration);
        setControlRow(tdRows.getWrittenInstructionsRow(), addRowView(layout,views), "14. Skriftliga instruktioner","");
        setControlRow(tdRows.getApprovalRow(), addRowView(layout,views), "15." + getString(tdRows.getApproval().label),"");
        setControlRow(tdRows.getApprovalCertificateRow(), addRowView(layout,views), "16. Godkännandecertifikat","");
        setControlRow(tdRows.getDriverCertificationRow(), addRowView(layout,views), "17.1. Förarintyg (ADR 8.2.1, 8.2.2)","");
        setControlRow(tdRows.getOtherADRTrainingRow(), addRowView(layout,views), "17.2. Annan ADR-utbildning","");
        displayViews(layout, views);
    }
    private void setTCard(View card) {
        LinearLayout layout = card.findViewById(R.id.card_rows);
        ArrayList<View> views = new ArrayList<>();
        TransportRows tRows = control.getTRows();

        setControlRow(tRows.getRow18(), addRowView(layout,views), "18. Gods tillåtet för transport","");
        setControlRow(tRows.getRow19(), addRowView(layout,views), "19. Fordonet godkänt för det transporterade godset","");
        setControlRow(tRows.getRow20(), addRowView(layout,views), "20. Bestämmelser för transportsätt","");
        setControlRow(tRows.getRow21(), addRowView(layout,views), "21. Förbud mot samlastning","");
        setControlRow(tRows.getRow22_1(), addRowView(layout,views), "22.1. Hantering","");
        setControlRow(tRows.getRow22_2(), addRowView(layout,views), "22.2. Lastning/Stuvning ","");
        setControlRow(tRows.getRow22_3(), addRowView(layout,views), "22.3. Lastsäkring","");
        setControlRow(tRows.getRow23_1(), addRowView(layout,views), "23.1. Läckage","");
        setControlRow(tRows.getRow23_2(), addRowView(layout,views), "23.2. Skador på kolli/fordon","");
        setControlRow(tRows.getRow24(), addRowView(layout,views), "24. Godkännandemärkning av kolli/tankar (ADR kapitel 6)","");
        setControlRow(tRows.getRow25_1(), addRowView(layout,views), "25.1. Märkning av kolli (5.2.1)","");
        setControlRow(tRows.getRow25_2(), addRowView(layout,views), "25.2. Ettikering av kolli (5.2.2","");
        setControlRow(tRows.getRow26(), addRowView(layout,views), "26. Storetiketter (5.3.1","");
        setControlRow(tRows.getRow27(), addRowView(layout,views), "27. Skyltning/märkning av fordon/transporthenhet","");
        setControlRow(tRows.getRow28_1(), addRowView(layout,views), "28.1. Stoppklots","");
        setControlRow(tRows.getRow28_2(), addRowView(layout,views), "28.2. Varningsanordning","");
        setControlRow(tRows.getRow28_3(), addRowView(layout,views), "28.3. Varningsväst/ögonskydd/handskar","");
        setControlRow(tRows.getRow28_4(), addRowView(layout,views), "28.4. Bärbar ljuskälla","");
        setControlRow(tRows.getRow29(), addRowView(layout,views), "29. Godsspecifik utrustning (ADR 8.1.5.2/8.1.5.3)","");
        setControlRow(tRows.getRow31(), addRowView(layout,views), "31. Brandsläckare (ADR 8.1.4.1/8.1.4.2/10.6)","");
        int counter = 1;
        for(ControlRow row : tRows.getRows40()){
            setControlRow(row, addRowView(layout,views), "40." + counter + ". " + row.getName(),"");
            counter++;
        }
        setControlRowRisk(getString(tRows.getRiskCategory().label), addRowView(layout, views));
        displayViews(layout, views);
    }

    private void setGoodsCard(View card){

        setText(cardTitle(card), "Gods");
        LinearLayout layout = card.findViewById(R.id.card_rows);
        ArrayList<View> views = new ArrayList<>();
        List<Goods> goods = control.getGoodsList();
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

    private View addCardView(List<View> views){
        View view = layoutInflater.inflate(R.layout.view_control_card, cardsLinearLayout,false);
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
    private void setControlRow(ControlRow row, View view, String title, String text){
        TextView left = view.findViewById(R.id.left);
        TextView right = view.findViewById(R.id.right);

        setControlRowLeft(row, left, title);
        setControlRowRight(row,right, text);
    }

    private void setControlRowLeft(ControlRow row, TextView textView, String title) {
        StringBuilder str = new StringBuilder();
        str.append(line("",title));
        str.append(line("Riskkategori:", row.getRiskCategory()));
        str.append(line("Anteckningar:", row.getNotes()));
        setText(textView, str.toString());

    }
    private void setControlRowRight(ControlRow row, TextView textView, String text){
        StringBuilder str = new StringBuilder();
        str.append(line("", getString(row.getField().label)));
        str.append(line("Förbud:", row.isBanned() ? "Ja" : "Nej"));
        str.append(line("Föreläggande:", row.isImposed() ? "Ja" : "Nej"));
        if(text != null){
            str.append(text);
        }
        setText(textView, str.toString());
    }

    private String address(Transporter transporter){
        StringBuilder str = new StringBuilder();
        str.append(line("Adress:", transporter.getAddress()));
        str.append(line("Postnummer:", String.valueOf(transporter.getZipNr())));
        str.append(line("Postort:", transporter.getCity()));
        str.append(line("Land:", transporter.getNationality()));
        return str.toString();
    }

    private void setText(TextView textView, String str) {
        textView.setText(Html.fromHtml(str));
    }

    private String line(String title, String data) {
        return title + " <strong>" + data + "</strong>" + "<br>";
    }
}
