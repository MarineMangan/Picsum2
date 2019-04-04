package com.vogella.android.picsum.Modèle;

import java.util.List;

public class RestPicsumResponse {
    private List<Picsum> results;

    public List<Picsum> getResults() {
        return results;
    }

    public void setResults(List<Picsum> results) {
        this.results = results;
    }
}
