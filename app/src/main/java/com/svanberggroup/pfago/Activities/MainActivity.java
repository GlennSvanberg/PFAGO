package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.svanberggroup.pfago.Models.Inspection;
import com.svanberggroup.pfago.Models.Party;
import com.svanberggroup.pfago.Models.Trailer;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Models.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Inspection> inspections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDummyData();

    }

    private void createDummyData(){

        inspections = new ArrayList<>();

        Location sender = new Location("Malmgatan 34 Halmstad", "LKAB, port 22", "0600-352362");
        Location receiver = new Location("Raketgatan Kiruna", "GKN, södra", "010-0525252");
        Party company = new Party("GLÅAB", "0522-252525", "Norra älvvägen 21B", 45130, "Uddevalla", "Sweden");
        Party driver = new Party("Göran Persson", "070-2525352", "Byälven 11A", 45130, "Borås", "Sweden");
        Trailer container = new Trailer("SE", "TTT111", "Container");
        Trailer semi = new Trailer("SE", "SSS111", "Semi");

        Vehicle truckContainer = new Vehicle("SE", "ABC123", container);
        Vehicle truckSemi = new Vehicle("SE", "ABC456", semi);

        Inspection a = new Inspection();
        a.setNumber(1);
        a.setPlace("Uddevalla");
        a.setType("väg");
        a.setVehicle(truckContainer);
        a.setCompany(company);
        a.setDriver(driver);
        a.setSender(sender);
        a.setReceiver(receiver);
        inspections.add(a);

        Inspection b = new Inspection();
        a.setNumber(2);
        a.setPlace("Göteborg");
        a.setType("Hamnterminal");
        a.setVehicle(truckSemi);
        a.setCompany(company);
        a.setDriver(driver);
        a.setSender(sender);
        a.setReceiver(receiver);

        inspections.add(b);

    }
}
