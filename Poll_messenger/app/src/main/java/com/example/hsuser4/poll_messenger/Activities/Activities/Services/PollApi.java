package com.example.hsuser4.poll_messenger.Activities.Activities.Services;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hsuser4 on 2017/02/09.
 */

public interface PollApi {
    @GET("/{tennantID}/api/polls")
    Call<JsonArray> GetLastPoll(@Path("tennantID") String tennantID);
}
