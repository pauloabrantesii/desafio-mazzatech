package com.example.challengermazzatech;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {
    private static final String BASE_URL = "https://test.avaty.com.br/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService service() {
        return retrofit.create(ApiService.class);
    }
}
