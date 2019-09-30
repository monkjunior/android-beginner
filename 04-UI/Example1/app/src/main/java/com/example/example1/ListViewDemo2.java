package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewDemo2 extends Activity {

    ListView myListView;
    TextView txtMsg;

    String[] items = {"Data-1", "Data-2", "Data-3", "Data-4", "Data-5", "Data-6", "Data-7"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo2);
        myListView = (ListView) findViewById(R.id.my_list);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);

        myListView.setAdapter(aa);

        txtMsg = (TextView) findViewById(R.id.txtMsg);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String text = "Position: " + position
                        + "\nData: " + items[position];
                txtMsg.setText(text);
            }
        });
    }

}
