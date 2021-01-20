package com.example.globalexperience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.globalexperience.Fragments.HistoryFragment;
import com.example.globalexperience.Fragments.PendingFragment;
import com.example.globalexperience.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    ImageView btn_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.pendingFragment:
                        fragment = new PendingFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.historyFragment:
                        fragment = new HistoryFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });

        btn_profile = findViewById(R.id.imgbtn_profile2);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ProfileFragment();
                loadFragment(fragment);
            }
        });
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_main, fragment);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        bottomNavigationView.setSelectedItemId(R.id.pendingFragment);
        Fragment fragment = new PendingFragment();
        loadFragment(fragment);
    }

    public boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);
            finishAffinity();
            finish();
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(HomeActivity.this, "Press back once more to close the apps!", Toast.LENGTH_SHORT).show();
    }
}