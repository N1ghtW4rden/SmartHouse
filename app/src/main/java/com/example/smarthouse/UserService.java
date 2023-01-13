package com.example.smarthouse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("user")
    Call<LoginResp> loginUser(@Body LoginReq loginRequest);

    @POST("user")
    Call<RegisterResp> registerUsers(@Body RegisterReq registerRequest);

}