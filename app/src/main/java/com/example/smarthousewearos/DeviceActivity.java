package com.example.smarthousewearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.smarthousewearos.databinding.ActivityDeviceBinding;

public class DeviceActivity extends Activity {

    private ActivityDeviceBinding binding;
    LinearLayout lightLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeviceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        lightLay = findViewById(R.id.lightLay);

        lightLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeviceActivity.this, LightActivity.class));
            }
        });
    }
}