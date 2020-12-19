package com.example.globalexperience.model.response;

import com.example.globalexperience.model.local.Staff;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StaffResponse {
    @SerializedName("data")
    private List<Staff> results;

    public List<Staff> getResults() {
        return results;
    }
}
