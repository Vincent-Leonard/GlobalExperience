package com.example.globalexperience.Fragments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.repository.EventRepository;

import java.util.List;

import static android.content.ContentValues.TAG;

public class PendingViewModel extends ViewModel {

    private EventRepository repository;
    private static final String TAG = "EventViewModel";

    public PendingViewModel() {
    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        repository = EventRepository.getInstance(token);
    }

    public LiveData<List<Event>> getEvents() {
        return repository.getEvents();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        repository.resetInstance();
    }
}
