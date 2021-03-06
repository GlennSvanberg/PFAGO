package com.svanberggroup.pfago.Repository;

import android.util.Log;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.Fault;
import com.svanberggroup.pfago.Models.Goods;
import com.svanberggroup.pfago.Models.Quantity;
import com.svanberggroup.pfago.Models.SafetyAdvisor;
import com.svanberggroup.pfago.Models.TransportDocumentRows;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.TransportRows;
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
            Boolean isTruck = false;
            Boolean isTrailer = false;

            if(control.getTruck() != null){
                isTruck = control.getTruck().getRegNr().toLowerCase().equals(regNr.toLowerCase());
            }
            if(control.getTrailer() != null){
                isTrailer = control.getTrailer().getRegNr().toLowerCase().equals(regNr.toLowerCase());
            }
            Boolean isDriver = false;
            if(control.getDriver() != null){
                isDriver = control.getDriver().getSocialSecurityNumber().equals(regNr.toLowerCase());
            }
            Boolean isCarrier = false;
            if(control.getCarrier() != null){
                isCarrier = control.getCarrier().getName().toLowerCase().equals(regNr.toLowerCase());
            }
            if(isTruck || isTrailer || isDriver ||isCarrier) {
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

        // -------------------------
        Control a = new Control();
        a.setId(1);
        a.setLocation("Uddevalla");
        a.setLocationType(Control.LocationType.CargoTerminal);

        a.setEndDate(new Date());

        Transporter aCarrier = new Transporter("GLÅAB", "0522-132345", "Norra Gåvägen 14", 45123, "Borås", "SE", "");
        Transporter aDriver = new Transporter("Robin Törnqvist", "070-1234567", "Silltorp 24", 44123, "Vänersborg", "SE", "20000202-2020");
        Transporter aPassenger = new Transporter("Emil Svenson", "070-2356489", "Norra Botten 1", 45789, "Göteborg", "US","");

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

        ControlRow aGoodsDeclaration = new ControlRow("Skriftliga instruktioner", ControlRow.Field.Controlled, "Normal", false, false, "");

        ControlRow abc= new ControlRow("blaha", ControlRow.Field.BreakingTheLaw, "Hög", true, true, "Dödsfarligt");

        a.getTdRows().setDeclaration(TransportDocumentRows.Declaration.LoadingPlane);
        a.getTdRows().setApproval(TransportDocumentRows.Approval.Bilateral);
        a.getTdRows().getGoodsDeclarationRow().setField(ControlRow.Field.BreakingTheLaw);
        a.getTdRows().getGoodsDeclarationRow().setBanned(true);
        a.getTdRows().getGoodsDeclarationRow().setNotes("Detta var inte bra");
        a.getTdRows().getGoodsDeclarationRow().setRiskCategory("Turbulent");

        a.getTdRows().getDriverCertificationRow().setField(ControlRow.Field.Controlled);
        a.getTdRows().getApprovalCertificateRow().setField(ControlRow.Field.Controlled);
        a.getTdRows().getApprovalRow().setField(ControlRow.Field.NotApplicable);

        TransportRows tr = a.getTRows();


        ControlRow w = new ControlRow("Något nytt", ControlRow.Field.NotApplicable, "Udda", false, true, "Det bästaste någonsin");
        ControlRow wy = new ControlRow("Något annat", ControlRow.Field.BreakingTheLaw, "Majs", true, true, "Det braigaste någonsin");
        tr.addRow40(w);
        tr.addRow40(wy);
        controls.add(a);
        tr.setRiskCategory(TransportRows.RiskCategory.category2);


        Goods g = new Goods("A", "UN-4523", "Avgasrenad bensin", "GHL", "45", "100Kg", "Faltibt", true);
        Goods g2 = new Goods("B", "UN-5133", "Flytande kväve", "GBD", "53", "99Liter", "Faltibt", true);
        a.addGoods(g);
        a.addGoods(g2);
        Fault f = new Fault(1, "A", "Transporteras utan lock", "ADR 8.1.2.3");
        Fault f2= new Fault(2, "B", "Ingen stoppkloss", "ADR 18.11.22.3");
        a.addFault(f);
        a.addFault(f2);
        a.setSafetyAdvisorCarrier(new SafetyAdvisor(SafetyAdvisor.Answer.Yes, "Göran Stenfeldt"));
        a.setSafetyAdvisorSender(new SafetyAdvisor(SafetyAdvisor.Answer.Unknown, ""));
        a.addProhibitedField(1);
        a.addProhibitedField(1);
        a.addSubmissionFieldNr(2);
        a.setAllowedToContinueTrip(true);
        a.setDestination("Norra korsvägen 28");
        a.addSubmissionFieldNr(2);
        a.setReportedEntity(Control.ReportedEntity.Carrier);
        a.addPenalty("OF-23");


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
