package com.example.globalexperience.model.local;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("nim")
    String nip;
    @SerializedName("student_name")
    String student_name;
    @SerializedName("student_email")
    String student_email;
    @SerializedName("batch")
    String batch;
    @SerializedName("description")
    String description;
    @SerializedName("student_photo")
    String student_photo;
    @SerializedName("student_gender")
    String student_gender;
    @SerializedName("student_phone")
    String student_phone;
    @SerializedName("student_line_account")
    String student_line_account;

    public Student(){
    }

    public Student(String nip, String student_name, String student_email, String batch, String description, String student_photo, String student_gender, String student_phone, String student_line_account) {
        this.nip = nip;
        this.student_name = student_name;
        this.student_email = student_email;
        this.batch = batch;
        this.description = description;
        this.student_photo = student_photo;
        this.student_gender = student_gender;
        this.student_phone = student_phone;
        this.student_line_account = student_line_account;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudent_photo() {
        return student_photo;
    }

    public void setStudent_photo(String student_photo) {
        this.student_photo = student_photo;
    }

    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_line_account() {
        return student_line_account;
    }

    public void setStudent_line_account(String student_line_account) {
        this.student_line_account = student_line_account;
    }
}
