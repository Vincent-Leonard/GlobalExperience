package com.example.globalexperience.network;

import com.example.globalexperience.model.local.Student;
import com.example.globalexperience.model.response.AllEventResponse;
import com.example.globalexperience.model.response.EventResponse;
import com.example.globalexperience.model.response.HistoryResponse;
import com.example.globalexperience.model.response.LecturerResponse;
import com.example.globalexperience.model.response.ProfileResponse;
import com.example.globalexperience.model.response.StaffResponse;
import com.example.globalexperience.model.response.StudentResponse;
import com.example.globalexperience.model.response.TokenResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Endpoints {

    @POST("api-login")
    @FormUrlEncoded
    Call<TokenResponse> login (@Field("email") String email, @Field("password") String password);

    @GET("profile")
    Call<ProfileResponse> getProfile();

    @GET("events")
    Call<EventResponse> getEvents();

    @GET("admin")
    Call<AllEventResponse> getAllEvents();

    @GET("histories")
    Call<HistoryResponse> getHistories();

    @GET("Lecturer")
    Call<LecturerResponse> getLecturers();

    @GET("Student")
    Call<StudentResponse> getStudents();

    @GET("Staff")
    Call<StaffResponse> getStaffs();

    @POST("logout")
    Call<JsonObject> logout();

    @PUT("admin/approve/{id}")
    Call<Void> statusApprove(@Path("id") String id);

    @PUT("admin/reject/{id}")
    Call<Void> statusReject(@Path("id") String id);

    @PUT("admin/revise/{id}")
    Call<Void> statusRevise(@Path("id") String id);

    @PUT("admin/open/{id}")
    Call<Void> statusOpen(@Path("id") String id);

    @PUT("admin/close/{id}")
    Call<Void> statusClose(@Path("id") String id);
}
