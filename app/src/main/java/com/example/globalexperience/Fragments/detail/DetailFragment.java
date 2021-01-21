package com.example.globalexperience.Fragments.detail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.globalexperience.Fragments.ProfileFragmentDirections;
import com.example.globalexperience.Fragments.ProfileViewModel;
import com.example.globalexperience.MainActivity;
import com.example.globalexperience.R;
import com.example.globalexperience.model.local.AllEvent;
import com.example.globalexperience.model.local.Event;
import com.example.globalexperience.model.local.History;
import com.example.globalexperience.model.local.Student;
import com.example.globalexperience.model.local.User;
import com.example.globalexperience.utils.SharedPreferenceHelper;

import java.io.File;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailFragment extends Fragment {

    @BindView(R.id.event_name)
    TextView name;

    @BindView(R.id.event_type)
    TextView type;

    @BindView(R.id.event_date)
    TextView date;

    @BindView(R.id.event_duration)
    TextView duration;

    @BindView(R.id.event_country)
    TextView country;

    @BindView(R.id.event_city)
    TextView city;

    @BindView(R.id.event_host)
    TextView organizer;

    @BindView(R.id.event_status)
    TextView status;

    @BindView(R.id.event_category)
    TextView category;

    @BindView(R.id.event_photo)
    ImageView photo;

    private Event event;
    private History history;
    private AllEvent allEvent;
    private DetailViewModel viewModel;
    private SharedPreferenceHelper helper;


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
//        showLoading(true);
//        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        //TODO: Place viewModel implementation here
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(DetailViewModel.class);
        viewModel.init(helper.getAccessToken());

        if (getArguments() != null) {
            event = DetailFragmentArgs.fromBundle(getArguments()).getEvent();
            history = DetailFragmentArgs.fromBundle(getArguments()).getHistory();
            allEvent = DetailFragmentArgs.fromBundle(getArguments()).getAllEvent();

            if (event != null) {
                initEvent(event);
            }else if (history != null) {
                initHistory(history);
            }else{
                initAllEvent(allEvent);
            }
        }

        Toolbar toolbar = view.findViewById(R.id.d_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = DetailFragmentDirections.actionDetailFragmentToPendingFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    private void initEvent(Event event) {
        Glide.with(getActivity()).load(event.getFile()).into(photo);
        name.setText(event.getName());
        if(event.getType().equals("0")){
            type.setText("Student Exchange");
        }else{
            type.setText("Student Excursion");
        }
        date.setText(event.getDate());
        duration.setText(event.getDuration());
        country.setText(event.getCountry());
        String cities = event.getCity() + ", ";
        city.setText(cities);
        organizer.setText(event.getOrganizer());
        if(event.getStatus().equals("0")){
            status.setText("Pending");
        }
        if(event.getStatus().equals("1")){
            status.setText("Approved");
        }
        if(event.getStatus().equals("2")){
            status.setText("Rejected");
        }
        if(event.getStatus().equals("3")){
            status.setText("Revision");
        }
        if(event.getStatus().equals("4")){
            status.setText("Open");
        }
        if(event.getStatus().equals("5")){
            status.setText("Close");
        }
        if(event.getIs_group().equals("0")){
            category.setText("Individual");
        }else{
            category.setText("Group");
        }
    }

    private void initHistory(History history) {
        Glide.with(getActivity()).load(history.getFile()).into(photo);
        name.setText(history.getName());
        if(history.getType().equals("0")){
            type.setText("Student Exchange");
        }else{
            type.setText("Student Excursion");
        }
        date.setText(history.getDate());
        duration.setText(history.getDuration());
        country.setText(history.getCountry());
        String cities = history.getCity() + ", ";
        city.setText(cities);
        organizer.setText(history.getOrganizer());
        if(history.getStatus().equals("0")){
            status.setText("Pending");
        }
        if(history.getStatus().equals("1")){
            status.setText("Approved");
        }
        if(history.getStatus().equals("2")){
            status.setText("Rejected");
        }
        if(history.getStatus().equals("3")){
            status.setText("Revision");
        }
        if(history.getStatus().equals("4")){
            status.setText("Open");
        }
        if(history.getStatus().equals("5")){
            status.setText("Close");
        }
        if(history.getIs_group().equals("0")){
            category.setText("Individual");
        }else{
            category.setText("Group");
        }
    }

    private void initAllEvent(AllEvent allEvent) {
        Glide.with(getActivity()).load(allEvent.getFile()).into(photo);
        name.setText(allEvent.getName());
        if(allEvent.getType().equals("0")){
            type.setText("Student Exchange");
        }else{
            type.setText("Student Excursion");
        }
        date.setText(allEvent.getDate());
        duration.setText(allEvent.getDuration());
        country.setText(allEvent.getCountry());
        String cities = allEvent.getCity() + ", ";
        city.setText(cities);
        organizer.setText(allEvent.getOrganizer());
        if(allEvent.getStatus().equals("0")){
            status.setText("Pending");
        }
        if(allEvent.getStatus().equals("1")){
            status.setText("Approved");
        }
        if(allEvent.getStatus().equals("2")){
            status.setText("Rejected");
        }
        if(allEvent.getStatus().equals("3")){
            status.setText("Revision");
        }
        if(allEvent.getStatus().equals("4")){
            status.setText("Open");
        }
        if(allEvent.getStatus().equals("5")){
            status.setText("Close");
        }
        if(allEvent.getIs_group().equals("0")){
            category.setText("Individual");
        }else{
            category.setText("Group");
        }
    }
}