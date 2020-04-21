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
import com.svanberggroup.pfago.Models.Quantity;
import com.svanberggroup.pfago.Models.TransportDocumentRows;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewControlActivity extends AppCompatActivity {
    private Control control;
    private TextView headerLeft, headerRight, truckText, trailerText, carrierTextLeft, carrierTextRight, senderText, receiverText;
    private TextView driverText, passengerText, cargoTextLeft, cargoTextRight, goodsDeclarationLeft, goodsDeclarationRight, writtenInstructionsLeft, writtenInstructionsRight;
    private TextView approvalRowLeft, approvalRowRight, approvalCertificateRowLeft, approvalCertificateRowRight, driverCertificateRowLeft, driverCertificateRowRight, otherTrainingRowLeft, otherTrainingRowRight;
    private LinearLayout transportDocumentRows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_control);
        int id = getIntent().getIntExtra("control_id", 0);

        ControlRepository repo = ControlRepository.get();
        control = repo.getControlById(id);

        headerLeft = findViewById(R.id.control_card_body_left);
        headerRight = findViewById(R.id.control_card_body_right);

        truckText = findViewById(R.id.truck_text);
        trailerText = findViewById(R.id.trailer_text);
        carrierTextLeft = findViewById(R.id.carrier_text_left);
        carrierTextRight = findViewById(R.id.carrier_text_right);

        senderText = findViewById(R.id.sender_text);
        receiverText = findViewById(R.id.receiver_text);
        driverText = findViewById(R.id.driver_text);
        passengerText = findViewById(R.id.passenger_text);
        cargoTextLeft = findViewById(R.id.cargo_text_left);
        cargoTextRight = findViewById(R.id.cargo_text_right);

        transportDocumentRows = findViewById(R.id.transport_document_rows);

        setTextFields();

    }
    private void setTextFields() {

        setHeader();

        setVehicleText(control.getTruck(), truckText);
        setVehicleText(control.getTrailer(), trailerText);
        setCarrierText();

        setTransporterText(control.getDriver(), "Förare", driverText);
        setTransporterText(control.getPassenger(), "Besättning", passengerText);

        setTransportLocationText(control.getSender(), true, senderText);
        setTransportLocationText(control.getReceiver(), false, receiverText);
        setCargo();

        setTdRows(transportDocumentRows, control.getTdRows());

    }
    private void setTdRows(LinearLayout linearLayout, TransportDocumentRows tdRows) {
        ArrayList<View> rows = new ArrayList<>();

        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        View view = layoutInflater.inflate(R.layout.view_control_row_first, linearLayout,false);
        rows.add(view);
        String declaration = Html.fromHtml(line("", getString(tdRows.getDeclaration().label))).toString();
        setControlRow(tdRows.getGoodsDeclarationRow(), view, "13. Godsdeklaration",declaration);

        view = layoutInflater.inflate(R.layout.view_control_row, linearLayout,false);
        setControlRow(tdRows.getWrittenInstructionsRow(), view, "14. Skriftliga instruktioner","");
        rows.add(view);

        view = layoutInflater.inflate(R.layout.view_control_row, linearLayout,false);
        setControlRow(tdRows.getApprovalRow(), view, "15." + getString(tdRows.getApproval().label),"");
        rows.add(view);

        view = layoutInflater.inflate(R.layout.view_control_row, linearLayout,false);
        setControlRow(tdRows.getApprovalCertificateRow(), view, "16. Godkännandecertifikat","");
        rows.add(view);

        view = layoutInflater.inflate(R.layout.view_control_row, linearLayout,false);
        setControlRow(tdRows.getDriverCertificationRow(), view, "17. Förarintyg (ADR 8.2.1, 8.2.2)","");
        rows.add(view);

        view = layoutInflater.inflate(R.layout.view_control_row, linearLayout,false);
        setControlRow(tdRows.getOtherADRTrainingRow(), view, "18. Annan ADR-utbildning","");
        rows.add(view);

        for(View v : rows) {
            linearLayout.addView(v);
        }
    }



    private void setHeader() {
        StringBuilder str = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");

        String date = formatter.format(control.getStartDate());
        String place = control.getLocation();

        str.append(line("Datum:", date));
        str.append(line("Plats:", place));
        str.append(line("Platstyp:", getString(control.getLocationType().label)));
        setText(headerLeft, str.toString());

        str = new StringBuilder();
        formatter = new SimpleDateFormat("HH:mm");

        String startDate = formatter.format(control.getStartDate());
        String endDate = formatter.format(control.getEndDate());

        str.append(line("Start:", startDate));
        str.append(line("Slut:", endDate));

        setText(headerRight, str.toString());
    }

    private void setVehicleText(Vehicle vehicle, TextView textView) {
        StringBuilder str = new StringBuilder();

        str.append(line("", getString(vehicle.getVehicleType().label)));
        str.append(line("RegNr:", vehicle.getRegNr()));
        str.append(line("Nationalitet:", vehicle.getNationality()));

        setText(textView, str.toString());
    }

    private void setCarrierText(){
        StringBuilder str = new StringBuilder();

        str.append(line("Företag:", control.getCarrier().getName()));
        str.append(line("Tel:", control.getCarrier().getPhone()));

        setText(carrierTextLeft, str.toString());
        setText(carrierTextRight, address(control.getCarrier()));
    }

    private void setTransporterText(Transporter transporter, String title, TextView textView) {
        StringBuilder str = new StringBuilder();

        str.append(line("", title));
        str.append(line("Namn:", transporter.getName()));
        str.append(line("Tel:", transporter.getPhone()));
        str.append(address(transporter));

        setText(textView, str.toString());
    }

    private void setTransportLocationText(TransportLocation location, boolean isSender, TextView textView) {
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

        setText(textView,str.toString());
    }

    private void setCargo() {
        StringBuilder str = new StringBuilder();
        Quantity qty = control.getQuantity();
        str.append(line("Mängd:", qty.getQuantity() + getString(qty.getQuantityType().label)));
        str.append(line("Standard:", getString(qty.getPackagingStandard().label)));
        str.append(line("Värdeberäknad mängd:", "" + control.getValueQuantity()));
        String exceeded;
        if(control.isValueQuantityExceeded()) {
            exceeded = "Ja";
        } else {
            exceeded = "Nej";
        }
        str.append(line("Överskriden:", exceeded));
        setText(cargoTextLeft, str.toString());

        str = new StringBuilder();
        str.append(line("Transport med:", getString(control.getTransportType().label)));
        str.append(line("Transport enligt:", getString(control.getTransportStandard().label)));
        setText(cargoTextRight, str.toString());
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

    private String title(String title) {
        return  title + "<br>";
    }
    private String line(String title, String data) {
        return title + " <strong>" + data + "</strong>" + "<br>";
    }

}
