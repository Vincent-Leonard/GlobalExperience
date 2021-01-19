package com.example.globalexperience.Fragments;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.History;
import com.example.globalexperience.repository.EventRepository;
import com.example.globalexperience.repository.HistoryRepository;

import java.util.List;

public class HistoryViewModel extends ViewModel {

    private HistoryRepository repository;
    private static final String TAG = "HistoryViewModel";

    public HistoryViewModel() {
    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        repository = HistoryRepository.getInstance(token);
    }

    public LiveData<List<History>> getHistories() {
        return repository.getHistory();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        repository.resetInstance();
    }
}
