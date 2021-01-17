package com.example.globalexperience.model.local;

import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Text;

public class Event {
    @SerializedName("event")
    String name;
    @SerializedName("type")
    String type;
    @SerializedName("event_date")
    String date;
    @SerializedName("duration")
    String duration;
    @SerializedName("country")
    String country;
    @SerializedName("city")
    String city;
    @SerializedName("organizer")
    String organizer;
    @SerializedName("file")
    Text file;
    @SerializedName("status")
    String status;
    @SerializedName("pivot")
    private Pivot pivot;

    public Event() {
    }

    public Event(String name, String type, String date, String duration, String country, String city, String organizer, Text file, String status, Pivot pivot) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.duration = duration;
        this.country = country;
        this.city = city;
        this.organizer = organizer;
        this.file = file;
        this.status = status;
        this.pivot = pivot;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Text getFile() {
        return file;
    }

    public void setFile(Text file) {
        this.file = file;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
