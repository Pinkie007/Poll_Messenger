package com.example.hsuser4.poll_messenger.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hsuser4.poll_messenger.R;

public class MainActivity extends AppCompatActivity {
    Button btnguest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnguest = (Button)findViewById(R.id.button_guest);


        //Button clicked open main activity
        btnguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), Messenger.class);
                startActivity(myintent);

            }
        });
    }

}


