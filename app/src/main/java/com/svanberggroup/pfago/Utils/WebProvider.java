package com.svanberggroup.pfago.Utils;

import com.svanberggroup.pfago.Models.RibSearchResult;
import com.svanberggroup.pfago.Utils.Rib.RibSearch;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WebProvider {

    public ArrayList<RibSearchResult> searchRib(String query){
        CompletableFuture<ArrayList<RibSearchResult>> future = CompletableFuture.supplyAsync( () -> new RibSearch().runRequest(query));

        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
