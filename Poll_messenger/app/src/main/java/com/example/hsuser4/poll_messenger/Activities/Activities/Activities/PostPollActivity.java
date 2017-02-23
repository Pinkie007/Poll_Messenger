package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PostPollModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.ApiUtils;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.PostApi;
import com.example.hsuser4.poll_messenger.R;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPollActivity extends AppCompatActivity {

    TextView displayPost;
    private PostApi mpostService;

    Realm myRealm;

    String Guid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_poll);

        Button btnPost = (Button) findViewById(R.id.btnPost);

              mpostService = ApiUtils.getPostApi();

        //Meta data version
        //guid is here
        final int answer_id =0;
        final String os_type = "Android";
        final String location = "Durban";
        final String manu = Build.MANUFACTURER;
        final String dev = Build.VERSION.RELEASE;
        final String os_version = Build.MODEL;
        final String user_name = "Pinkie";
        final String user_id = "dubepinkie07@gmail.com";
        final String dateVoted = "";

        displayPost = (TextView) findViewById(R.id.tvpostdata);
        displayPost.setText(manu + " \n " + dev + " \n" + os_version + "  \n " + location +
                " \n " + user_name + " \n " + user_id + " \n " + os_type + "\n" + Guid + "\n" + answer_id);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QueryResults();
                sendPost(Guid, answer_id, os_type, location, manu, dev, os_version, user_name, user_id, dateVoted);
            }
        });
    }
    private void QueryResults() {
        myRealm.beginTransaction();
        RealmResults<SavepollDetails> query = myRealm.where(SavepollDetails.class).findAll();

        for (SavepollDetails r : query) {

            displayPost.setText("Title: " + r.getPoll_title() + "\nQuestion : " + r.getQuestion() + "\nEnd date: "
                    + r.getEnd_date() + "\nGuid: " + r.getPoll_guid());
            Guid = r.getPoll_guid();
        }
        myRealm.commitTransaction();
    }
    public void sendPost(String pollGuid, int ansId, String os_type, String location, String manufacturer,String device_model,
                         String os_version, String user_name, String user_id, String date_voted)
    {
        mpostService.savePost(pollGuid, ansId,os_type, location,manufacturer,device_model,os_version,user_name,user_id,date_voted).enqueue(new Callback<PostPollModel>() {
            @Override
            public void onResponse(Call<PostPollModel> call, Response<PostPollModel> response) {
                if(response.isSuccessful())
                {
                    showResponse(response.body().toString());
                    Log.i("TAG", "post submitted to API" + response.body().toString());

                }
            }
            @Override
            public void onFailure(Call<PostPollModel> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API" );
            }
        });
    }
    public void showResponse(String response ) {

    }


}