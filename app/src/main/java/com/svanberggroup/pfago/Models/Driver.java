package com.svanberggroup.pfago.Models;

public class Driver {
    private String name;
    private String phone;
    private String address;
    private int postalNr;
    private String city;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalNr() {
        return postalNr;
    }

    public void setPostalNr(int postalNr) {
        this.postalNr = postalNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
