package com.example.globalexperience.model.local;

import com.example.globalexperience.utils.Constants;
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
    @SerializedName("department")
    private Department department;

    public Staff(){
    }

    public Staff(String nip, String staff_name, String staff_email, String description, String staff_photo, String staff_gender, String staff_phone, String staff_line_account, Department department) {
        this.nip = nip;
        this.staff_name = staff_name;
        this.staff_email = staff_email;
        this.description = description;
        this.staff_photo = staff_photo;
        this.staff_gender = staff_gender;
        this.staff_phone = staff_phone;
        this.staff_line_account = staff_line_account;
        this.department = department;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStaff_photo() {
        return Constants.BASE_URL_IMAGE_URL_STAFF + staff_photo;
    }

    public void setStaff_photo(String staff_photo) {
        this.staff_photo = staff_photo;
    }

    public String getStaff_gender() {
        return staff_gender;
    }

    public void setStaff_gender(String staff_gender) {
        this.staff_gender = staff_gender;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getStaff_line_account() {
        return staff_line_account;
    }

    public void setStaff_line_account(String staff_line_account) {
        this.staff_line_account = staff_line_account;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
