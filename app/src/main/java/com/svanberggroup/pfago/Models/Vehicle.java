package com.svanberggroup.pfago.Models;

public class Vehicle {
    private String regNr;
    private String nationality;

    private VehicleType vehicleType;
    public enum VehicleType{ Truck, Trailer, SemiTrailer, Container };

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
