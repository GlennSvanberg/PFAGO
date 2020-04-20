package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.text.SimpleDateFormat;

public class ViewControlActivity extends AppCompatActivity {
    private Control control;
    private TextView controlBodyLeft, controlBodyRight, vehicleHeader, vehicleBodyLeft, vehicleBodyRight, carrierBodyLeft, carrierBodyRight, driverBodyLeft, driverBodyRight, passengerBodyLeft, passengerBodyRight, locationBodyLeft, locationBodyRight;


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
        driverBodyLeft = findViewById(R.id.driver_card_body_left);
        driverBodyRight = findViewById(R.id.driver_card_body_right);
        passengerBodyLeft = findViewById(R.id.passenger_card_body_left);
        passengerBodyRight = findViewById(R.id.passenger_card_body_right);
        locationBodyLeft = findViewById(R.id.locations_card_body_left);
        locationBodyRight = findViewById(R.id.locations_card_body_right);


        setTextFields();

    }
    private void setTextFields() {

        setControlBodyTextLeft();
        setControlBodyTextRight();
        setVehicleBodyTextLeft();
        setVehicleBodyTextRight();
        setCarrierBodyTextLeft();
        setCarrierBodyTextRight();
        setDriverBodyTextLeft();
        setDriverBodyTextRight();
        setPassengerBodyTextLeft();
        setPassengerBodyTextRight();
        setLocationBodyTextLeft();
        setLocationBodyTextRight();
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

    private void setDriverBodyTextLeft() {
        StringBuilder str = new StringBuilder();

        str.append(line("Förare:", control.getDriver().getName()));
        str.append(line("Tel:", control.getDriver().getPhone()));

        driverBodyLeft.setText(Html.fromHtml(str.toString()));
    }

    private void setDriverBodyTextRight(){
        String str = address(control.getDriver());
        driverBodyRight.setText(Html.fromHtml(str));
    }

    private void setPassengerBodyTextLeft() {
        StringBuilder str = new StringBuilder();

        str.append(line("Besättning:", control.getPassenger().getName()));
        str.append(line("Tel:", control.getPassenger().getPhone()));

        passengerBodyLeft.setText(Html.fromHtml(str.toString()));
    }

    private void setPassengerBodyTextRight(){
        String str = (address(control.getPassenger()));
        passengerBodyRight.setText(Html.fromHtml(str));
    }

    private void setLocationBodyTextLeft() {
        StringBuilder str = new StringBuilder();
        str.append(line("", "Avsändare"));
        str.append(line("Adress:", control.getSender().getAddress()));
        str.append(line("Lastplats:", control.getSender().getPlace()));
        str.append(line("Telefon:", control.getSender().getPhone()));
        locationBodyLeft.setText(Html.fromHtml(str.toString()));
    }
    private void setLocationBodyTextRight() {
        StringBuilder str = new StringBuilder();
        str.append(line("", "Mottagare"));
        str.append(line("Adress:", control.getReceiver().getAddress()));
        str.append(line("Lossnigsplats:", control.getReceiver().getPlace()));
        str.append(line("Telefon:", control.getReceiver().getPhone()));
        locationBodyRight.setText(Html.fromHtml(str.toString()));
    }

    private String address(Transporter transporter){
        StringBuilder str = new StringBuilder();
        str.append(line("Adress:", transporter.getAddress()));
        str.append(line("Postnummer:", String.valueOf(transporter.getZipNr())));
        str.append(line("Postort:", transporter.getCity()));
        str.append(line("Land:", transporter.getNationality()));
        return str.toString();
    }



    private String title(String title) {
        return  title + "<br>";
    }
    private String line(String title, String data) {
        return title + " <strong>" + data + "</strong>" + "<br>";
    }


}
