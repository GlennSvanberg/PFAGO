package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

public class Vehicle {
    private String regNr;
    private String nationality;

    private VehicleType vehicleType;
    public enum VehicleType{
        Truck(R.string.truck),
        Trailer(R.string.trailer),
        SemiTrailer(R.string.semi_trailer),
        Container(R.string.container);
        public final int label;
        VehicleType(int label) {
            this.label = label;
        }
    };

    public Vehicle() {

    }
    public Vehicle(String regNr, String nationality, VehicleType vehicleType) {
        this.regNr = regNr;
        this.nationality = nationality;
        this.vehicleType = vehicleType;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
