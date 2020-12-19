package com.example.globalexperience.model.response;

import com.example.globalexperience.model.local.Student;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentResponse {
    @SerializedName("data")
    private List<Student> results;

    public List<Student> getResults() {
        return results;
    }
}
