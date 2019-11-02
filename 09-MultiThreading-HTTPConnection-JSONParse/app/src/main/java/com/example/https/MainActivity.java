package com.example.https;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    AsyncTask http = new AsyncTask() {
        StringBuilder response = new StringBuilder();
        JSONArray jsonArray ;


        @Override
        protected JSONArray doInBackground(Object[] objects) {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/users");

                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                Log.v("TAG", "Sending GET request to " + url.toString());
                Log.v("TAG", "Response Code: " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String inputLine;

                while ((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();

                Log.v("TAG", response.toString());

                String json = response.toString();
                try{
                    jsonArray= new JSONArray(json);
                    Log.v("TAG", "JSONArray : "+ jsonArray.get(1));
                }
                catch (JSONException ex){
                    Log.v("TAG", "Can not parse to JSON");
                }

            } catch (IOException ex){

            }
            return jsonArray;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        http.execute();




    }
}
