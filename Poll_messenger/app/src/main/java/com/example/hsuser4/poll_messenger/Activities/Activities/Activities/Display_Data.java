package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hsuser4.poll_messenger.R;

import io.realm.Realm;

public class Display_Data extends AppCompatActivity {
    //Declare variables
    private Realm myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

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