package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.app.ProgressDialog;
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
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Messenger extends AppCompatActivity {
    private List<DisplayRecords> displaypoll;
    PollApi mService;
    TextView tvJson;
    public String JSON = "";
    public ProgressDialog mProgressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Button button = (Button) findViewById(R.id.btnDisplay);
        tvJson = (TextView) findViewById(R.id.tvJson);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Retrofit retrofit = ApiClient.getClient();

                mService = retrofit.create(PollApi.class);

                final Call<JsonObject> call = mService.GetLastPoll("123");


                new GetLastPollTask().execute(call);

                tvJson.setText("Json response :" + JSON);

            }

            class GetLastPollTask extends AsyncTask<Call, Void, List<DisplayRecords>> {
                @Override
                protected void onPreExecute()
                {

                }
                @Override
                protected List<DisplayRecords> doInBackground(Call... params) {
                    Call<JsonObject> call = params[0];
                    Response<JsonObject> pollResponse;
                    try {

                        pollResponse = call.execute();

                        JsonObject pollJson = pollResponse.body();
                        JsonObject jArray = pollJson.getAsJsonObject();

                        JSONObject foo = new JSONObject(String.valueOf(pollJson));

                        //foo = foo.
                        String poll = foo.get("poll_guid").toString();
                        String pollTitle = foo.get("poll_title").toString();
                        String Type = foo.get("question").toString();



                        Log.d("Tag", pollTitle + Type );
                        JSON = poll + "_" + pollTitle + "_" + Type;
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

                protected void onPostExecute(List<DisplayRecords>displayRecordses)
                {
                    super.onPostExecute(displayRecordses);
                }

            }

        });
        //tvJson.setText(JSON);
    }
}





