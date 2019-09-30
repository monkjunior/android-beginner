package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    TextView txtMsg;

    String[] items = {"Data-1", "Data-2", "Data-3", "Data-4", "Data-5", "Data-6", "Data-7"};
    // Next time try empty list such as
    // String[] items = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items));

        getListView().setBackgroundColor(Color.GRAY);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
    }

}
