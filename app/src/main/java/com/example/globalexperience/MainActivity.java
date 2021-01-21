package com.example.globalexperience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.globalexperience.Fragments.HistoryFragment;
import com.example.globalexperience.Fragments.PendingFragment;
import com.example.globalexperience.Fragments.ProfileFragment;
import com.example.globalexperience.Fragments.allEventFragment;
import com.example.globalexperience.model.local.User;
import com.example.globalexperience.repository.ProfileRepository;
import com.example.globalexperience.utils.SharedPreferenceHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    BottomNavigationView bottomNavigationView;
    BottomNavigationView bottomNavigationUser;
    FloatingActionButton floatingActionButton;
    private ProfileRepository repository;
    SharedPreferenceHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main Activity:", "Main");

        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        bottomNavigationUser = findViewById(R.id.bottom_nva_menu_user);
        floatingActionButton = findViewById(R.id.floatingActionButton2);

        bottomNavigationView.setVisibility(View.GONE);
        floatingActionButton.setVisibility(View.GONE);
        bottomNavigationUser.setVisibility(View.GONE);
//        AppBarConfiguration configuration = new AppBarConfiguration
//                .Builder(R.id.pendingFragment, R.id.allEventFragment, R.id.historyFragment)
//                .build();
//
//
//        navController = Navigation.findNavController(this, R.id.fragmentContainer);
//
//        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
//            if (destination.getId() == R.id.pendingFragment || destination.getId() == R.id.historyFragment || destination.getId() == R.id.allEventFragment){
//                bottomNavigationView.setVisibility(View.VISIBLE);
//                floatingActionButton.setVisibility(View.GONE);
//            }else{
//                bottomNavigationView.setVisibility(View.GONE);
//                floatingActionButton.setVisibility(View.GONE);
//            }
//        });
//
////        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        navController = Navigation.findNavController(this, R.id.fragmentContainer);

        helper = SharedPreferenceHelper.getInstance(getApplicationContext());
        if (!helper.getAccessToken().isEmpty()){
            Log.d("Main On Changed User:", "Access Token");
            repository = ProfileRepository.getInstance(helper.getAccessToken());
            repository.getUser().observe(this, observer);
        }else{
            Log.d("Main On Changed User:", "Access Token Fail");
        }
        Log.d("Main On Changed User:", "Access Token = " + helper.getAccessToken());
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (Openable) null);
    }

    private Observer<User> observer = new Observer<User>() {
        @Override
        public void onChanged(User user) {
            Log.d("Main On Changed User:", "Change User");
            if (user.getAdmin().equals("0")){
                Log.d("Main Activity:", "Ini user");
                AppBarConfiguration configuration = new AppBarConfiguration
                        .Builder(R.id.pendingFragment, R.id.historyFragment)
                        .build();

                NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
                navController = navHostFragment.getNavController();
                NavigationUI.setupWithNavController(bottomNavigationUser, navController);
                navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
                    if (destination.getId() == R.id.pendingFragment || destination.getId() == R.id.historyFragment){
                        bottomNavigationView.setVisibility(View.GONE);
                        bottomNavigationUser.setVisibility(View.VISIBLE);
                        floatingActionButton.setVisibility(View.GONE);
                    }else{
                        bottomNavigationView.setVisibility(View.GONE);
                        floatingActionButton.setVisibility(View.GONE);
                        bottomNavigationUser.setVisibility(View.GONE);
                    }
                });

        //        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
            }

            else if (user.getAdmin().equals("1")){
                Log.d("Main Activity:", "Ini admin");
                AppBarConfiguration configuration = new AppBarConfiguration
                        .Builder(R.id.pendingFragment, R.id.allEventFragment, R.id.historyFragment)
                        .build();

                NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
                navController = navHostFragment.getNavController();
                navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
                    if (destination.getId() == R.id.pendingFragment || destination.getId() == R.id.historyFragment || destination.getId() == R.id.allEventFragment){
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        bottomNavigationUser.setVisibility(View.GONE);
                        floatingActionButton.setVisibility(View.GONE);
                    }else{
                        bottomNavigationView.setVisibility(View.GONE);
                        floatingActionButton.setVisibility(View.GONE);
                        bottomNavigationUser.setVisibility(View.GONE);
                    }
                });

                //        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
                NavigationUI.setupWithNavController(bottomNavigationView, navController);
            }
        }
    };
}
