package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.text.SimpleDateFormat;

public class ViewControlActivity extends AppCompatActivity {
    private Control control;
    private TextView controlBodyLeft, controlBodyRight, vehicleHeader, vehicleBodyLeft, vehicleBodyRight, carrierBodyLeft, carrierBodyRight, senderText, receiverText;
    private TextView driverText, passengerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_control);
        int id = getIntent().getIntExtra("control_id", 0);

        ControlRepository repo = ControlRepository.get();
        control = repo.getControlById(id);

        controlBodyLeft = findViewById(R.id.control_card_body_left);
        controlBodyRight = findViewById(R.id.control_card_body_right);
        vehicleHeader = findViewById(R.id.vehicle_card_header);
        vehicleBodyLeft = findViewById(R.id.vehicle_card_body_left);
        vehicleBodyRight = findViewById(R.id.vehicle_card_body_right);
        carrierBodyLeft = findViewById(R.id.carrier_card_body_left);
        carrierBodyRight = findViewById(R.id.carrier_card_body_right);

        senderText = findViewById(R.id.sender_text);
        receiverText = findViewById(R.id.receiver_text);
        driverText = findViewById(R.id.driver_text);
        passengerText = findViewById(R.id.passenger_text);


        setTextFields();

    }
    private void setTextFields() {

        setControlBodyTextLeft();
        setControlBodyTextRight();
        setVehicleBodyTextLeft();
        setVehicleBodyTextRight();
        setCarrierBodyTextLeft();
        setCarrierBodyTextRight();

        setTransporterText(control.getDriver(), "Förare", driverText);
        setTransporterText(control.getPassenger(), "Besättning", passengerText);

        setTransportLocationText(control.getSender(), true, senderText);
        setTransportLocationText(control.getReceiver(), false, receiverText);
    }
    private void setControlBodyTextLeft() {
        StringBuilder str = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");

        String date = formatter.format(control.getStartDate());
        String place = control.getLocation();

        str.append(line("Plats:", place));
        str.append(line("Datum:", date));

        controlBodyLeft.setText(Html.fromHtml(str.toString()));
    }
    private void setControlBodyTextRight() {
        StringBuilder str = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

        String startDate = formatter.format(control.getStartDate());
        String endDate = formatter.format(control.getEndDate());

        str.append(line("Start:", startDate));
        str.append(line("Slut:", endDate));

        controlBodyRight.setText(Html.fromHtml(str.toString()));
    }
    private void setVehicleBodyTextLeft() {
        StringBuilder str = new StringBuilder();

        str.append(title("Bil"));
        str.append(line("RegNr:", control.getTruck().getRegNr()));
        str.append(line("Nationalitet:", control.getTruck().getNationality()));

        vehicleBodyLeft.setText(Html.fromHtml(str.toString()));
    }
    private void setVehicleBodyTextRight(){
        StringBuilder str = new StringBuilder();

        str.append(line("", getString(control.getTrailer().getVehicleType().label)));
        str.append(line("RegNr:", control.getTrailer().getRegNr()));
        str.append(line("Nationalitet:", control.getTrailer().getNationality()));

        vehicleBodyRight.setText(Html.fromHtml(str.toString()));
    }
    private void setCarrierBodyTextLeft(){
        StringBuilder str = new StringBuilder();

        str.append(line("Företag:", control.getCarrier().getName()));
        str.append(line("Tel:", control.getCarrier().getPhone()));

        carrierBodyLeft.setText(Html.fromHtml(str.toString()));
    }

    private void setCarrierBodyTextRight(){
        String str = address(control.getCarrier());
        carrierBodyRight.setText(Html.fromHtml(str));
    }
    private void setTransporterText(Transporter transporter, String title, TextView textView) {
        StringBuilder str = new StringBuilder();

        str.append(line("", title));
        str.append(line("Namn:", transporter.getName()));
        str.append(line("Tel:", transporter.getPhone()));
        str.append(address(transporter));

        setText(textView, str);
    }

    private void setTransportLocationText(TransportLocation location, boolean isSender, TextView textView) {
        StringBuilder str = new StringBuilder();
        if(isSender) {
            str.append(title("Avsändare"));
            str.append(line("Lastplats:", location.getPlace()));
        } else {
            str.append(title("Mottagare"));
            str.append(line("Lossnigsplats:", location.getPlace()));
        }
        str.append(line("Adress:", location.getAddress()));
        str.append(line("Telefon:", location.getPhone()));

        setText(textView,str);

    }
    private String address(Transporter transporter){
        StringBuilder str = new StringBuilder();
        str.append(line("Adress:", transporter.getAddress()));
        str.append(line("Postnummer:", String.valueOf(transporter.getZipNr())));
        str.append(line("Postort:", transporter.getCity()));
        str.append(line("Land:", transporter.getNationality()));
        return str.toString();
    }

    private void setText(TextView textView, StringBuilder str) {
        textView.setText(Html.fromHtml(str.toString()));

    }

    private String title(String title) {
        return  title + "<br>";
    }
    private String line(String title, String data) {
        return title + " <strong>" + data + "</strong>" + "<br>";
    }


}
