package com.example.retrofitapp.networks;

import com.example.retrofitapp.models.ApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/demos/marvel")
    Call<List<ApiModel>> getData();
}
