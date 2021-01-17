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
    @SerializedName("department")
    private Department department;

    public Lecturer(){
    }

    public Lecturer(String nip, String nidn, String lecturer_name, String lecturer_email, String description, String lecturer_photo, String lecturer_gender, String lecturer_phone, String lecturer_line_account, Department department) {
        this.nip = nip;
        this.nidn = nidn;
        this.lecturer_name = lecturer_name;
        this.lecturer_email = lecturer_email;
        this.description = description;
        this.lecturer_photo = lecturer_photo;
        this.lecturer_gender = lecturer_gender;
        this.lecturer_phone = lecturer_phone;
        this.lecturer_line_account = lecturer_line_account;
        this.department = department;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public String getLecturer_email() {
        return lecturer_email;
    }

    public void setLecturer_email(String lecturer_email) {
        this.lecturer_email = lecturer_email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLecturer_photo() {
        return lecturer_photo;
    }

    public void setLecturer_photo(String lecturer_photo) {
        this.lecturer_photo = lecturer_photo;
    }

    public String getLecturer_gender() {
        return lecturer_gender;
    }

    public void setLecturer_gender(String lecturer_gender) {
        this.lecturer_gender = lecturer_gender;
    }

    public String getLecturer_phone() {
        return lecturer_phone;
    }

    public void setLecturer_phone(String lecturer_phone) {
        this.lecturer_phone = lecturer_phone;
    }

    public String getLecturer_line_account() {
        return lecturer_line_account;
    }

    public void setLecturer_line_account(String lecturer_line_account) {
        this.lecturer_line_account = lecturer_line_account;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
