package com.example.challengermazzatech;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("Desafio/rest/desafioRest")
    Call<ResponseBody> registerUserRequest(@Body User data);
}
