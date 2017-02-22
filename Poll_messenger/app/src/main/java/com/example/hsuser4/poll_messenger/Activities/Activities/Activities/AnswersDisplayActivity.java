package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hsuser4.poll_messenger.Activities.Activities.Adapter.AnswerOptionsAdapter;
import com.example.hsuser4.poll_messenger.Activities.Activities.Adapter.PollAdapter;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.PollAnswerModel;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.SavepollDetails;
import com.example.hsuser4.poll_messenger.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class AnswersDisplayActivity extends AppCompatActivity {
    //Declare variables
    //Realm
    Realm myRealm;
    private RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //AnswerOptionsAdapter answerOptionsAdapter = new AnswerOptionsAdapter(arrayList, this);
    ArrayList<PollAnswerModel> arrayList = new ArrayList<PollAnswerModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        QueryResults();
        String guid = "";

        if(getIntent().getStringExtra("Poll GUID") != null){
            guid = getIntent().getStringExtra("Poll GUID").toString();
        }


        //TODO: take guid variable and query realm database on answermodel where answertmodel pollIdentier value is equal to guid


       AnswerOptionsAdapter answerOptionsAdapter = new AnswerOptionsAdapter(arrayList, this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_display);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(answerOptionsAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


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


        }

        for (PollAnswerModel ans : answerQuery) {
            arrayList.add(ans);
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