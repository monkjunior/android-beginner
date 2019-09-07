package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**Call when button CLEAR is pressed**/
    public void clearInput (View v){
        TextView usd = (TextView) findViewById(R.id.INPUTUSD);
        TextView eur = (TextView) findViewById(R.id.INPUTEUR);
        TextView vnd = (TextView) findViewById(R.id.INPUTVND);

        usd.setText("");
        eur.setText("");
        vnd.setText("");
    }

    /**Call when button CONVERT is pressed**/
    public void convertCurrencies (View v){
        TextView usd = (TextView) findViewById(R.id.INPUTUSD);
        TextView eur = (TextView) findViewById(R.id.INPUTEUR);
        TextView vnd = (TextView) findViewById(R.id.INPUTVND);

        String value_usd = usd.getText().toString();
        float value = Float.valueOf(value_usd);

        eur.setText(String.valueOf(value*0.91));
        vnd.setText(String.valueOf(value*22000));
    }
}
