package com.svanberggroup.pfago.Repository;

import android.util.Log;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Quantity;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.Models.Vehicle;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ControlRepository {

    private static ControlRepository controlRepository;

    private List<Control> controls;

    public static ControlRepository get() {
        if(controlRepository == null) {
            controlRepository = new ControlRepository();
            Log.i("TEST", "new repo created");
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
            Boolean isTruck = control.getTruck().getRegNr().toLowerCase().equals(regNr.toLowerCase());
            Boolean isTrailer = control.getTrailer().getRegNr().toLowerCase().equals(regNr.toLowerCase());

            if(isTruck || isTrailer) {
                matchedControls.add(control);
            }
        }
        return matchedControls;
    }

    public Control getControlById(int id) {
        for(Control control : controls) {
            if (control.getId() == id) {
                return control;
            }
        }
        return null;
    }
    public void addControl(Control control) {
        controls.add(control);
    }


    private void dummyData() {
        // -------------------------a
        Control a = new Control();
        a.setId(1);
        a.setLocation("Uddevalla");
        a.setLocationType(Control.LocationType.CargoTerminal);

        a.setEndDate(new Date());

        Transporter aCarrier = new Transporter("GLÅAB", "0522-132345", "Norra Gåvägen 14", 45123, "Borås", "SE");
        Transporter aDriver = new Transporter("Robin Törnqvist", "070-1234567", "Silltorp 24", 44123, "Vänersborg", "SE");
        Transporter aPassenger = new Transporter("Emil Svenson", "070-2356489", "Norra Botten 1", 45789, "Göteborg", "US");

        a.setCarrier(aCarrier);
        a.setDriver(aDriver);
        a.setPassenger(aPassenger);

        Vehicle aTruck = new Vehicle("ABC123", "SE", Vehicle.VehicleType.Truck);
        Vehicle aTrailer = new Vehicle("ABC456", "SE", Vehicle.VehicleType.Trailer);

        a.setTruck(aTruck);
        a.setTrailer(aTrailer);
        TransportLocation aSender = new TransportLocation("Södertull 14" , "Port 24", "042-4561232");
        TransportLocation aReceiver = new TransportLocation("Norgården 54" , "Yttre gången", "0542-458798");

        a.setSender(aSender);
        a.setReceiver(aReceiver);

        Quantity aQuantity = new Quantity(400, Quantity.QuantityType.KG, Quantity.PackagingStandard.EQ);
        a.setQuantity(aQuantity);
        a.setValueQuantityExceeded(false);
        a.setValueQuantity(400);

        a.setTransportType(Control.TransportType.Bulk);
        a.setTransportStandard(Control.TransportStandard.ADRS);
        controls.add(a);


        //------------------------b
        Control b = new Control();
        b.setId(2);
        b.setLocation("Trollhättan");
        b.setLocationType(Control.LocationType.CargoTerminal);
        b.setEndDate(new Date());

        b.setCarrier(aCarrier);
        b.setDriver(aDriver);
        b.setPassenger(aPassenger);

        Vehicle bTruck = new Vehicle("BCA123", "SE", Vehicle.VehicleType.Truck);
        Vehicle bTrailer = new Vehicle("BCA456", "SE", Vehicle.VehicleType.SemiTrailer);

        b.setTruck(bTruck);
        b.setTrailer(bTrailer);

        b.setSender(aSender);
        b.setReceiver(aReceiver);

        Quantity bQuantity = new Quantity(9000, Quantity.QuantityType.Liter, Quantity.PackagingStandard.LQ);
        b.setQuantity(bQuantity);
        b.setValueQuantityExceeded(true);
        b.setValueQuantity(9000);

        b.setTransportType(Control.TransportType.Tank);
        b.setTransportStandard(Control.TransportStandard.ADRS);
        controls.add(b);

        //------------------------c
        Control c = new Control();
        c.setId(3);
        c.setLocation("Stenungsund");
        c.setLocationType(Control.LocationType.CargoTerminal);
        c.setEndDate(new Date());

        c.setCarrier(aCarrier);
        c.setDriver(aDriver);
        c.setPassenger(aPassenger);

        Vehicle cTruck = new Vehicle("CCA123", "SE", Vehicle.VehicleType.Truck);
        Vehicle cTrailer = new Vehicle("CCA456", "SE", Vehicle.VehicleType.Container);

        c.setTruck(cTruck);
        c.setTrailer(cTrailer);

        c.setSender(aSender);
        c.setReceiver(aReceiver);

        Quantity cQuantity = new Quantity(90000, Quantity.QuantityType.KG, Quantity.PackagingStandard.LQ);
        c.setQuantity(cQuantity);
        c.setValueQuantityExceeded(true);
        c.setValueQuantity(90000);

        c.setTransportType(Control.TransportType.Bulk);
        c.setTransportStandard(Control.TransportStandard.ADR);
        controls.add(c);


    }
}
