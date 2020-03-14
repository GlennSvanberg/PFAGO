package com.svanberggroup.pfago.Models;


public class Trailer extends Vehicle {
    private String type; // semi, trailer or container

    public Trailer(String nationality, String regNr, String type) {
        super(nationality, regNr);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

