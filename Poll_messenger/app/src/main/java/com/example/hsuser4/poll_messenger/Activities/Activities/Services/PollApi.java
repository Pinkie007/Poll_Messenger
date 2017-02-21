package com.example.hsuser4.poll_messenger.Activities.Activities.Services;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by hsuser4 on 2017/02/09.
 */

public interface PollApi {
    @GET("/{tennantID}/api/polls/last")
    Call<JsonObject> GetLastPoll(@Path("tennantID") String tennantID);



}
