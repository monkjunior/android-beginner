package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String myNb = "tel:0974683289";
        Intent myActivity2 = new Intent(Intent.ACTION_DIAL, Uri.parse(myNb));
        startActivity(myActivity2);
    }
}
