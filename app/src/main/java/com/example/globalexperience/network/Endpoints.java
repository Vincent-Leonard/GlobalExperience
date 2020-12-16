package com.example.globalexperience.network;

import com.example.globalexperience.model.response.EventResponse;
import com.example.globalexperience.model.response.TokenResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoints {

    @POST("login")
    @FormUrlEncoded
    Call<TokenResponse> login (@Field("email") String email, @Field("password") String password);

    @GET("events")
    Call<EventResponse> getEvents();

    @POST("logout")
    Call<JsonObject> logout();
}
