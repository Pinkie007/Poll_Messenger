package com.example.hsuser4.poll_messenger.Activities.Activities.Services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BaseURl = "http://pollapi.azurewebsites.net";

    public static void getPostApi() {
        //return ApiClient.getClient(BaseURl).create(PostApi.class);

        // String API_BASE_URL = "http://pollapi.azurewebsites.net";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BaseURl)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        PostApi client = retrofit.create(PostApi.class);
    }
}





