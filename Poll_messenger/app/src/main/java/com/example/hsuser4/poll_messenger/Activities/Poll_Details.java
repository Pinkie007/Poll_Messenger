package com.example.hsuser4.poll_messenger.Activities;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hsuser4.poll_messenger.Activities.MainActivity;
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
        setContentView(R.layout.activity_poll__details);

        btn_skip = (Button) findViewById(R.id.button_skip);

        Resources res =getResources();
        DYK_Message = res.getStringArray(R.array.messageArray);

        String m = DYK_Message[rgenerator.nextInt(DYK_Message.length)];

        txtmessage = (TextView) findViewById(R.id.textview_display);
        txtmessage.setText(m);


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


