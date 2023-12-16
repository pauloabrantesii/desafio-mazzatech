package com.example.challengermazzatech;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;


public class Http {

    public static Api request() {
       Retrofit retrofit = new Retrofit.Builder().baseUrl("https://test.avaty.com.br").build();
        return retrofit.create(Api.class);
    }
}
     interface Api {
        @GET("Desafio/rest/desafioRest")
        Call<List<User>> getUsers();
    }
