package com.svanberggroup.pfago.Utils.Rib;

import android.util.Log;

import com.svanberggroup.pfago.Utils.Rib.Constants.HtmlAttr;
import com.svanberggroup.pfago.Utils.Rib.Constants.RibUrl;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RibHtmlParser {
    private String substance;

    public String parseSubstance(Element element) {
        substance = element.select(HtmlAttr.LINK).html().split(">")[1].split("<")[0];
        return substance;
    }

    public ArrayList<String> parseNote(Element element) {
        ArrayList<String> notes = new ArrayList<>();
        String noteSelected = element.select(HtmlAttr.INFO).html().replaceAll("\\<.*?\\>", "");

        if (noteSelected.contains(",")) {
            String[] noteSplit = noteSelected.split(", ");
            for (String note : noteSplit) {
                if (note == null || note.isEmpty()) break;
                notes.add(note.trim());
            }
        } else {
            String subCategory = "Underställt," + noteSelected.replace("(", "").replace(")", "");
            String[] subCategorySplit = subCategory.split(",");
            notes.addAll(Arrays.asList(subCategorySplit));
        }
        return notes;
    }

    //Substance must be allocated
    public String parseLink(Element element) {
        String substanceID = element.select(HtmlAttr.LINK).toString();
        String substanceParsed;

        if (substance.contains(",")) {
            substanceParsed = substance.trim().split(",")[0];
        } else
            substanceParsed = substance;

        return RibUrl.SUBSTANCE_BASE + substanceID.
                split("=\"", 2)[1].split("&a")[0] + "&q=" + substanceParsed + "&p=1";
    }

}
