package com.svanberggroup.pfago.Utils.Rib;


import com.svanberggroup.pfago.Models.RibSearchResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RibSearch {
    private String searchTerm;

    public RibSearch(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public ArrayList<RibSearchResult> makeRequestAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<ArrayList<RibSearchResult>> future = CompletableFuture.supplyAsync(this::runRequest);

        return future.get();
    }

    public ArrayList<RibSearchResult> runRequest() {
        Document response = null;
        try {
            if (searchTerm.trim().matches("^\\d+$")) {
                response = Jsoup.connect(RibUrl.BASE + searchTerm).get();
            } else
                response = Jsoup.connect(RibUrl.BASE + searchTerm + "/").get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return parseResponse(response);
    }

    private ArrayList<RibSearchResult> parseResponse(Document response) {

        final ArrayList<RibSearchResult> SearchResults = new ArrayList<>();
        Elements results = response.select(HtmlAttr.RESULT);

        for (Element result : results) {
            String Substance = null;
            String Notes = null;
            String Link = null;

            Substance = result.select(HtmlAttr.LINK).html().split(">")[1].split("<")[0];
            Notes = result.select(HtmlAttr.INFO).html().replaceAll("\\<.*?\\>", "").replace(", ", "\n\n");
            Link = parseLink(result.select(HtmlAttr.LINK).toString(), Substance);


            SearchResults.add(new RibSearchResult(Substance, Notes, Link));
        }

        return SearchResults;
    }

    private String parseLink(String unparsedLink, String substance) {
        String substanceParsed = null;
        if (substance.contains(",")) {
            substanceParsed = substance.trim().split(",")[0];
        } else
            substanceParsed = substance;
        return RibUrl.SUBSTANCE_BASE + unparsedLink.
                split("=\"", 2)[1].split("&a")[0] + "&q=" + substanceParsed + "&p=1";
    }
}

