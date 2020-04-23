package com.svanberggroup.pfago.Models;

import java.io.Serializable;

public class Fault implements Serializable {
    private int fieldNr;
    private String goodsPos;
    private String fault;
    private String marginal;

    public Fault(int fieldNr, String goodsPos, String fault, String marginal) {
        this.fieldNr = fieldNr;
        this.goodsPos = goodsPos;
        this.fault = fault;
        this.marginal = marginal;
    }

    public int getFieldNr() {
        return fieldNr;
    }

    public void setFieldNr(int fieldNr) {
        this.fieldNr = fieldNr;
    }

    public String getGoodsPos() {
        return goodsPos;
    }

    public void setGoodsPos(String goodsPos) {
        this.goodsPos = goodsPos;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getMarginal() {
        return marginal;
    }

    public void setMarginal(String marginal) {
        this.marginal = marginal;
    }
}
