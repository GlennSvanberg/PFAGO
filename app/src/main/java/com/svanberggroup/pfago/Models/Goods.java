package com.svanberggroup.pfago.Models;

import java.io.Serializable;

public class Goods implements Serializable {
    private String position;
    private String unNr;
    private String description;
    private String label;
    private String PG;
    private String qty;
    private String wayBill;
    private boolean lq;

    public Goods(String position, String unNr, String description, String label, String PG, String qty, String wayBill, boolean lq) {
        this.position = position;
        this.unNr = unNr;
        this.description = description;
        this.label = label;
        this.PG = PG;
        this.qty = qty;
        this.wayBill = wayBill;
        this.lq = lq;
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

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getWayBill() {
        return wayBill;
    }

    public void setWayBill(String wayBill) {
        this.wayBill = wayBill;
    }

    public boolean isLq() {
        return lq;
    }

    public void setLq(boolean lq) {
        this.lq = lq;
    }
}
