package com.example.gmail;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    String[] receivers = { "User-1", "User-2", "User-3", "User-4", "User-5",
            "User-6", "User-7", "User-8", "User-9", "User-10", "User-11",
            "User-12", "User-13", "User-14", "User-15" };

    String[] mails = { "Data-1", "Data-2", "Data-3", "Data-4", "Data-5",
            "Data-6", "Data-7", "Data-8", "Data-9", "Data-10", "Data-11",
            "Data-12", "Data-13", "Data-14", "Data-15" };

    Integer[] thumbnails = { R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp};

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.myListView);

        CustomIconLabelAdapter aa = new CustomIconLabelAdapter(
                this,
                R.layout.custom_row,
                receivers,
                mails,
                thumbnails
        );

        myListView.setAdapter(aa);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String text = "Position: " + position
                        + "\nData: " + mails[position];
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
