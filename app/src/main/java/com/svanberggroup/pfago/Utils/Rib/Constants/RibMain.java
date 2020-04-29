package com.svanberggroup.pfago.Utils.Rib.Constants;

import android.util.Log;

public final class RibMain {
    public static final String QUERY_HINT = "Ämne; UN-nr";
    public static final String TITLE = "RIB: Farliga Ämnen";

    public static String getResultText(String searched){
        Log.i("FAILED_TERM", searched);
        return "Sökningen på " + searched + " gav inget resultat";
    }
    private RibMain(){}
}