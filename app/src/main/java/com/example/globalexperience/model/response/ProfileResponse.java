package com.example.globalexperience.model.response;

import com.example.globalexperience.model.local.Student;
import com.example.globalexperience.model.local.User;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse {
    @SerializedName("data")
    private User results;

    public User getResults() {
        return results;
    }

//    @SerializedName("student")
//    private Student studentResults;
//
//    public Student getStudentResults() {
//        return studentResults;
//    }

}
