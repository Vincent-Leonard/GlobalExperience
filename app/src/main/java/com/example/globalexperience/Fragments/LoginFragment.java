package com.example.globalexperience.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalexperience.MainActivity;
import com.example.globalexperience.R;
import com.example.globalexperience.utils.SharedPreferenceHelper;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    @BindView(R.id.login_email)
    EditText editEmail;
    @BindView(R.id.login_password)
    EditText editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginViewModel viewModel;
    private SharedPreferenceHelper helper;

    public LoginFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            ButterKnife.bind(this, view);
            Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

            //TODO: Place viewModel implementation here
            viewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel.class);
            helper = SharedPreferenceHelper.getInstance(requireActivity());
        }


        @OnClick({R.id.btn_login})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_login:
                    if (!editEmail.getText().toString().isEmpty() && !editPassword.getText().toString().isEmpty()) {
                        String email = editEmail.getText().toString().trim();
                        String password = editPassword.getText().toString().trim();
                        viewModel.login(email, password).observe(requireActivity(), tokenResponse -> {
                            if (tokenResponse != null) {
                                helper.saveAccessToken(tokenResponse.getAuthorization());
                                NavDirections actions = LoginFragmentDirections.actionLoginFragmentToDetailFragment();
                                Navigation.findNavController(view).navigate(actions);
                                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    break;
            }
        }
}