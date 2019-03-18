package com.example.iverson.pruebacuatro.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestFoodInterceptor {

    private static final String BASE_URL = "https://nutritionix-api.p.mashape.com/v1_1/";

    public RequestFood get() {
        /*This is very common in gets cause increase the response time wait and add headers and does retrys*/
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder()
                        /*Common headers*/
                        .header("X-Mashape-Key", "UIBwZ06yNGmsh3AKHxv6z1Bh846vp1C4QByjsn5F9l4zmgJFyc")
                        .header("Accept", "application/json")
                        /*Custom header*/
                        .build();

                Response response = chain.proceed(request);

                /*If the request fail then you get 3 retrys*/
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 3) {
                    retryCount++;
                    response = chain.proceed(request);
                }

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        RequestFood request = interceptor.create(RequestFood.class);

        return request;
    }

}
