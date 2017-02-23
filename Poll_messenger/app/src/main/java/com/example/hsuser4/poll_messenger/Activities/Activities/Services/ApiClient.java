package com.example.hsuser4.poll_messenger.Activities.Activities.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ApiClient {
    public static final String base_url = "http://pollapi.azurewebsites.net";
    private static Retrofit retrofit = null;

    //Setup RetroFit
    public static Retrofit getClient(String baseURl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
