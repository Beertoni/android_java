package com.example.aplicacaoconsumirapi.config;

import com.example.aplicacaoconsumirapi.service.UserService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig(){

        retrofit =
                new Retrofit.Builder()
                .baseUrl("https://612ebb45d11e5c00175586ac.mockapi.io/uniso/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public UserService getUserService(){
        return this.retrofit.create(UserService.class);
    }
}
