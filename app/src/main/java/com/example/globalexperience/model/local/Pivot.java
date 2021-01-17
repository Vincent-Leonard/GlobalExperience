package com.example.globalexperience.model.local;

import com.google.gson.annotations.SerializedName;

public class Pivot {

    @SerializedName("is_approved")
    String approved;
    @SerializedName("user_id")
    String user;

    public Pivot(){
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Pivot(String approved, String user) {
        this.approved = approved;
        this.approved = user;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }
}
