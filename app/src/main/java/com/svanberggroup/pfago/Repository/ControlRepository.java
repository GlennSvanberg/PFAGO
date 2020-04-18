package com.svanberggroup.pfago.Repository;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Location;
import com.svanberggroup.pfago.Models.Party;
import com.svanberggroup.pfago.Models.Trailer;
import com.svanberggroup.pfago.Models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ControlRepository {

    private static ControlRepository controlRepository;

    private List<Control> controls;

    public static ControlRepository get() {
        if(controlRepository == null) {
            controlRepository = new ControlRepository();
        }
        return controlRepository;
    }

    private ControlRepository(){
        controls = new ArrayList<>();
        dummyData();
    }
    public List<Control> getAllControls() {
        return controls;
    }
    public List<Control> getControlsByRegNr(String regNr) {
        List<Control> matchedControls = new ArrayList<>();
        for(Control control : controls) {
            if(control.getVehicle().getRegNr().equals(regNr)) {
                matchedControls.add(control);
            }
        }
        return matchedControls;
    }

    public void addControl(Control control) {
        controls.add(control);
    }

    private void dummyData() {

        Location sender = new Location("Malmgatan 34 Halmstad", "LKAB, port 22", "0600-352362");
        Location receiver = new Location("Raketgatan Kiruna", "GKN, södra", "010-0525252");
        Party company = new Party("GLÅAB", "0522-252525", "Norra älvvägen 21B", 45130, "Uddevalla", "Sweden");
        Party driver = new Party("Göran Persson", "070-2525352", "Byälven 11A", 45130, "Borås", "Sweden");
        Trailer container = new Trailer("SE", "TTT111", "Container");
        Trailer semi = new Trailer("SE", "SSS111", "Semi");

        Vehicle truckContainer = new Vehicle("SE", "ABC123", container);
        Vehicle truckSemi = new Vehicle("SE", "ABC456", semi);

        Control a = new Control();
        a.setNumber(1);
        a.setPlace("Uddevalla");
        a.setType("väg");
        a.setVehicle(truckContainer);
        a.setCompany(company);
        a.setDriver(driver);
        a.setSender(sender);
        a.setReceiver(receiver);
        controls.add(a);

        Control b = new Control();
        b.setNumber(2);
        b.setPlace("Göteborg");
        b.setType("Hamnterminal");
        b.setVehicle(truckSemi);
        b.setCompany(company);
        b.setDriver(driver);
        b.setSender(sender);
        b.setReceiver(receiver);
        controls.add(b);
    }
}
