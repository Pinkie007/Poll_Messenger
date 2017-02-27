package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.app.Activity;
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
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PollAnswerModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.ApiClient;
import com.example.hsuser4.poll_messenger.Activities.Activities.Services.PollApi;
import com.example.hsuser4.poll_messenger.R;
import com.google.gson.JsonObject;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.hsuser4.poll_messenger.Activities.Activities.Services.ApiClient.base_url;

public class MainActivity extends AppCompatActivity {
    Button btnguest;
    public DisplayRecords displaypoll;
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
        setContentView(R.layout.activity_main);
        btnguest = (Button) findViewById(R.id.button_guest);

        //Button clicked open main activity
        btnguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Retrofit retrofit = ApiClient.getClient(base_url);

                mService = retrofit.create(PollApi.class);

                final Call<JsonObject> call = mService.GetLastPoll("");

                new GetLastPollTask().execute(call);

               // tvJson.setText("Json response : " + JSON);
                Intent myintent = new Intent(getApplicationContext(), PollsDisplayActivity.class);
                startActivity(myintent);
                checkForUpdates();

            }

        });


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

                JSONObject poll = new JSONObject(String.valueOf(pollJson));



                displaypoll = new DisplayRecords();
                displaypoll.setPoll_guid(poll.getString("poll_guid").toString());
                displaypoll.setPoll_title(poll.getString("poll_title").toString());
                displaypoll.setPoll_description(poll.getString("poll_description").toString());
                displaypoll.setPoll_question(poll.getString("question").toString());
                displaypoll.setEnd_date(poll.getString("end_date").toString());
                displaypoll.setStatus(poll.getInt("status"));


                List<Object> answerJSON = new ArrayList<>();
                List<Object> answerJSON2 = new ArrayList<>();
                List<Object> answerJSON3 = new ArrayList<>();
                List<Object> answerJSON4 = new ArrayList<>();

                try {

                    JSONObject answerArray1 = poll.getJSONObject("answer");
                    answerJSON.add(answerArray1.get("answer_id"));
                    answerJSON.add(answerArray1.get("answer"));
                    displaypoll.setAnswer1(answerJSON);

                    JSONObject answerArray2 = poll.getJSONObject("answer2");
                    answerJSON2.add(answerArray2.get("answer_id"));
                    answerJSON2.add(answerArray2.get("answer"));
                    displaypoll.setAnswer2(answerJSON2);


                    JSONObject answerArray3 = poll.getJSONObject("answer3");
                    answerJSON3.add(answerArray3.get("answer_id"));
                    answerJSON3.add(answerArray3.get("answer"));
                    displaypoll.setAnswer3(answerJSON3);


                    JSONObject answerArray4 = poll.getJSONObject("answer4");
                    answerJSON4.add(answerArray4.get("answer_id"));
                    answerJSON4.add(answerArray4.get("answer"));
                    displaypoll.setAnswer4(answerJSON4);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


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

               // Toast.makeText(MainActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
            }

        }

    }

    protected void savepollDetails(DisplayRecords displaypoll) {
        //Initialize Realm
        Realm.init(this);

        //obtain realm instance
        myRealm = Realm.getDefaultInstance();

        SavepollDetails savepollDetails = new SavepollDetails();

        String pollGUID = displaypoll.getPoll_guid();

        myRealm.beginTransaction();

        //Storing data into realm

        savepollDetails.setPoll_guid(pollGUID);
        savepollDetails.setPoll_title(displaypoll.getPoll_title());
        savepollDetails.setQuestion(displaypoll.getQuestion());
        savepollDetails.setStatus(displaypoll.getStatus());
        savepollDetails.setEnd_date(displaypoll.getEnd_date());


        myRealm.copyToRealmOrUpdate(savepollDetails);
        myRealm.commitTransaction();

        PollAnswerModel pollAnswerModel = new PollAnswerModel();
        List<Object> ansObj = displaypoll.getAnswer1();
        pollAnswerModel.setPollIdentifier(pollGUID);
        pollAnswerModel.setAnswerID((int)ansObj.get(0));
        pollAnswerModel.setAnswerDescription((String)ansObj.get(1));
        SaveAnswerToRealm(pollAnswerModel);

        PollAnswerModel pollAnswerModel2 = new PollAnswerModel();
        List<Object> ansObj2 = displaypoll.getAnswer2();
        pollAnswerModel2.setPollIdentifier(pollGUID);
        pollAnswerModel2.setAnswerID((int)ansObj2.get(0));
        pollAnswerModel2.setAnswerDescription((String)ansObj2.get(1));
        SaveAnswerToRealm(pollAnswerModel2);

        PollAnswerModel pollAnswerModel3 = new PollAnswerModel();
        List<Object> ansObj3 = displaypoll.getAnswer3();
        if(ansObj3 != null){

            pollAnswerModel3.setPollIdentifier(pollGUID);
            pollAnswerModel3.setAnswerID((int)ansObj3.get(0));
            pollAnswerModel3.setAnswerDescription((String)ansObj3.get(1));
            SaveAnswerToRealm(pollAnswerModel3);
        }

        PollAnswerModel pollAnswerModel4 = new PollAnswerModel();
        List<Object> ansObj4 = displaypoll.getAnswer4();
        if(ansObj4 != null){

            pollAnswerModel4.setPollIdentifier(pollGUID);
            pollAnswerModel4.setAnswerID((int)ansObj4.get(0));
            pollAnswerModel4.setAnswerDescription((String)ansObj4.get(1));
            SaveAnswerToRealm(pollAnswerModel4);
        }
        Intent intent = new Intent(getApplicationContext(),PollsDisplayActivity.class);
        startActivity(intent);
        // QueryResults();
    }

    public void SaveAnswerToRealm(PollAnswerModel pollAnswerModel){
        //Initialize Realm
        Realm.init(this);

        //obtain realm instance
        myRealm = Realm.getDefaultInstance();
        myRealm.beginTransaction();


        myRealm.copyToRealmOrUpdate(pollAnswerModel);
        myRealm.commitTransaction();
    }

    private void QueryResults() {
        myRealm.beginTransaction();
        RealmResults<SavepollDetails> query = myRealm.where(SavepollDetails.class).findAll();
        RealmResults<PollAnswerModel> answerQuery = myRealm.where(PollAnswerModel.class).findAll();

        for (SavepollDetails r : query) {

            tvJson.setText("Title: " + r.getPoll_title() + "\nQuestion : " + r.getQuestion() + "\nEnd date: "
                    + r.getEnd_date() + "\nGuid: " + r.getPoll_guid());

            Log.d("GUID: ", r.getPoll_guid());
            Log.d("Title: ", r.getPoll_title());
            Log.d("Question : ", r.getQuestion());

        }

        for (PollAnswerModel ans : answerQuery) {

            tvJson.append("Answer ID: " + ans.getAnswerID() + "\nAnswer : " + ans.getAnswerDescription() + "\nBelongs to PollGUID: "
                    + ans.getPollIdentifier());

            Log.d("GUID: ", ans.getPollIdentifier());
            Log.d("Answer: ", ans.getAnswerDescription());
            Log.d("Answer ID: ", "" + ans.getAnswerID());

        }

        myRealm.commitTransaction();

    }

//
//    @Override
//    public void onDestroy() {
//        if (!myRealm.isClosed()) {
//            myRealm.close();
//        }
//        super.onDestroy();
//    }
//}
//
//}


      @Override
    public void onResume() {
        super.onResume();
        // ... your own onResume implementation
        checkForCrashes();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterManagers();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterManagers();
    }

    private void checkForCrashes() {
        CrashManager.register(this);
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this);
    }

    private void unregisterManagers() {
        UpdateManager.unregister();
    }

}