package com.example.hsuser4.poll_messenger.Activities.Activities.Activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hsuser4.poll_messenger.R;

import java.util.Random;

public class Poll_Details extends AppCompatActivity {
    //Declare variables
    TextView txtmessage;
    Button btn_skip;

    //Array for DYK
    private String[] DYK_Message;
    //Random Generator
    private static final Random rgenerator = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_details);

        StringBuilder builder = new StringBuilder();
        builder.append("android : ").append(Build.VERSION.RELEASE);


        btn_skip = (Button) findViewById(R.id.button_skip);

        Resources res =getResources();
        DYK_Message = res.getStringArray(R.array.messageArray);

        String m = DYK_Message[rgenerator.nextInt(DYK_Message.length)];

        txtmessage = (TextView) findViewById(R.id.textview_display);
        txtmessage.setText(m);

//        //Meta data version
//        String os = Build.MANUFACTURER;
//        String dev = Build.VERSION.RELEASE;
//        String dev4 = Build.MODEL;
//
//
//        txtmessage = (TextView) findViewById(R.id.textview_display);
//        txtmessage.setText(os + " - " + dev + " - "  + dev4 );

        //Button clicked open main activity
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myintent);

            }
        });


    }
}


