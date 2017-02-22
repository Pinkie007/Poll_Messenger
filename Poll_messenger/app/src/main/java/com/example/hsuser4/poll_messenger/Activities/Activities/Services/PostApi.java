package com.example.hsuser4.poll_messenger.Activities.Activities.Services;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.DisplayRecords;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PostModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hsuser4 on 2017/02/20.
 */

public interface PostApi {
    @POST("/{tennantID}/api/AnsResult")
    @FormUrlEncoded
    Call<PostModel> savePost(
            @Field("pollGuid") String pollGuid,
            @Field("ansId") int ansId,
            @Field("os_type") String os_type,
            @Field("location") String location,
            @Field("manufacturer") String manufacturer,
            @Field("device_model") String device_model,
            @Field("os_version") String os_version,
            @Field("user_name") String user_name,
            @Field("user_id") String user_id,
            @Field("date_voted") String dateVoted
    );



}
