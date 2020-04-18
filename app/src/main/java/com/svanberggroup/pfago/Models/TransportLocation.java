package com.svanberggroup.pfago.Models;

import java.io.Serializable;

public class TransportLocation implements Serializable {
    private String address;
    private String place;
    private String phone;

    public TransportLocation() {

    }
    public TransportLocation(String address, String place, String phone) {
        this.address = address;
        this.place = place;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
