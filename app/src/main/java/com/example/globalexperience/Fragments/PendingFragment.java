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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalexperience.R;
import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PendingFragment extends Fragment {

    @BindView(R.id.imgbtn_profile3)
    ImageView imageView;

    @BindView(R.id.progressBar)
    ProgressBar loading;

    @BindView(R.id.rv_pending)
    RecyclerView rvEvent;

    private PendingViewModel viewModel;
    private PendingAdapter adapter;
    private SharedPreferenceHelper helper;

    public PendingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pending, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        showLoading(true);

        //TODO: Place viewModel implementation here
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(PendingViewModel.class);
        viewModel.init(helper.getAccessToken());
        viewModel.getEvents().observe(requireActivity(), observeViewModel);

        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PendingAdapter(getActivity());
    }

    @OnClick(R.id.imgbtn_profile3)
    public void onClick(View view) {
        if (view.getId() == R.id.imgbtn_profile3) {
            NavDirections action = PendingFragmentDirections.actionPendingFragmentToProfileFragment();
            Navigation.findNavController(view).navigate(action);
        }
    }

    private androidx.lifecycle.Observer<List<Event>> observeViewModel = new Observer<List<Event>>() {
        @Override
        public void onChanged(List<Event> events) {
            if (events != null) {
                adapter.setEventList(events);
                adapter.notifyDataSetChanged();
                rvEvent.setAdapter(adapter);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            rvEvent.setVisibility(View.GONE);
            loading.setVisibility(View.VISIBLE);
        } else {
            rvEvent.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
        }
    }
}