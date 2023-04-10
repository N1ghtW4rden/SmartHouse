package com.example.smarthousewearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smarthousewearos.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {

    private ActivityLoginBinding binding;
    Button EnterBtn;
    EditText loginEmail, loginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EnterBtn = findViewById(R.id.EnterBtn);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);

        EnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(loginEmail.getText().toString())) {

                    String message = "Заполните Email!";
                    Toast.makeText(LoginActivity.this, message,Toast.LENGTH_LONG).show();

                }
                else if(TextUtils.isEmpty(loginPassword.getText().toString())){
                    String message = "Заполните пароль!";
                    Toast.makeText(LoginActivity.this, message,Toast.LENGTH_LONG).show();
                }
                else if((loginPassword.getText().length() <= 8)){
                    String message = "Пароль должен состоять из 8 или более символов!";
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                }

                else{
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setUsername(loginEmail.getText().toString());
                    loginRequest.setPassword(loginPassword.getText().toString());


                    loginUser(loginRequest);
                }
            }
        });
    }

    public void loginUser(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){

                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("data", loginResponse));

                    finish();
                }else{
                    String message = "An error occured please try again";
                    Toast.makeText(LoginActivity.this, message,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this, message,Toast.LENGTH_LONG).show();
            }
        });
    }


}