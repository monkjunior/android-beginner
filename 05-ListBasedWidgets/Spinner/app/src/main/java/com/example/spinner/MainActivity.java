package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String[] receivers = { "User-1", "User-2", "User-3", "User-4", "User-5",
            "User-6", "User-7", "User-8", "User-9", "User-10", "User-11",
            "User-12", "User-13", "User-14", "User-15" };

    String[] mails = { "Data-1", "Data-2", "Data-3", "Data-4", "Data-5",
            "Data-6", "Data-7", "Data-8", "Data-9", "Data-10", "Data-11",
            "Data-12", "Data-13", "Data-14", "Data-15" };

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        //CustomAdapter aa = new CustomAdapter(this, R.layout.custom_row,receivers, mails);
        ArrayAdapter aa = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, receivers);
        spinner.setAdapter(aa);
    }
}
