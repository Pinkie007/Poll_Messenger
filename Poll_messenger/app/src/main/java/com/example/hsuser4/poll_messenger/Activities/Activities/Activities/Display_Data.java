package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.hsuser4.poll_messenger.R;

import io.realm.Realm;

public class Display_Data extends AppCompatActivity {
    //Declare variables
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_display);
        recyclerView.setHasFixedSize(true);





    }
}