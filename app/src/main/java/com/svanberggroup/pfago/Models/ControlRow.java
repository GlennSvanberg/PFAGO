package com.svanberggroup.pfago.Models;

public class ControlRow {
    private int fieldNr;
    private boolean controlled;
    private boolean breakingTheLaw;
    private boolean notApplicable;
    private String riskCategory;
    private boolean imposed;
    private boolean banned;
    private String notes;

    public ControlRow() {
    }

    public int getFieldNr() {
        return fieldNr;
    }

    public void setFieldNr(int fieldNr) {
        this.fieldNr = fieldNr;
    }

    public boolean isControlled() {
        return controlled;
    }

    public void setControlled(boolean controlled) {
        this.controlled = controlled;
    }

    public boolean isBreakingTheLaw() {
        return breakingTheLaw;
    }

    public void setBreakingTheLaw(boolean breakingTheLaw) {
        this.breakingTheLaw = breakingTheLaw;
    }

    public boolean isNotApplicable() {
        return notApplicable;
    }

    public void setNotApplicable(boolean notApplicable) {
        this.notApplicable = notApplicable;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
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
