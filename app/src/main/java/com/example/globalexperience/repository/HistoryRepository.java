package com.example.globalexperience.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.History;
import com.example.globalexperience.model.response.EventResponse;
import com.example.globalexperience.model.response.HistoryResponse;
import com.example.globalexperience.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryRepository {
    private static HistoryRepository historyRepository;
    private RetrofitService apiService;
    private static final String TAG = "HistoryRepository";

    private HistoryRepository(String token) {
        Log.d(TAG, "HistoryRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static HistoryRepository getInstance(String token) {
        if (historyRepository == null) {
            historyRepository = new HistoryRepository(token);
        }
        return historyRepository;
    }

    public synchronized void resetInstance() {
        if (historyRepository != null) {
            historyRepository = null;
        }
    }

    public MutableLiveData<List<History>> getHistory() {
        MutableLiveData<List<History>> listHistory = new MutableLiveData<>();

        apiService.getHistory().enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getResults().size());
                        listHistory.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listHistory;
    }
}
