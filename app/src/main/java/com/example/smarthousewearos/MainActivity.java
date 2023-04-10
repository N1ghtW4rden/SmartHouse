package com.example.smarthousewearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smarthousewearos.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    LinearLayout livingRoom3Lay;

    private TextView mTextView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        livingRoom3Lay = findViewById(R.id.livingRoom3Lay);


        livingRoom3Lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DeviceActivity.class));
            }
        });
    }
}