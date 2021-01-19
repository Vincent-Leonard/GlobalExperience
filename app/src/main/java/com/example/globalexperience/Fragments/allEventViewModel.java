package com.example.globalexperience.Fragments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.globalexperience.model.local.AllEvent;
import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.repository.AllEventRepository;
import com.example.globalexperience.repository.EventRepository;

import java.util.List;

public class allEventViewModel extends ViewModel {
    private AllEventRepository repository;
    private static final String TAG = "EventViewModel";

    public allEventViewModel() {
    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        repository = AllEventRepository.getInstance(token);
    }

    public LiveData<List<AllEvent>> getAllEvents() {
        return repository.getAllEvents();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        repository.resetInstance();
    }
}
