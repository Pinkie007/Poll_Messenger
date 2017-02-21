package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.nfc.Tag;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PostModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.ApiUtils;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.PostApi;
import com.example.hsuser4.poll_messenger.R;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPoll extends AppCompatActivity {

    TextView displayPoll;
    private PostApi mpostService;
    Button postpoll;
    Realm myRealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_poll);

        mpostService = ApiUtils.getPostApi();

        //Meta data version

        String os = Build.MANUFACTURER;
        String dev = Build.VERSION.RELEASE;
        String model = Build.MODEL;
        String os_type ="Android";
        String location ="Durban";
        String user_name = "Pinkie";
        String user_id = "dubepinkie07@gmail.com";


        displayPoll = (TextView) findViewById(R.id.tvpostdata);
        displayPoll.setText(os + " \n " + dev + " \n"  + model  + "  \n " + location +
                                 " \n " + user_name + " \n " + user_id + " \n " + os_type );



    }
    private void QueryResults() {
        myRealm.beginTransaction();
        RealmResults<SavepollDetails> query = myRealm.where(SavepollDetails.class).findAll();

        for (SavepollDetails r : query) {

//            display.setText("Title: " + r.getPoll_title() + "\nQuestion : " + r.getQuestion() + "\nEnd date: "
//                    + r.getEnd_date() + "\nGuid: " + r.getPoll_guid());

        }


        myRealm.commitTransaction();

    }

//    public void sendPost(String os, String dev, String model, String os_type, String location, String user_name, String user_id)
//    {
//        mpostService.savePost().enqueue(new Callback<PostModel>() {
//            @Override
//            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<PostModel> call, Throwable t)
//            {
//                Log.e("Tag", "unable to submit post Api");
//            }
//        });
//    }
}
