package com.example.smarthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    LoginResp loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResp) intent.getSerializableExtra("data");
            Log.e("TAG", "=====>" + loginResponse.getEmail());
        }
    }
}