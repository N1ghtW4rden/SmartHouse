package com.example.smarthousewearos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("user")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);


}
