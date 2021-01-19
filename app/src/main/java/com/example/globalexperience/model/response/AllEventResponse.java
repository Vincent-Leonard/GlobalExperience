package com.example.globalexperience.model.response;

import com.example.globalexperience.model.local.AllEvent;
import com.example.globalexperience.model.local.Event;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllEventResponse {
    @SerializedName("data")
    private List<AllEvent> results;

    public List<AllEvent> getResults() {
        return results;
    }
}
