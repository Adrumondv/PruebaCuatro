package com.example.iverson.pruebacuatro.network;

import android.os.AsyncTask;

import com.example.iverson.pruebacuatro.models.Portion;
import com.example.iverson.pruebacuatro.models.PortionFields;
import com.example.iverson.pruebacuatro.models.PortionWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class BackgroundFood extends AsyncTask<String, Void, List<PortionFields>> {
    @Override
    protected List<PortionFields> doInBackground(String... params) {

        RequestFood requestFood = new RequestFoodInterceptor().get();
        Call<PortionWrapper> call = requestFood.getFood(params[0], "item_name,nf_calories,nf_total_fat");
        try {
            Response<PortionWrapper> response = call.execute();
            if (200 == response.code() && response.isSuccessful()) {
                PortionWrapper portionWrapper = response.body();
                Portion[] portions = portionWrapper.getHits();
                List<PortionFields> list = new ArrayList<>();
                for (Portion portion : portions) {
                    list.add(portion.getFields());
                }
                return list;//(List<PortionFields>) response.body();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
