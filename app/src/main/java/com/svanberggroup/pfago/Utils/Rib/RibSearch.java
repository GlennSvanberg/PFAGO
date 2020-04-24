package com.svanberggroup.pfago.Utils.Rib;

import android.widget.Toast;

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
    private String SearchTerm;

    public RibSearch(String searchTerm) {
        SearchTerm = searchTerm;
    }

    public ArrayList<RibSearchResult> makeRequestAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<ArrayList<RibSearchResult>> future = CompletableFuture.supplyAsync(this::runRequest);

        return future.get();
    }

    // @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<RibSearchResult> runRequest() {
        Document response = null;
        try {
            response = Jsoup.connect(RibUrl.BASE + SearchTerm + "/").get();
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
            Notes = result.select(HtmlAttr.INFO).html().replaceAll("\\<.*?\\>", "");
            Link = RibUrl.SUBSTANCE_BASE + result.select(HtmlAttr.LINK).toString().split("\"")[1].split("\"")[0];

            SearchResults.add(new RibSearchResult(Substance, Notes, Link));
        }

        return SearchResults;
    }
}

