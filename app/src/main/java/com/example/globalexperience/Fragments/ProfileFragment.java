package com.example.globalexperience.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.globalexperience.R;
import com.example.globalexperience.model.local.Student;
import com.example.globalexperience.model.local.User;
import com.example.globalexperience.model.response.ProfileResponse;
import com.example.globalexperience.utils.SharedPreferenceHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
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
    public Student student;
    public User user;

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
        viewModel.init(helper.getAccessToken());
        Log.d("access token", helper.getAccessToken());
        viewModel.getProfile().observe(requireActivity(), observer);
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

    private Observer<User> observer = new Observer<User>() {
        @Override
        public void onChanged(User user) {

            if (user.getStudentResults() != null){
                File imgFile = new  File("/images/profile_picture/student/" + user.getStudentResults().getStudent_photo());

                if(imgFile.exists()){
                    Toast.makeText(getActivity(), "ADA", Toast.LENGTH_SHORT).show();
                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    photo.setImageBitmap(myBitmap);
                }

                Glide.with(getActivity()).load("/images/profile_picture/student/" + user.getStudentResults().getStudent_photo()).centerCrop().into(photo);
                nim.setText(user.getStudentResults().getNim());
                email.setText(user.getEmail());
                name.setText(user.getStudentResults().getStudent_name());
                if(user.getStudentResults().getStudent_gender() == "1"){
                    gender.setText("Female");
                }else{
                    gender.setText("Male");
                }
                major.setText(user.getStudentResults().getDepartment().getDepartmentName());
                batch.setText(user.getStudentResults().getBatch());
                phone.setText(user.getStudentResults().getStudent_phone());
                line.setText(user.getStudentResults().getStudent_line_account());
            } else if (user.getLecturerResults() != null){
                nim.setText(user.getLecturerResults().getNip());
                email.setText(user.getEmail());
                name.setText(user.getLecturerResults().getLecturer_name());
                if(user.getStudentResults().getStudent_gender() == "1"){
                    gender.setText("Female");
                }else{
                    gender.setText("Male");
                }
                major.setText(user.getLecturerResults().getDepartment().getDepartmentName());
                phone.setText(user.getLecturerResults().getLecturer_phone());
                line.setText(user.getLecturerResults().getLecturer_line_account());
            } else if (user.getStaffResults() != null){
                nim.setText(user.getStaffResults().getNip());
                email.setText(user.getEmail());
                name.setText(user.getStaffResults().getStaff_name());
                if(user.getStudentResults().getStudent_gender() == "1"){
                    gender.setText("Female");
                }else{
                    gender.setText("Male");
                }
                major.setText(user.getStaffResults().getDepartment().getDepartmentName());
                phone.setText(user.getStaffResults().getStaff_phone());
                line.setText(user.getStaffResults().getStaff_line_account());
            }
        }
    };

}