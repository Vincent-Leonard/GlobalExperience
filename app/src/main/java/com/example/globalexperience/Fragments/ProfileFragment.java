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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalexperience.R;
import com.example.globalexperience.utils.SharedPreferenceHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment {

    @BindView(R.id.user_nim)
    TextView nim;

    @BindView(R.id.user_name)
    TextView name;

    @BindView(R.id.user_email)
    TextView email;

    @BindView(R.id.user_batch)
    TextView batch;

    @BindView(R.id.user_photo)
    ImageView photo;

    @BindView(R.id.user_gender)
    TextView gender;

    @BindView(R.id.user_phone)
    TextView phone;

    @BindView(R.id.user_line)
    TextView line;

    @BindView(R.id.user_major)
    TextView major;

    @BindView(R.id.btn_logout)
    Button logout;

    private ProfileViewModel viewModel;
    private SharedPreferenceHelper helper;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
//        showLoading(true);
//        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        //TODO: Place viewModel implementation here
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);

    }

    @OnClick(R.id.btn_logout)
    public void logout(View view) {
        if (view.getId() == R.id.btn_logout) {
            viewModel.logout().observe(requireActivity(), message -> {
                if (!message.isEmpty()) {
                    helper.clearPref();
                    NavDirections action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment();
                    Navigation.findNavController(view).navigate(action);
                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


//    @Override
//    public void onDetach() {
//        super.onDetach();
//        getActivity().getViewModelStore().clear();
//    }
}