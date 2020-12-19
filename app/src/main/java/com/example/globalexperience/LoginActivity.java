package com.example.globalexperience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.globalexperience.model.response.TokenResponse;
import com.example.globalexperience.utils.SharedPreferenceHelper;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements TextWatcher {

//    private NavController navController;
    TextInputLayout input_email, input_password;
    Button btnLogin;
    TokenResponse tokenResponse;

    private SharedPreferenceHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_email = findViewById(R.id.textInputEmail);
        input_password = findViewById(R.id.textInputPassword);
        btnLogin = findViewById(R.id.btn_login);

        input_email.getEditText().addTextChangedListener(this);
        input_password.getEditText().addTextChangedListener(this);

        helper = SharedPreferenceHelper.getInstance(LoginActivity.this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
//        navController = navHostFragment.getNavController();
//        NavigationUI.setupActionBarWithNavController(this, navController);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        return NavigationUI.navigateUp(navController, (Openable) null);
//    }

    public void signIn() {
        if (tokenResponse != null) {
                helper.saveAccessToken(tokenResponse.getAuthorization());
//                          NavDirections actions = LoginFragmentDirections.actionLoginFragmentToEventFragment();
//                          Navigation.findNavController(view).navigate(actions);
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String email = input_email.getEditText().toString().trim();
        String password = input_password.getEditText().toString().trim();

//        if (!email.isEmpty() && !password.isEmpty()) {
//            btnLogin.setEnabled(true);
//        }
//        else{
//            btnLogin.setEnabled(false);
//        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}