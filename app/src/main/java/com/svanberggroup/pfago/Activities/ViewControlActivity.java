package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import android.widget.Toast;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.text.SimpleDateFormat;

public class ViewControlActivity extends AppCompatActivity {
    private Control control;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_control);
        int id = getIntent().getIntExtra("control_id", 0);

        ControlRepository repo = ControlRepository.get();
        control = repo.getControlById(id);

        textView = findViewById(R.id.textView);
        StringBuilder str = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String date = formatter.format(control.getDate());

        str.append("<h2>" + control.getLocation() + " - " + date + "</h2>");
        str.append("<strong>Fordon: " + control.getTruck().getNationality() + " - " + control.getTruck().getRegNr() + "</strong><br>");
        str.append(getString(control.getLocationType().label));
        if(control.getTrailer() != null) {
            str.append("<strong> Släp: </strong>" + control.getTrailer().getNationality() + " - " + control.getTrailer().getRegNr());
            str.append("<strong> Typ: </strong>" + getString(control.getTrailer().getVehicleType().label) + "<br>");
        }
        if(control.getCarrier()!= null) {
            str.append("<br><strong>Transportör: " + control.getCarrier().getName() + " </strong><br>");
            str.append("<strong>Adress:</strong> " + control.getCarrier().getAddress() + ", ");
            str.append(control.getCarrier().getZipNr() + ", ");
            str.append(control.getCarrier().getCity()+ "<br>");

            str.append("<strong>Nationalitet: </strong> " + control.getCarrier().getNationality());
            str.append(" <strong>Tel: </strong>" + control.getCarrier().getPhone() + "<br>");
        }

        if(control.getDriver()!= null) {
            str.append("<br><strong>Förare: " + control.getDriver().getName() + " </strong><br>");
            str.append("<strong>Adress:</strong> " + control.getDriver().getAddress() + ", ");
            str.append(control.getDriver().getZipNr() + ", ");
            str.append(control.getDriver().getCity()+ "<br>");

            str.append("<strong>Nationalitet: </strong> " + control.getDriver().getNationality());
            str.append(" <strong>Tel: </strong>" + control.getDriver().getPhone() + "<br>");
        }
        if(control.getPassenger()!= null) {
            str.append("<br><strong>Besättningsmedlem: " + control.getPassenger().getName() + " </strong><br>");
            str.append("<strong>Adress:</strong> " + control.getPassenger().getAddress() + ", ");
            str.append(control.getPassenger().getZipNr() + ", ");
            str.append(control.getPassenger().getCity()+ "<br>");

            str.append("<strong>Nationalitet: </strong> " + control.getPassenger().getNationality());
            str.append(" <strong>Tel: </strong>" + control.getPassenger().getPhone() + "<br>");
        }
        if(control.getSender() != null) {
            str.append("<br><strong>Avsändare: " + control.getSender().getAddress() + " </strong><br>");
            str.append("<strong>Lastplats:</strong> " + control.getSender().getPlace() + ", ");
            str.append( " <strong>Tel: </strong>" + control.getSender().getPhone() + "<br>");
        }
        if(control.getReceiver() != null) {
            str.append("<br><strong>Mottagare: " + control.getReceiver().getAddress() + " </strong><br>");
            str.append("<strong>Lastplats:</strong> " + control.getReceiver().getPlace() + ", ");
            str.append( " <strong>Tel: </strong>" + control.getReceiver().getPhone() + "<br>");
        }
        /*
        String text = "<strong>Företag:</strong> " + control.getCarrier().getName() + " Tel: " + control.getCarrier().getPhone() + "\n";
        text = text + "Adress: " + control.getCarrier().getAddress() + control.getCarrier().getCity() + " " + control.getCarrier().getZipNr() + "\n";
        text = text + "Fordon: " + control.getTruck().getRegNr() + " Typ: " + control.getTruck().getVehicleType() + "Nationalitet: " + control.getTruck().getNationality() + "\n";
        text = text + "Förare: " + control.getDriver().getName() + "Tel: " + control.getDriver().getPhone() + "\n" + "Passagerare: " + control.getPassenger().getName() + "Tel: " + control.getPassenger().getPhone() + "\n";
        text = text + "Mängdenhet: " + getString(control.getQuantity().getQuantityType().label);
        */
        Spanned spanned = Html.fromHtml(str.toString());
        textView.setText(spanned);


    }
}
