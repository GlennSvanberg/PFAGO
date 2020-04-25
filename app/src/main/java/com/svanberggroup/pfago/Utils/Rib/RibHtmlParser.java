package com.svanberggroup.pfago.Utils.Rib;

import com.svanberggroup.pfago.Utils.Rib.Constants.HtmlAttr;
import com.svanberggroup.pfago.Utils.Rib.Constants.RibUrl;

import org.jsoup.nodes.Element;

public class RibHtmlParser {
    private String substance;

    public String parseSubstance(Element element){
       substance = element.select(HtmlAttr.LINK).html().split(">")[1].split("<")[0];
       return substance;
    }

    public String parseNote(Element element){
      return element.select(HtmlAttr.INFO).html().replaceAll("\\<.*?\\>", "").replace(", ", "\n\n");
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
