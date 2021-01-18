package com.example.globalexperience.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.globalexperience.R;
import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.History;
import com.example.globalexperience.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryFragment extends Fragment {

    @BindView(R.id.imgbtn_profile)
    ImageView imageView;

    @BindView(R.id.rv_history)
    RecyclerView rvEvent;

    private HistoryViewModel viewModel;
    private HistoryAdapter adapter;
    private SharedPreferenceHelper helper;

    public HistoryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        //TODO: Place viewModel implementation here
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(HistoryViewModel.class);
        viewModel.init(helper.getAccessToken());
        viewModel.getHistories().observe(requireActivity(), observeViewModel);

        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HistoryAdapter(getActivity());
    }

    @OnClick(R.id.imgbtn_profile)
    public void onClick(View view) {
        if (view.getId() == R.id.imgbtn_profile) {
            NavDirections action = HistoryFragmentDirections.actionHistoryFragmentToProfileFragment();
            Navigation.findNavController(view).navigate(action);
        }
    }

    private androidx.lifecycle.Observer<List<History>> observeViewModel = new Observer<List<History>>() {
        @Override
        public void onChanged(List<History> histories) {
            if (histories != null) {
                adapter.setHistoryList(histories);
                adapter.notifyDataSetChanged();
                rvEvent.setAdapter(adapter);
                //showLoading(false);
            }
        }
    };
}