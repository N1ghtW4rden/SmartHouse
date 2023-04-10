package com.example.smarthousewearos;

import android.app.Activity;
import android.os.Bundle;

import com.example.smarthousewearos.databinding.ActivityLightBinding;

public class LightActivity extends Activity {

    private ActivityLightBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}