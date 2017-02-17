package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.DisplayRecords;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.ApiClient;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.PollApi;
import com.example.hsuser4.poll_messenger.R;
import com.google.gson.JsonObject;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Messenger extends AppCompatActivity {
    private DisplayRecords displaypoll;
    PollApi mService;
    TextView tvJson;
    public String JSON = "";
    public ProgressDialog mProgressDialog;
    TextView title, decription, question;
    Button answer, AnswerOne, AnswerTwo, AnswerThree, AnswerFour;

    //Realm
    Realm myRealm;

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

                tvJson.setText("Json response : " + JSON);

            }

            class GetLastPollTask extends AsyncTask<Call, Void, DisplayRecords> {

                @Override
                protected void onPreExecute() {
                   // showProgressDialog();

                }

                @Override
                protected DisplayRecords doInBackground(Call... params) {
                    Call<JsonObject> call = params[0];
                    Response<JsonObject> pollResponse;

                    try {
                        pollResponse = call.execute();

                        JsonObject pollJson = pollResponse.body();
                        //JsonObject jArray = pollJson.getAsJsonObject();

                        JSONObject foo = new JSONObject(String.valueOf(pollJson));
                        //JSONObject Object2 = new JSONObject(String.valueOf(pollJson));

                        JSONObject Object1 = foo.getJSONObject("answer");
                        String strAns1 = Object1.getString("answer").toString();
                        String AnsId1 = Object1.getString("answer_id").toString();

                        JSONObject Object2 = foo.getJSONObject("answer2");
                        String strAns2 = Object2.getString("answer").toString();
                        String AnsId2 = Object2.getString("answer_id").toString();

                        JSONObject Object3 = foo.getJSONObject("answer3");
                        String strAns3 = Object3.getString("answer").toString();
                        String AnsId3 = Object3.getString("answer_id").toString();

                        JSONObject Object4 = foo.getJSONObject("answer4");
                        String strAns4 = Object4.getString("answer").toString();
                        String AnsId4 = Object4.getString("answer_id").toString();

                        Log.d("Answer: ", strAns1);
                        Log.d("Answer: ", strAns2);
                        Log.d("Answer: ", strAns3);

                        Log.d("Answer Id: ", AnsId1);
                        Log.d("Answer Id: ", AnsId2);
                        Log.d("Answer Id: ", AnsId3);




                        //foo = foo.
                        displaypoll = new DisplayRecords();
                        displaypoll.setPoll_guid(foo.getString("poll_guid").toString());
                        displaypoll.setPoll_title(foo.getString("poll_title").toString());
                        displaypoll.setPoll_description(foo.getString("poll_description").toString());
                        displaypoll.setPoll_question(foo.getString("question").toString());
                        displaypoll.setEnd_date(foo.getString("end_date").toString());
                        displaypoll.setStatus(foo.getInt("status"));
                        displaypoll.setAnswer1(strAns1);
                        displaypoll.setAnswer2(strAns2);
                        displaypoll.setAnswer3(strAns3);
                        displaypoll.setAnswer4(strAns4);




                        //String answers = foo.get("answer").getClass().getField("answer").toString();
                        //String answer2 = foo.get("answer2").getClass().getField("answer").toString();
                        //         Log.d("Tag", pollTitle + Type + date);
//                       JSON = poll + "\n" + pollTitle + "\n" + Type + "\n" + question + "\n" + date + "\n" + status;


                        return displaypoll;

                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                    return null;

                }

                @Override
                protected void onPostExecute(DisplayRecords displaypoll) {

                    if (displaypoll != null) {

                        savepollDetails(displaypoll);
                    } else {

                        Toast.makeText(Messenger.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }

    protected void savepollDetails(DisplayRecords displaypoll) {
        //Initialize Realm
        Realm.init(this);

        //obtain realm instance
        myRealm = Realm.getDefaultInstance();

        SavepollDetails savepollDetails = new SavepollDetails();

        myRealm.beginTransaction();


        savepollDetails.setPoll_guid(displaypoll.getPoll_guid());
        savepollDetails.setPoll_title(displaypoll.getPoll_title());
        savepollDetails.setQuestion(displaypoll.getQuestion());
        savepollDetails.setStatus(displaypoll.getStatus());
        savepollDetails.setEnd_date(displaypoll.getEnd_date());

        myRealm.copyToRealmOrUpdate(savepollDetails);
        myRealm.commitTransaction();


        QueryResults();
    }

    private void QueryResults() {
        myRealm.beginTransaction();
        RealmResults<SavepollDetails> query = myRealm.where(SavepollDetails.class).findAll();



        for (SavepollDetails r : query) {

            tvJson.setText("Title: " + r.getPoll_title() + "\nQuestion : " + r.getQuestion()  + "\nEnd date ");
           //+ r.getEnd_date() + "Answer:" + r.getAnswer1()
            //  + "Answer 2:" + r.getAnswer2()  + "Answer 3" + r.getAnswer3() + "Answer 4 :"  + r.getAnswer4());

            Log.d("GUID: ", r.getPoll_guid());
            Log.d("Title: ", r.getPoll_title());

        }

        //        //Add query conditions
        //        query.equalTo("poll_title", savepollDetails());
        //
        //        query.or().equalTo("poll_title", SavepollDetails);

        //execute the query:
        myRealm.commitTransaction();

    }

    @Override
    public void onDestroy() {
        if (!myRealm.isClosed()) {
            myRealm.close();
        }
        super.onDestroy();
    }
}
//
//
//    public void showProgressDialog() {
//        if (mProgressDialog == null) {
//            mProgressDialog.setMessage("Loading");
//            mProgressDialog.setProgressStyle(2);
//            mProgressDialog.setIndeterminate(true);
//        }
//        mProgressDialog.show();
//    }


























