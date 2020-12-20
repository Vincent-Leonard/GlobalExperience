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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalexperience.R;
import com.example.globalexperience.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PendingFragment extends Fragment {

    @BindView(R.id.imgbtn_profile)
    ImageView btnprofile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pending, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind(this, view);
//
//        //TODO: Place viewModel implementation here
//        helper = SharedPreferenceHelper.getInstance(requireActivity());
//        viewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);
//        viewModel.init(helper.getAccessToken());
//        Log.d("access token", helper.getAccessToken());
//    }
//
//    @OnClick(R.id.btn_logout)
//    public void logout(View view) {
//        if (view.getId() == R.id.btn_logout) {
//            viewModel.logout().observe(requireActivity(), message -> {
//                if (!message.isEmpty()) {
//                    helper.clearPref();
//                    NavDirections action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment();
//                    Navigation.findNavController(view).navigate(action);
//                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }
}