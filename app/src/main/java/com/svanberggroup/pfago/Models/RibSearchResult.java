package com.svanberggroup.pfago.Models;

import java.util.ArrayList;

public class RibSearchResult {

    private static int id = 0;
    private String substance = null;
    private ArrayList<String> note = null;
    private String link = null;

    public RibSearchResult(String substance, ArrayList<String> note, String link){
        this.substance = substance;
        this.note = note;
        this.link = link;
        id++;
    }
    public static int getId() { return id; }

    public String getSubstance() {
        return substance;
    }

    public ArrayList<String> getNote() {
        return note;
    }

    public String getLink() {
        return link;
    }
}
