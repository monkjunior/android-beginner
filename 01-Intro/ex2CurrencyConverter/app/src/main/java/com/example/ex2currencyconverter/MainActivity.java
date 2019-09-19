package com.example.ex2currencyconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    // USA money format (12 digits, 2 decimals)
    DecimalFormat usaDf = new DecimalFormat("###,###,###,###.##");

    // Naive currency converter :D
    private final double EURO2USD = 1.35;
    private final char EUROSYM = '\u20AC';
    private final double COLON2USD = 0.0019;
    private final char COLONSYM = '\u20A1';
    private final String VNDSYM = "VND ";
    private final double USD2VND = 23218.20;

    //GUI Widgets
    Button btnConvert;
    Button btnClear;
    EditText txtUSDollars;
    EditText txtEuros;
    EditText txtColones;
    EditText txtVnds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind local control to GUI Widgets
        txtUSDollars = (EditText)findViewById(R.id.txtUSDollars);
        txtEuros = (EditText)findViewById(R.id.txtEuros);
        txtColones = (EditText)findViewById(R.id.txtColones);
        txtVnds = (EditText)findViewById(R.id.txtVnds);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnConvert = (Button)findViewById(R.id.btnConvert);

        // Make EUROS, COLONES, VNDS edit text to be not-editable
        txtEuros.setInputType(EditorInfo.TYPE_NULL);
        txtColones.setInputType(EditorInfo.TYPE_NULL);
        txtVnds.setInputType(EditorInfo.TYPE_NULL);

        // Click behavior for btnClear
        btnClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                txtUSDollars.setText("");
                txtEuros.setText("");
                txtColones.setText("");
                txtVnds.setText("");
            }
        });

        // Click behavior for btnConvert
        btnConvert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String usdStr = txtUSDollars.getText().toString();
                    double usd = Double.parseDouble(usdStr);
                    String euros = EUROSYM + String.valueOf(usaDf.format(usd/EURO2USD));
                    String colones = COLONSYM + String.valueOf(usaDf.format(usd/COLON2USD));
                    String vnds = VNDSYM + String.valueOf(usaDf.format(usd*USD2VND));
                    txtEuros.setText(euros);
                    txtColones.setText(colones);
                    txtVnds.setText(vnds);
                } catch (NumberFormatException e){
                    // Ignore errors
                }
            }
        });

    }
}
