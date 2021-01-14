package com.example.globalexperience.Fragments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.Student;
import com.example.globalexperience.model.local.User;
import com.example.globalexperience.model.response.ProfileResponse;
import com.example.globalexperience.model.response.TokenResponse;
import com.example.globalexperience.repository.AuthRepository;
import com.example.globalexperience.repository.ProfileRepository;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ProfileViewModel extends ViewModel {

    private ProfileRepository repository;
    private static final String TAG = "ProfileViewModel";

    public ProfileViewModel() {
//        repository = ProfileRepository.getInstance();
    }

    public LiveData<String> logout() {
        return repository.logout();
    }

//    public LiveData<ProfileResponse> getProfile() {
//        return repository.getProfile();
//    }

    public MutableLiveData<User> getProfile() {
//        Log.d("Hello","VIewModel");
        return repository.getUser();
    }

    public void init(String token){
        repository = ProfileRepository.getInstance(token);
    }
}
