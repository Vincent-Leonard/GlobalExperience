package com.example.globalexperience.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.response.EventResponse;
import com.example.globalexperience.network.RetrofitService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepository {

    private static EventRepository eventRepository;
    private RetrofitService apiService;
    private static final String TAG = "EventRepository";

    private EventRepository(String token) {
        Log.d(TAG, "EventRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static EventRepository getInstance(String token) {
        if (eventRepository == null) {
            eventRepository = new EventRepository(token);
        }
        return eventRepository;
    }

    public synchronized void resetInstance() {
        if (eventRepository != null) {
            eventRepository = null;
        }
    }

    public MutableLiveData<List<Event>> getEvents() {
        MutableLiveData<List<Event>> listEvent = new MutableLiveData<>();

        apiService.getEvents().enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listEvent.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listEvent;
    }
}
