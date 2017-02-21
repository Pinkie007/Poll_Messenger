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
    Callback<PostModel> savePost();


}
