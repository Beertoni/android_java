package com.example.aplicacaoconsumirapi.service;

import com.example.aplicacaoconsumirapi.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("users/{id}")
    Call<User> buscarUsuarioPorId(@Path("id") String id);
}
