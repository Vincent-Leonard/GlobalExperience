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
import com.example.globalexperience.model.local.AllEvent;
import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class allEventFragment extends Fragment {

    @BindView(R.id.imgbtn_profile4)
    ImageView imageView;

    @BindView(R.id.progressBar_event)
    ProgressBar loading;

    @BindView(R.id.rv_event)
    RecyclerView rvEvent;

    private allEventViewModel viewModel;
    private allEventAdapter adapter;
    private SharedPreferenceHelper helper;

    public allEventFragment() {
        // Required empty public constructor
    }

//    public static allEventFragment newInstance(String param1, String param2) {
//        allEventFragment fragment = new allEventFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        showLoading(true);

        //TODO: Place viewModel implementation here
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(allEventViewModel.class);
        viewModel.init(helper.getAccessToken());
        viewModel.getAllEvents().observe(requireActivity(), observeViewModel);

        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new allEventAdapter(getActivity());
    }

    @OnClick(R.id.imgbtn_profile4)
    public void onClick(View view) {
        if (view.getId() == R.id.imgbtn_profile4) {
            NavDirections action = allEventFragmentDirections.actionAllEventFragmentToProfileFragment();
            Navigation.findNavController(view).navigate(action);
        }
    }

    private androidx.lifecycle.Observer<List<AllEvent>> observeViewModel = new Observer<List<AllEvent>>() {
        @Override
        public void onChanged(List<AllEvent> events) {
            if (events != null) {
                adapter.setAllEventList(events);
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