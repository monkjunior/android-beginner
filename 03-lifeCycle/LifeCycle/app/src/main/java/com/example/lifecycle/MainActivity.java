package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Class variables
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    // PLUMBING: Pairing GUI controls with Java objects
    private Button btnExit;
    private EditText txtColorSelected;
    private TextView txtSpyBox;
    private LinearLayout myScreen;
    private String PREFNAME = "myPrefFile1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wiring GUI controls to Java Object
        txtColorSelected = (EditText)findViewById(R.id.editText1);
        btnExit = (Button)findViewById(R.id.button1);
        txtSpyBox= (TextView)findViewById(R.id.textView1);
        myScreen = (LinearLayout)findViewById(R.id.myScreen1);

        // Set UI listener watcher
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Observe (text) changes made to EditText box (color selection)
        txtColorSelected.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Nothing TODO, needed interface
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Nothing TODO, needed interface
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Set background to selected color
                String chosenColor = editable.toString().toLowerCase(Locale.US);
                txtSpyBox.setText(chosenColor);
                setBackgroundColor(chosenColor, myScreen);
            }
        });

        context = getApplicationContext();
        Toast.makeText(context, "onCreate", duration).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // If appropriate, change background color to chosen value
        updateMeUsingSavedStateData();

        Toast.makeText(context, "onStart", duration).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(context, "onStop", duration).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(context, "onDestroy", duration).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save state data (background color) for future use
        String chosenColor = txtSpyBox.getText().toString();
        saveStateData(chosenColor);

        Toast.makeText(context, "onPause", duration).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(context, "onResume", duration).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(context, "onRestart", duration).show();
    }

    private void setBackgroundColor(String chosenColor, LinearLayout myScreen){
        //hex color codes: 0xAARRGGBB AA:transp, RR red, GG green, BB blue
        if (chosenColor.contains("red"))
            myScreen.setBackgroundColor(0xffff0000);
        if (chosenColor.contains("green"))
            myScreen.setBackgroundColor(0xff00ff00);
        if (chosenColor.contains("blue"))
            myScreen.setBackgroundColor(0xff0000ff);
        if (chosenColor.contains("white"))
            myScreen.setBackgroundColor(0xffffffff);
    } // Set background color

    private void saveStateData(String chosenColor){
        // This is a little <key,value> table permanently kept in memory
        SharedPreferences myPrefContainer = getSharedPreferences(PREFNAME, Activity.MODE_PRIVATE);

        // Pair <key, value> to be stored represent our 'important' data
        SharedPreferences.Editor myPrefEditor = myPrefContainer.edit();
        String key = "chosenBackgroundColor";
        String value = txtSpyBox.getText().toString();
        myPrefEditor.putString(key, value);
        myPrefEditor.commit();
    } // Save data

    private void updateMeUsingSavedStateData(){
        // (in case it exists) Use saved data telling backg color
        SharedPreferences myPrefContainer = getSharedPreferences(PREFNAME, Activity.MODE_PRIVATE);

        String key = "chosenBackgroundColor";
        String defaultValue = "white";

        if (( myPrefContainer != null ) && myPrefContainer.contains(key)){
            String color = myPrefContainer.getString(key, defaultValue);
            setBackgroundColor(color, myScreen);
        }
    }
}
