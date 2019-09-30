package com.example.caculator;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    EditText crunchifyEditText1, crunchifyEditText2;

    float mValueOne, mValueTwo;

    boolean crunchifyAddition, mSubtract, crunchifyMultiplication, crunchifyDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        crunchifyEditText1 = (EditText) findViewById(R.id.edt1);
        crunchifyEditText2 = (EditText) findViewById(R.id.edt2);

        //Set crunchifyEditText2 not editable
        crunchifyEditText2.setInputType(EditorInfo.TYPE_NULL);

        //Init mValueoOne = 0
        mValueOne = 0;


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + "0");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText("");
                crunchifyEditText2.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText1.setText(crunchifyEditText1.getText() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (crunchifyEditText1 == null) {
                    crunchifyEditText1.setText("0");
                } else {
                    mValueTwo = Float.parseFloat(crunchifyEditText1.getText() + "");
                    mValueOne = mValueOne + mValueTwo;
                    crunchifyAddition = true;
                    crunchifyEditText2.setText(String.valueOf(mValueOne) + " +");
                    crunchifyEditText1.setText("0");

                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText1 == null) {
                    crunchifyEditText1.setText("0");
                }
                else{
                    mValueTwo = Float.parseFloat(crunchifyEditText1.getText() + "");
                    mValueOne = mValueOne - mValueTwo;
                    mSubtract = true;
                    crunchifyEditText2.setText(String.valueOf(mValueOne) + " -");
                    crunchifyEditText1.setText("0");
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText1 == null) {
                    crunchifyEditText1.setText("0");
                }
                else{
                    mValueTwo = Float.parseFloat(crunchifyEditText1.getText() + "");
                    mValueOne = mValueOne*mValueTwo;
                    crunchifyMultiplication = true;
                    crunchifyEditText2.setText(String.valueOf(mValueOne) + " *");
                    crunchifyEditText1.setText("0");
                }

            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText1 == null) {
                    crunchifyEditText1.setText("0");
                }
                else {
                    mValueTwo = Float.parseFloat(crunchifyEditText1.getText() + "");
                    if (mValueTwo == 0){
                        Toast.makeText(context, "Can not divide by zero!", duration);
                    }
                    else{
                        mValueOne = mValueOne/mValueTwo;
                    }
                    crunchifyDivision = true;
                    crunchifyEditText2.setText(String.valueOf(mValueOne) + " /");
                    crunchifyEditText1.setText("0");
                }

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(crunchifyEditText1.getText() + "");

                if (crunchifyAddition == true) {
                    mValueOne =  mValueOne + mValueTwo;
                    crunchifyEditText2.setText(mValueOne + "");
                    crunchifyEditText1.setText("0");
                    crunchifyAddition = false;
                }

                if (mSubtract == true) {
                    mValueOne = mValueOne - mValueTwo;
                    crunchifyEditText2.setText(mValueOne + "");
                    crunchifyEditText1.setText("0");
                    mSubtract = false;
                }

                if (crunchifyMultiplication == true) {
                    mValueOne = mValueOne * mValueTwo;
                    crunchifyEditText2.setText(mValueOne + "");
                    crunchifyEditText1.setText("0");
                    crunchifyMultiplication = false;
                }

                if (crunchifyDivision == true) {
                    if (mValueTwo == 0){
                        Toast.makeText(context, "Can not divide by zero!", duration);
                    }
                    else{
                        mValueOne = mValueOne/mValueTwo;
                    }
                    crunchifyEditText2.setText(mValueOne + "");
                    crunchifyEditText1.setText("0");
                    crunchifyDivision = false;
                }
            }
        });


    }
}