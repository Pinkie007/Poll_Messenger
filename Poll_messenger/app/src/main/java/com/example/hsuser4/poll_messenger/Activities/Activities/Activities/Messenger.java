package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hsuser4.poll_messenger.Activities.Activities.Model.DisplayRecords;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.ApiClient;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.PollApi;
import com.example.hsuser4.poll_messenger.R;
import com.google.gson.JsonArray;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Messenger extends AppCompatActivity {
    private List<DisplayRecords> displaypoll;
    PollApi mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Button button = (Button) findViewById(R.id.btnDisplay);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Retrofit retrofit = ApiClient.getClient();

                mService = retrofit.create(PollApi.class);

                final Call<JsonArray> call = mService.GetLastPoll("123");


                new GetLastPollTask().execute(call);

            }

            class GetLastPollTask extends AsyncTask<Call, Void, List<DisplayRecords>> {


                @Override
                protected List<DisplayRecords> doInBackground(Call... params) {
                    Call<JsonArray> call = params[0];
                    Response<JsonArray> pollResponse;

                    try {

                        pollResponse = call.execute();

                        JsonArray pollJson = pollResponse.body();
                        JsonArray jArray = pollJson.getAsJsonArray();


                        Log.d("Tag", String.valueOf(pollJson));
                        //  String i = jArray.get(0).getAsString();


                        //Getting all the values
                        String title = pollJson.getAsString();
                        String id = pollJson.getAsString();
                        String description = pollJson.getAsString();
                        String ArrayList = pollJson.getAsString();


                        return displaypoll;

                    } catch (Exception e) {

                        e.printStackTrace();
                    }


                    return null;

                }
            }
        });
    }
}





