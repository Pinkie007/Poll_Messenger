package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hsuser4.poll_messenger.Activities.Activities.Adapter.PollAdapter;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PollAnswerModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class PollsDisplayActivity extends AppCompatActivity {
    //Declare variables

    RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    RecyclerView mRecyclerview;
    //Realm
    Realm myRealm;
    ArrayList<SavepollDetails> arrayList = new ArrayList<SavepollDetails>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_polls_display);

        QueryResults();

        mRecyclerview= (RecyclerView)findViewById(R.id.recyclerviw_holder);



        PollAdapter pollAdapter = new PollAdapter(arrayList, this);


        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setAdapter(pollAdapter);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(layoutManager);




    }

    private void QueryResults() {

        //Initialize Realm
        Realm.init(this);

        //obtain realm instance
        myRealm = Realm.getDefaultInstance();

        myRealm.beginTransaction();

        RealmResults<SavepollDetails> query = myRealm.where(SavepollDetails.class).findAll();
        RealmResults<PollAnswerModel> answerQuery = myRealm.where(PollAnswerModel.class).findAll();


        for (SavepollDetails r : query) {
            arrayList.add(r);

        }

        for (PollAnswerModel ans : answerQuery) {

        }

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
