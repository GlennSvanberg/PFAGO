package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.Quantity;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.text.SimpleDateFormat;
import java.util.List;

public class ViewControlActivity extends AppCompatActivity {
    private Control control;
    private TextView headerLeft, headerRight, truckText, trailerText, carrierTextLeft, carrierTextRight, senderText, receiverText;
    private TextView driverText, passengerText, cargoTextLeft, cargoTextRight;

    private LinearLayout transportDocumentLayout;

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

        transportDocumentLayout = findViewById(R.id.transport_document_layout);

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

        for(ControlRow row : control.getControlRows()) {
            addTransportDocumentRow(row);
        }

        setCargo();
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

    private void addTransportDocumentRow(ControlRow row) {
        TextView textViewText = new TextView(this);
        textViewText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textViewText.setPadding(8,8,8,0);

        TextView textViewBool = new TextView(this);
        textViewBool.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textViewBool.setPadding(8,8,8,0);

        TextView textViewNotes = new TextView(this);
        textViewNotes.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textViewNotes.setPadding(8,0,8,0);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        transportDocumentLayout.addView(linearLayout);
        transportDocumentLayout.addView(textViewNotes);
        linearLayout.addView(textViewText);
        linearLayout.addView(textViewBool);
        setTransportDocumentText(textViewText, row);
        setTransportDocumentBool(textViewBool, row);
        ImageView divider = new ImageView(this);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(8,8,8,0);

        divider.setLayoutParams(params);

        divider.setBackgroundColor(getColor(R.color.colorPrimary));
        transportDocumentLayout.addView(divider);


    }
    private void setTransportDocumentNotes(TextView textView, ControlRow row) {

        setText(textView, line("Anteckningar:", row.getNotes()));
    }
    private void setTransportDocumentText(TextView textView, ControlRow row) {
        StringBuilder str = new StringBuilder();
        str.append(line("", row.getName()));

        str.append(line("Status:", getString(row.getField().label)));
        str.append(line("Riskkategori:", row.getRiskCategory()));
        str.append(line("Anteckningar:", row.getNotes()));

        setText(textView, str.toString());
    }
    private void setTransportDocumentBool(TextView textView, ControlRow row) {
        StringBuilder str = new StringBuilder();

        str.append(line("     Föreläggande:", row.isImposed() ? "Ja" : "Nej"));
        str.append(line("    Förbud:", row.isBanned() ? "Ja" : "Nej"));



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
    private String lineNoBr(String title, String data) {
        return title + " <strong>" + data + "</strong>";
    }
    private String line(String title, String data) {
        return title + " <strong>" + data + "</strong>" + "<br>";
    }


}
