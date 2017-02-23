package com.example.hsuser4.poll_messenger.Activities.Activities.Services;

import retrofit2.Retrofit;

/**
 * Created by hsuser4 on 2017/02/20.
 */

public class ApiUtils {
    private  ApiUtils() {}

     public static  final String BaseURl = "http://pollapi.azurewebsites.net";

        public static PostApi getPostApi()
    {
        return ApiClient.getClient(BaseURl).create(PostApi.class);
    }

    }

