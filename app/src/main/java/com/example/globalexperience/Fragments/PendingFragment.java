package com.example.globalexperience.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalexperience.R;
import com.example.globalexperience.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PendingFragment extends Fragment {

    @BindView(R.id.imgbtn_profile3)
    ImageView imageView;

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

        //TODO: Place viewModel implementation here
    }

    @OnClick(R.id.imgbtn_profile3)
    public void onClick(View view) {
        if (view.getId() == R.id.imgbtn_profile3) {
            NavDirections action = PendingFragmentDirections.actionPendingFragmentToProfileFragment();
            Navigation.findNavController(view).navigate(action);
        }
    }
}