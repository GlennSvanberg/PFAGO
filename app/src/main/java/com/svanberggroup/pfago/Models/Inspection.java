package com.svanberggroup.pfago.Models;

import java.util.Date;

public class Inspection {

    private int number;
    private Date date;
    private String place;
    private String type;

    private Vehicle vehicle;
    private Driver company;
    private Driver driver;
    private Driver passenger;

    private Location sender;
    private Location receiver;



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

    public Driver getCompany() {
        return company;
    }

    public void setCompany(Driver company) {
        this.company = company;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getPassenger() {
        return passenger;
    }

    public void setPassenger(Driver passenger) {
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
