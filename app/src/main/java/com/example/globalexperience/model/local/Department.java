package com.example.globalexperience.model.local;

import com.google.gson.annotations.SerializedName;

public class Department {

    @SerializedName("initial")
    String initial;
    @SerializedName("department_name")
    String departmentName;

    public Department(){
    }

    public Department(String initial, String departmentName) {
        this.initial = initial;
        this.departmentName = departmentName;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
