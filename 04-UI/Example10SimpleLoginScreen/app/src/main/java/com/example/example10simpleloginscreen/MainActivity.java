package com.example.example10simpleloginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    Button btnLogin;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (EditText) findViewById(R.id.txtName);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        context = getApplicationContext();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = txtName.getText().toString();

                if (msg.toLowerCase().equals("ted")){
                    Toast.makeText(context, "Logged in", Toast.LENGTH_SHORT).show();
                    btnLogin.setEnabled(false);
                }
                else{
                    Toast.makeText(context, "Wrong user name", Toast.LENGTH_SHORT).show();
                    btnLogin.setEnabled(true);
                }

            }
        });

    }
}
