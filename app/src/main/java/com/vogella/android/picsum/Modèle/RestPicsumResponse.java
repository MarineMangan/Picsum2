package com.vogella.android.picsum.Modèle;

import java.util.List;

public class RestPicsumResponse {
    private List<Picsum> result;

    public List<Picsum> getResults() {
        return result;
    }

    public void setResults(List<Picsum> results) {
        this.result = results;
    }
}
