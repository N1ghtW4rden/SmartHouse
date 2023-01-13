package com.example.smarthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText mainEmail, mainPassword, mainName;
    Button loginButton2, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mainEmail = findViewById(R.id.mainEmail);
        mainPassword = findViewById(R.id.mainPassword);
        mainName = findViewById(R.id.mainName);
        loginButton2 = findViewById(R.id.loginButton2);
        button2 = findViewById(R.id.button2);

        loginButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(mainEmail.getText().toString()) /*|| TextUtils.isEmpty(mainName.getText().toString()) || TextUtils.isEmpty(mainPassword.getText().toString())*/){
                    // String message = "Заполните поля!";
                    String message = "Введите Email!";
                    Toast.makeText(RegisterActivity.this, message,Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(mainName.getText().toString())){
                    String message = "Введите имя!";
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(mainPassword.getText().toString())){
                    String message = "Введите пароль!";
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                }
                else if((mainPassword.getText().length() <= 8)){
                    String message = "Пароль должен состоять из 8 или более символов!";
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
                }
                else {
                    RegisterReq registerRequest = new RegisterReq();
                    registerRequest.setEmail(mainEmail.getText().toString());
                    registerRequest.setPassword(mainPassword.getText().toString());
                    registerRequest.setUsername(mainName.getText().toString());
                    registerUser(registerRequest);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public void registerUser(RegisterReq registerRequest){

        Call<RegisterResp> registerResponseCall = ApiClient.getService().registerUsers(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResp>() {
            @Override
            public void onResponse(Call<RegisterResp> call, Response<RegisterResp> response) {

                if(response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResp> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this, message,Toast.LENGTH_LONG).show();
            }
        });
    }
}