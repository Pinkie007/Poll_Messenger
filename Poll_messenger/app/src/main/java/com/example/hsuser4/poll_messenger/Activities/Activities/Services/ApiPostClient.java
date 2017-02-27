package com.example.hsuser4.poll_messenger.Activities.Activities.Services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hsuser4 on 2017/02/24.
 */

public class ApiPostClient {

    String API_BASE_URL = "http://pollapi.azurewebsites.net";

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    );

    Retrofit retrofit =
            builder
                    .client(
                            httpClient.build()
                    )
                    .build();

    ApiPostClient client =  retrofit.create(ApiPostClient.class);

}
