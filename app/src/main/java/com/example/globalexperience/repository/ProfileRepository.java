package com.example.globalexperience.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.User;
import com.example.globalexperience.model.response.EventResponse;
import com.example.globalexperience.model.response.ProfileResponse;
import com.example.globalexperience.model.response.StudentResponse;
import com.example.globalexperience.network.RetrofitService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository(String token) {
        Log.d(TAG, "ProfileRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProfileRepository getInstance(String token) {
        if (profileRepository == null) {
            profileRepository = new ProfileRepository(token);
        }
        return profileRepository;
    }

    public synchronized void resetInstance() {
        if (profileRepository != null) {
            profileRepository = null;
        }
    }

    public LiveData<String> logout() {
        MutableLiveData<String> message = new MutableLiveData<>();

        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: " + msg);
                            message.postValue(msg);
                            resetInstance();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
        return message;
    }

    public MutableLiveData<User> getUser() {
        MutableLiveData<User> userProfile = new MutableLiveData<>();
        Log.d(TAG, "Mutable");

        apiService.getProfile().enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: Program " + response.body().getResults());
                        userProfile.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return userProfile;
    }
}
