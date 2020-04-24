package com.svanberggroup.pfago.Models;

public class RibSearchResult {

    private static int id = 0;
    private String substance = null;
    private String note = null;
    private String link = null;

    public RibSearchResult(String substance, String note, String link){
        this.substance = substance;
        this.note = note;
        this.link = link;
        id++;
    }

    public String getSubstance() {
        return substance;
    }

    public String getNote() {
        return note;
    }

    public String getLink() {
        return link;
    }
    public static int getId() { return id; }

}
