package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

public class ControlRow {
    private int fieldNr;
    private String name;
    public enum Field{
        Controlled(R.string.controlled),
        BreakingTheLaw(R.string.breaking_the_law),
        NotApplicable(R.string.not_applicable);
        public final int label;
        Field(int label) {
            this.label = label;
        }

    };
    private Field field;
    private String riskCategory;
    private boolean imposed;
    private boolean banned;
    private String notes;

    public ControlRow() {
    }

    public ControlRow(int fieldNr, String name, Field field, String riskCategory, boolean imposed, boolean banned, String notes) {
        this.fieldNr = fieldNr;
        this.name = name;
        this.field = field;
        this.riskCategory = riskCategory;
        this.imposed = imposed;
        this.banned = banned;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFieldNr() {
        return fieldNr;
    }

    public void setFieldNr(int fieldNr) {
        this.fieldNr = fieldNr;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isImposed() {
        return imposed;
    }

    public void setImposed(boolean imposed) {
        this.imposed = imposed;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
