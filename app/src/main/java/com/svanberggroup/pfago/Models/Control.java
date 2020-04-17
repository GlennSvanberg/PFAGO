package com.svanberggroup.pfago.Models;

import java.util.Date;

public class Control {

    private int number;
    private Date date;
    private String place;
    private String type;

    private Vehicle vehicle;
    private Party company;
    private Party driver;
    private Party passenger;

    private Location sender;
    private Location receiver;

    public Control() {
        date = new Date();
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Party getCompany() {
        return company;
    }

    public void setCompany(Party company) {
        this.company = company;
    }

    public Party getDriver() {
        return driver;
    }

    public void setDriver(Party driver) {
        this.driver = driver;
    }

    public Party getPassenger() {
        return passenger;
    }

    public void setPassenger(Party passenger) {
        this.passenger = passenger;
    }

    public Location getSender() {
        return sender;
    }

    public void setSender(Location sender) {
        this.sender = sender;
    }

    public Location getReceiver() {
        return receiver;
    }

    public void setReceiver(Location receiver) {
        this.receiver = receiver;
    }
}
