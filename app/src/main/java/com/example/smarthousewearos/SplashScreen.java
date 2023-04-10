package com.example.smarthousewearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smarthousewearos.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends Activity {

    private TextView mTextView;
    private ActivitySplashScreenBinding binding;
    private ImageView splashImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashImage = findViewById(R.id.splashImage);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        splashImage.startAnimation(animation);

        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2200);
    }
}