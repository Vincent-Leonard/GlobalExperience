package com.example.globalexperience.Fragments.detail;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.globalexperience.model.local.User;
import com.example.globalexperience.repository.EventRepository;
import com.example.globalexperience.repository.ProfileRepository;

public class DetailViewModel extends ViewModel {

    private EventRepository repository;
    private static final String TAG = "DetailViewModel";

    public DetailViewModel() {
    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        repository = EventRepository.getInstance(token);
    }

}