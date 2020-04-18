package com.svanberggroup.pfago.Models;

import java.util.Date;

public class Control {

    private int id;
    private Date date;
    private String location;

    public enum LocationType{ CargoTerminal, CompanyVisit, Road, PortTerminal, System };
    private LocationType locationType;

    private Transporter carrier;
    private Transporter driver;
    private Transporter passenger;

    private Vehicle truck;
    private Vehicle trailer;

    private Quantity quantity;
    private boolean valueQuantityExceeded;
    private int valueQuantity;

    public enum TransportType{ Tank, Bulk, MixedCargo, Other };
    private TransportType transportType;

    public enum TransportStandard{ ADR, ADR_S, IMDG, ICAO, RID, RID_S, MoU, Other };
    private TransportStandard transportStandard;


    public Control() {
        date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Transporter getCarrier() {
        return carrier;
    }

    public void setCarrier(Transporter carrier) {
        this.carrier = carrier;
    }

    public Transporter getDriver() {
        return driver;
    }

    public void setDriver(Transporter driver) {
        this.driver = driver;
    }

    public Transporter getPassenger() {
        return passenger;
    }

    public void setPassenger(Transporter passenger) {
        this.passenger = passenger;
    }

    public Vehicle getTruck() {
        return truck;
    }

    public void setTruck(Vehicle truck) {
        this.truck = truck;
    }

    public Vehicle getTrailer() {
        return trailer;
    }

    public void setTrailer(Vehicle trailer) {
        this.trailer = trailer;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public boolean isValueQuantityExceeded() {
        return valueQuantityExceeded;
    }

    public void setValueQuantityExceeded(boolean valueQuantityExceeded) {
        this.valueQuantityExceeded = valueQuantityExceeded;
    }

    public int getValueQuantity() {
        return valueQuantity;
    }

    public void setValueQuantity(int valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public TransportStandard getTransportStandard() {
        return transportStandard;
    }

    public void setTransportStandard(TransportStandard transportStandard) {
        this.transportStandard = transportStandard;
    }
}
