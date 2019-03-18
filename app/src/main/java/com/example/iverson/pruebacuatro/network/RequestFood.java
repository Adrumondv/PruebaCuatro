package com.example.iverson.pruebacuatro.network;

import com.example.iverson.pruebacuatro.models.PortionWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestFood {


    @GET("search/{food}")
    Call<PortionWrapper> getFood(@Path("food") String food, @Query("fields") String fields);
    //item_name,nf_calories,nf_total_fat
}
