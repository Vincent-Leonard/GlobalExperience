package com.example.globalexperience.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.globalexperience.model.local.AllEvent;
import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.response.AllEventResponse;
import com.example.globalexperience.model.response.EventResponse;
import com.example.globalexperience.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllEventRepository {
    private static AllEventRepository allEventRepository;
    private RetrofitService apiService;
    private static final String TAG = "AllEventRepository";

    private AllEventRepository(String token) {
        Log.d(TAG, "EventRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static AllEventRepository getInstance(String token) {
        if (allEventRepository == null) {
            allEventRepository = new AllEventRepository(token);
        }
        return allEventRepository;
    }

    public synchronized void resetInstance() {
        if (allEventRepository != null) {
            allEventRepository = null;
        }
    }

    public MutableLiveData<List<AllEvent>> getAllEvents() {
        MutableLiveData<List<AllEvent>> listAllEvent = new MutableLiveData<>();

        apiService.getAllEvents().enqueue(new Callback<AllEventResponse>() {
            @Override
            public void onResponse(Call<AllEventResponse> call, Response<AllEventResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listAllEvent.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<AllEventResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listAllEvent;
    }
}
