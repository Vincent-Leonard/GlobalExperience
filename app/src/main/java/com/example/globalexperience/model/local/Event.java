package com.example.globalexperience.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Event implements Parcelable {
    @SerializedName("event_id")
    String event_id;
    @SerializedName("event")
    String name;
    @SerializedName("type")
    String type;
    @SerializedName("is_group")
    String is_group;
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
    String file;
    @SerializedName("status")
    String status;
    @SerializedName("pivot")
    private Pivot pivot;

    public Event() {
    }

    public Event(String event_id, String name, String type, String is_group, String date, String duration, String country, String city, String organizer, String file, String status, Pivot pivot) {
        this.event_id = event_id;
        this.name = name;
        this.type = type;
        this.is_group = is_group;
        this.date = date;
        this.duration = duration;
        this.country = country;
        this.city = city;
        this.organizer = organizer;
        this.file = file;
        this.status = status;
        this.pivot = pivot;
    }

    protected Event(Parcel in) {
        name = in.readString();
        type = in.readString();
        date = in.readString();
        duration = in.readString();
        country = in.readString();
        city = in.readString();
        organizer = in.readString();
        status = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
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

    public String getIs_group() {
        return is_group;
    }

    public void setIs_group(String is_group) {
        this.is_group = is_group;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(type);

        dest.writeString(event_id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(is_group);

        dest.writeString(date);
        dest.writeString(duration);
        dest.writeString(country);
        dest.writeString(city);
        dest.writeString(organizer);

        dest.writeString(file);

        dest.writeString(status);
    }
}
