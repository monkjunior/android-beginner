package com.example.ex1_intent_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Demo android intent
        Intent myIntent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("content://contacts/people")
        );

        startActivity(myIntent);
    }
}
