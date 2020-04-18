package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

public class ViewControlActivity extends AppCompatActivity {
    Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_control);
        int position = getIntent().getIntExtra("position", 0);

        ControlRepository repo = ControlRepository.get();
        control = repo.getControlById(position);
        Toast.makeText(getApplicationContext(), "nr: " + position + " reg: " + control.getTruck().getRegNr() , Toast.LENGTH_LONG).show();
    }
}
