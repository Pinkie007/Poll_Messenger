package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hsuser4.poll_messenger.Activities.Activities.Adapter.PollAdapter;
import com.example.hsuser4.poll_messenger.Activities.Activities.Model.DisplayRecords;
import com.example.hsuser4.poll_messenger.R;

import java.util.ArrayList;

import io.realm.Realm;

public class Display_Data extends AppCompatActivity {
    //Declare variables
    private Realm myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        RecyclerView view = (RecyclerView) findViewById(R.id.recyclerview_display);
        PollAdapter PollAdapter = new PollAdapter(this);
        view.setAdapter(PollAdapter);
        view.setLayoutManager(new LinearLayoutManager(this));

        //Initialize Realm
        Realm.init(this);

        //obtain realm instance
        myRealm = Realm.getDefaultInstance();

        saveRecord();
    }

    public void saveRecord() {

        myRealm.beginTransaction();

        myRealm.commitTransaction();


    }
    }
