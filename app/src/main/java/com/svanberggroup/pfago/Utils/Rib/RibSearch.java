package com.svanberggroup.pfago.Utils.Rib;

import android.os.AsyncTask;

import com.svanberggroup.pfago.Models.RibSearchResult;
import com.svanberggroup.pfago.Utils.Rib.Constants.HtmlAttr;
import com.svanberggroup.pfago.Utils.Rib.Constants.RibUrl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class RibSearch {

    public ArrayList<RibSearchResult> runRequest(String query) {
        String queryNormalised = "";

        if (query.toLowerCase().contains("un")) {
            queryNormalised = query.toLowerCase().replace("un", "").trim();
        } else {
            queryNormalised = query.trim();
        }

        Document response = null;
        String formatedQuery = query.trim().toLowerCase();
        if (formatedQuery.matches("un\\d+$")){
            formatedQuery = formatedQuery.replace("un", "");
        }

        try {
            if (formatedQuery.matches("^\\d+$")) {
                response = Jsoup.connect(RibUrl.BASE + formatedQuery).get();
            } else
                response = Jsoup.connect(RibUrl.BASE + formatedQuery + "/").get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return parseResponse(response);
    }

    private ArrayList<RibSearchResult> parseResponse(Document response) {
        final ArrayList<RibSearchResult> SearchResults = new ArrayList<>();
        Elements results = response.select(HtmlAttr.RESULT);
        RibHtmlParser htmlParser = new RibHtmlParser();

        for (Element element : results) {

            SearchResults.add(new RibSearchResult(
                    htmlParser.parseSubstance(element),
                    htmlParser.parseNote(element),
                    htmlParser.parseLink(element)
            ));
        }

        return SearchResults;
    }
}

