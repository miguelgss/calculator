package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Number Buttons
        Button btnZero = (Button)findViewById(R.id.btnZero);
        Button btnOne = (Button)findViewById(R.id.btnOne);
        Button btnTwo = (Button)findViewById(R.id.btnTwo);
        Button btnThree = (Button)findViewById(R.id.btnThree);
        Button btnFour = (Button)findViewById(R.id.btnFour);
        Button btnFive = (Button)findViewById(R.id.btnFive);
        Button btnSix = (Button)findViewById(R.id.btnSix);
        Button btnSeven = (Button)findViewById(R.id.btnSeven);
        Button btnEight = (Button)findViewById(R.id.btnEight);
        Button btnNine = (Button)findViewById(R.id.btnNine);

        // Clear and Decimal Buttons
        Button btnClear = (Button)findViewById(R.id.btnClear);
        // Operator Buttons

        // CLICK LISTENERS - NUMBERS
        btnZero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnZero.getText().toString()));
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnOne.getText().toString()));
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnTwo.getText().toString()));
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnThree.getText().toString()));
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnFour.getText().toString()));
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnFive.getText().toString()));
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnSix.getText().toString()));
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnSeven.getText().toString()));
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnEight.getText().toString()));
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetInputNumbers(Integer.parseInt(btnNine.getText().toString()));
            }
        });

        // CLICK LISTENERS - CLEAR AND DECIMAL
        btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Clear();
            }
        });
    }

    public void GetInputNumbers(int number){
        TextView txtDisplayCalculation = (TextView)findViewById(R.id.txtDisplayCalculation);
        txtDisplayCalculation.setText(txtDisplayCalculation.getText().toString() + number);
    }

    public void Clear(){
        TextView txtDisplayCalculation = (TextView)findViewById(R.id.txtDisplayCalculation);
        txtDisplayCalculation.setText("");
    }

}