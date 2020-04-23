package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

public class ControlRow {
    private String name;
    private String title;
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

    public ControlRow(String name) {
        this.name = name;
    }

    public ControlRow(String title, Field field, String riskCategory, boolean imposed, boolean banned, String notes) {
        this.title = title;
        this.field = field;
        this.riskCategory = riskCategory;
        this.imposed = imposed;
        this.banned = banned;
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
