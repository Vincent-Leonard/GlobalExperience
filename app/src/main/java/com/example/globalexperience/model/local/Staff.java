package com.example.globalexperience.model.local;

import com.google.gson.annotations.SerializedName;

public class Staff {
    @SerializedName("nip")
    String nip;
    @SerializedName("staff_name")
    String staff_name;
    @SerializedName("staff_email")
    String staff_email;
    @SerializedName("description")
    String description;
    @SerializedName("staff_photo")
    String staff_photo;
    @SerializedName("staff_gender")
    String staff_gender;
    @SerializedName("staff_phone")
    String staff_phone;
    @SerializedName("staff_line_account")
    String staff_line_account;

    public Staff(){
    }

    public Staff(String nip, String staff_name, String staff_email, String description, String staff_photo, String staff_gender, String staff_phone, String staff_line_account) {
        this.nip = nip;
        this.staff_name = staff_name;
        this.staff_email = staff_email;
        this.description = description;
        this.staff_photo = staff_photo;
        this.staff_gender = staff_gender;
        this.staff_phone = staff_phone;
        this.staff_line_account = staff_line_account;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
