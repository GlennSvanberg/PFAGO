package com.svanberggroup.pfago.Models;

public class Transporter {
    private String name;
    private String phone;
    private String address;
    private int ZipNr;
    private String city;
    private String nationality;

    public Transporter() {

    }
    public Transporter(String name, String phone, String address, int zipNr, String city, String nationality) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        ZipNr = zipNr;
        this.city = city;
        this.nationality = nationality;
    }

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

    public int getZipNr() {
        return ZipNr;
    }

    public void setZipNr(int zipNr) {
        ZipNr = zipNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
