package com.example.globalexperience.Fragments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.globalexperience.model.response.TokenResponse;
import com.example.globalexperience.repository.AuthRepository;

import java.util.List;

public class ProfileViewModel extends ViewModel {

    private AuthRepository repository;

    public ProfileViewModel() {
        repository = AuthRepository.getInstance();
    }

    public LiveData<String> logout() {
        return repository.logout();
    }
}
