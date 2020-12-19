package com.example.globalexperience.model.local;

import com.google.gson.annotations.SerializedName;

public class Lecturer {
    @SerializedName("nip")
    String nip;
    @SerializedName("nidn")
    String nidn;
    @SerializedName("lecturer_name")
    String lecturer_name;
    @SerializedName("lecturer_email")
    String lecturer_email;
    @SerializedName("description")
    String description;
    @SerializedName("lecturer_photo")
    String lecturer_photo;
    @SerializedName("lecturer_gender")
    String lecturer_gender;
    @SerializedName("lecturer_phone")
    String lecturer_phone;
    @SerializedName("lecturer_line_account")
    String lecturer_line_account;

    public Lecturer(){
    }

    public Lecturer(String nip, String nidn, String lecturer_name, String lecturer_email, String description, String lecturer_photo, String lecturer_gender, String lecturer_phone, String lecturer_line_account) {
        this.nip = nip;
        this.nidn = nidn;
        this.lecturer_name = lecturer_name;
        this.lecturer_email = lecturer_email;
        this.description = description;
        this.lecturer_photo = lecturer_photo;
        this.lecturer_gender = lecturer_gender;
        this.lecturer_phone = lecturer_phone;
        this.lecturer_line_account = lecturer_line_account;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
