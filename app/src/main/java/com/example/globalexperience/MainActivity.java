package com.example.globalexperience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.globalexperience.Fragments.HistoryFragment;
import com.example.globalexperience.Fragments.PendingFragment;
import com.example.globalexperience.Fragments.ProfileFragment;
import com.example.globalexperience.Fragments.allEventFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        floatingActionButton = findViewById(R.id.floatingActionButton2);

        AppBarConfiguration configuration = new AppBarConfiguration
                .Builder(R.id.pendingFragment, R.id.historyFragment)//id fragment di main_navigation (harusnya)
                .build();

        navController = Navigation.findNavController(this, R.id.fragmentContainer);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.pendingFragment || destination.getId() == R.id.historyFragment){
                bottomNavigationView.setVisibility(View.VISIBLE);
                floatingActionButton.setVisibility(View.VISIBLE);
            }else{
                bottomNavigationView.setVisibility(View.GONE);
                floatingActionButton.setVisibility(View.GONE);
            }
        });
    }
}