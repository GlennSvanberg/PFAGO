package com.svanberggroup.pfago.Models;

public class Goods {
    private String position;
    private String unNr;
    private String description;
    private String label;
    private String PG;
    private int qty;
    private String wayBill;

    public Goods(String position, String unNr, String description, String label, String PG, int qty, String wayBill) {
        this.position = position;
        this.unNr = unNr;
        this.description = description;
        this.label = label;
        this.PG = PG;
        this.qty = qty;
        this.wayBill = wayBill;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUnNr() {
        return unNr;
    }

    public void setUnNr(String unNr) {
        this.unNr = unNr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPG() {
        return PG;
    }

    public void setPG(String PG) {
        this.PG = PG;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getWayBill() {
        return wayBill;
    }

    public void setWayBill(String wayBill) {
        this.wayBill = wayBill;
    }
}
