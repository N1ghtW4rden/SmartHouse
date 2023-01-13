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

public class LoginActivity extends AppCompatActivity {
    Button enterButton, newButton;
    EditText loginEmail, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        enterButton = findViewById(R.id.enterButton);
        newButton = findViewById(R.id.newButton);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(loginEmail.getText().toString())) {
                    String message = "Заполните Email!";
                    Toast.makeText(LoginActivity.this, message,Toast.LENGTH_LONG).show();
                }
                else if(loginEmail.equals(invalidEmailIds)){
                    String message = "Некорректный Емейл!";
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
                    LoginReq loginRequest = new LoginReq();
                    loginRequest.setUsername(loginEmail.getText().toString());
                    loginRequest.setPassword(loginPassword.getText().toString());
                    loginUser(loginRequest);
                }
            }
        });
    }

    // list of valid email addresses
    private static final String[] validEmailIds = new String[] { "journaldev@yahoo.com", "journaldev-100@yahoo.com",
            "journaldev.100@yahoo.com", "journaldev111@journaldev.com", "journaldev-100@journaldev.net",
            "journaldev.100@journaldev.com.au", "journaldev@1.com", "journaldev@gmail.com.com",
            "journaldev+100@gmail.com", "journaldev-100@yahoo-test.com", "journaldev_100@yahoo-test.ABC.CoM" };

    // list of invalid email addresses
    private static final String[] invalidEmailIds = new String[] { "journaldev", "journaldev@.com.my",
            "journaldev123@gmail.a", "journaldev123@.com", "journaldev123@.com.com", ".journaldev@journaldev.com",
            "journaldev()*@gmail.com", "journaldev@%*.com", "journaldev..2002@gmail.com", "journaldev.@gmail.com",
            "journaldev@journaldev@gmail.com", "journaldev@gmail.com.1a" };

    private static EmailValidator emailValidator;

    public static void main(String args[]) {
        emailValidator = new EmailValidator();
        for (String temp : validEmailIds) {
            boolean valid = emailValidator.validateEmail(temp);
            System.out.println("Email ID " + temp + " is valid? " + valid);
        }
        System.out.println("\n\n");
        for (String temp : invalidEmailIds) {
            boolean valid = emailValidator.validateEmail(temp);
            System.out.println("Email ID " + temp + " is valid? " + valid);
        }
    }

    public void loginUser(LoginReq loginRequest){
        Call<LoginResp> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResp>() {
            @Override
            public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {

                if(response.isSuccessful()){
                    LoginResp loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("data", loginResponse));
                    finish();
                }
                else{
                    String message = "An error occured please try again";
                    Toast.makeText(LoginActivity.this, message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResp> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this, message,Toast.LENGTH_LONG).show();
            }
        });
    }
}
