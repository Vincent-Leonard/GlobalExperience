package com.example.globalexperience.model.response;

import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.History;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryResponse {
    @SerializedName("data")
    private List<History> results;

    public List<History> getResults() {
        return results;
    }
}
