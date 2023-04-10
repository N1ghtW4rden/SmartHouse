package com.example.smarthouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.smarthouse.databinding.ActivityDeviceBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Device extends AppCompatActivity {
    private ActivityDeviceBinding binding1;
    BottomNavigationView navViewTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_device);



        binding1 = ActivityDeviceBinding.inflate(getLayoutInflater());
        setContentView(binding1.getRoot());

        BottomNavigationView navViewTop = findViewById(R.id.navViewTop);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.thermoFragment, R.id.lightFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_device);
        //       NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding1.navViewTop, navController);



    }
}
