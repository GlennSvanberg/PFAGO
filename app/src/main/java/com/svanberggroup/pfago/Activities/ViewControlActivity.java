package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

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
        Toast.makeText(getApplicationContext(), "id: " + id + " reg: " + control.getTruck().getRegNr() , Toast.LENGTH_LONG).show();

        textView = findViewById(R.id.textView);
        String text = "Företag: " + control.getCarrier().getName() + " Tel: " + control.getCarrier().getPhone() + "\n";
        text = text + "Adress: " + control.getCarrier().getAddress() + control.getCarrier().getCity() + " " + control.getCarrier().getZipNr() + "\n";
        text = text + "Fordon: " + control.getTruck().getRegNr() + " Typ: " + control.getTruck().getVehicleType() + "Nationalitet: " + control.getTruck().getNationality() + "\n";
        text = text + "Förare: " + control.getDriver().getName() + "Tel: " + control.getDriver().getPhone() + "\n" + "Passagerare: " + control.getPassenger().getName() + "Tel: " + control.getPassenger().getPhone() + "\n";
        text = text + "Mängdenhet: " + getString(control.getQuantity().getQuantityType().label);
        textView.setText(text);

    }
}
