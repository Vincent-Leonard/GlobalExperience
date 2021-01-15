package com.example.globalexperience.model.local;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    String email;

    @SerializedName("role")
    String role;

    @SerializedName("is_admin")
    String admin;

    @SerializedName("student")
    private Student studentResults;

    @SerializedName("lecturer")
    private Lecturer lecturerResults;

    @SerializedName("staff")
    private Staff staffResults;

    public Student getStudentResults() {
        return studentResults;
    }

    public User(){
    }

    public Lecturer getLecturerResults() {
        return lecturerResults;
    }

    public void setLecturerResults(Lecturer lecturerResults) {
        this.lecturerResults = lecturerResults;
    }

    public Staff getStaffResults() {
        return staffResults;
    }

    public void setStaffResults(Staff staffResults) {
        this.staffResults = staffResults;
    }

    public User(String email, String role, String admin, Student studentResults, Lecturer lecturerResults, Staff staffResults) {
        this.email = email;
        this.role = role;
        this.admin = admin;
        this.studentResults = studentResults;
        this.lecturerResults = lecturerResults;
        this.staffResults = staffResults;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
