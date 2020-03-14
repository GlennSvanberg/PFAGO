package com.svanberggroup.pfago.Models;

public class Location {
    private String address;
    private String location;
    private String phone;

    public Location(String address, String location, String phone) {
        this.address = address;
        this.location = location;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
