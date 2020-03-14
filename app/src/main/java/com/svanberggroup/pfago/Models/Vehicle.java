package com.svanberggroup.pfago.Models;

public class Vehicle {
    private String nationality;
    private String regNr;
    private Trailer trailer;

    public Vehicle(String nationality, String regNr) {
        this.nationality = nationality;
        this.regNr = regNr;
    }

    public Vehicle(String nationality, String regNr, Trailer trailer) {
        this(nationality, regNr);
        this.trailer = trailer;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }
}
