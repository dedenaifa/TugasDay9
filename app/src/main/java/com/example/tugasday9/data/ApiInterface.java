package com.example.tugasday9.data;

import com.example.tugasday9.data.model.Login;
import com.example.tugasday9.data.model.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("LoginActivity.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("RegisterActivity.php")
    Call<Register> RegisterResponse(
            @Field("username") String username,
            @Field("name") String name,
            @Field("password") String password
    );
}