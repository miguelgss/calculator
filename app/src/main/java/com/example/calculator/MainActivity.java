package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Number Buttons
        Button btnZero = findViewById(R.id.btnZero);
        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);
        Button btnThree = findViewById(R.id.btnThree);
        Button btnFour = findViewById(R.id.btnFour);
        Button btnFive = findViewById(R.id.btnFive);
        Button btnSix = findViewById(R.id.btnSix);
        Button btnSeven = findViewById(R.id.btnSeven);
        Button btnEight = findViewById(R.id.btnEight);
        Button btnNine = findViewById(R.id.btnNine);

        // Clear and Decimal Buttons
        Button btnClear = findViewById(R.id.btnClear);
        Button btnDecimal = findViewById(R.id.btnDecimal);

        // Operator Buttons
        Button btnSum = findViewById(R.id.btnSum);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnPotencia = findViewById(R.id.btnPotencia);
        Button btnPorcentagem = findViewById(R.id.btnPorcentagem);
        Button btnMod = findViewById(R.id.btnMod);
        Button btnRaiz = findViewById(R.id.btnRaiz);

        Button btnEquals = findViewById(R.id.btnEquals);

        // CLICK LISTENERS - NUMBERS
        btnZero.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnZero.getText().toString())));
        btnOne.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnOne.getText().toString())));
        btnTwo.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnTwo.getText().toString())));
        btnThree.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnThree.getText().toString())));
        btnFour.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnFour.getText().toString())));
        btnFive.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnFive.getText().toString())));
        btnSix.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnSix.getText().toString())));
        btnSeven.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnSeven.getText().toString())));
        btnEight.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnEight.getText().toString())));
        btnNine.setOnClickListener(v -> getInputNumbers(Integer.parseInt(btnNine.getText().toString())));

        // CLICK LISTENERS - CLEAR AND DECIMAL
        btnClear.setOnClickListener(v -> clear());
        btnDecimal.setOnClickListener(v -> getInputDecimal());

        // CLICK LISTENERS - OPERATORS
        btnSum.setOnClickListener(v -> getInputOperators(btnSum.getText().charAt(0)));
        btnSubtract.setOnClickListener(v -> getInputOperators(btnSubtract.getText().charAt(0)));
        btnMultiply.setOnClickListener(v -> getInputOperators(btnMultiply.getText().charAt(0)));
        btnDivide.setOnClickListener(v -> getInputOperators(btnDivide.getText().charAt(0)));

        btnPotencia.setOnClickListener(v -> getInputOperators('^'));
        btnPorcentagem.setOnClickListener(v -> getInputOperators(btnPorcentagem.getText().charAt(0)));
        btnMod.setOnClickListener(v -> getInputOperators(btnMod.getText().charAt(0)));
        btnRaiz.setOnClickListener(v -> getInputOperators(btnRaiz.getText().charAt(0)));

        btnEquals.setOnClickListener(v -> showResult());
    }

    private void getInputNumbers(int number){
        TextView txtDisplayCalculation = findViewById(R.id.txtDisplayCalculation);
        txtDisplayCalculation.setText(txtDisplayCalculation.getText().toString() + number);
    }

    private void getInputOperators(char operator){
        TextView txtDisplayCalculation = findViewById(R.id.txtDisplayCalculation);
        txtDisplayCalculation.setText(txtDisplayCalculation.getText().toString() + " " + operator + " ");
    }

    private void getInputDecimal(){
        TextView txtDisplayCalculation = findViewById(R.id.txtDisplayCalculation);
        txtDisplayCalculation.setText(txtDisplayCalculation.getText().toString() + ".");
    }

    private void showResult(){
        TextView txtDisplayCalculation = findViewById(R.id.txtDisplayCalculation);
        String[] txtCal = txtDisplayCalculation.getText().toString().split(" ");
        int contador = 0;
        double result = 0;

        try {
            if(txtCal[txtCal.length - 1] == "%"){}
            if(verifyCalculation(txtCal[txtCal.length - 1])){
                for(String e : txtCal ){
                    Log.i("Test: ",txtCal[contador]);
                    switch(e){
                        case "+":
                            result = Double.parseDouble(txtCal[contador - 1]) + Double.parseDouble(txtCal[contador + 1]);
                            txtCal[contador+1] = String.valueOf(result);
                            break;

                        case "-":
                            result = Double.parseDouble(txtCal[contador - 1]) - Double.parseDouble(txtCal[contador + 1]);
                            txtCal[contador+1] = String.valueOf(result);
                            break;

                        case "X":
                            result = Double.parseDouble(txtCal[contador - 1]) * Double.parseDouble(txtCal[contador + 1]);
                            txtCal[contador+1] = String.valueOf(result);
                            break;

                        case "÷":
                            result = Double.parseDouble(txtCal[contador - 1]) / Double.parseDouble(txtCal[contador + 1]);
                            txtCal[contador+1] = String.valueOf(result);
                            break;

                        case "^":
                            result = Math.pow(Double.parseDouble(txtCal[contador - 1]), Double.parseDouble(txtCal[contador + 1]));
                            txtCal[contador+1] = String.valueOf(result);
                            break;

                        case "M": // Mod, calculo para obter resto.
                            result = Double.parseDouble(txtCal[contador - 1]) % Double.parseDouble(txtCal[contador + 1]);
                            txtCal[contador+1] = String.valueOf(result);
                            break;

                        case "%":
                            result = Double.parseDouble(txtCal[contador - 1]) / 100;
                            if(txtCal.length - 1 > contador){
                                if(tryParseDouble(txtCal[contador+1])){
                                    throw new Exception("Cálculo inválido.");
                                }
                            }
                            txtCal[contador] = String.valueOf(result);
                            break;

                        case "√":
                            result = Math.sqrt(Double.parseDouble(txtCal[contador + 1]));
                            if(txtCal.length - 1 > contador){
                                if(tryParseDouble(txtCal[contador+1])){
                                    throw new Exception("Cálculo inválido.");
                                }
                            }
                            txtCal[contador + 1] = String.valueOf(result);
                            break;

                    }
                    contador++;
                }

                txtDisplayCalculation.setText(String.valueOf(result));
            } else {
                txtDisplayCalculation.setText("Error!!!");
                throw new Exception("Uma operação não pode terminar com um sinal de operação.");
            }
        } catch (Exception ex){
            // POP-UP
            Snackbar.make(findViewById(R.id.cstLayout),
                    ex.getMessage(),
                    Snackbar.LENGTH_LONG
            ).show();
        }
    }

    private void clear(){
        TextView txtDisplayCalculation = findViewById(R.id.txtDisplayCalculation);
        txtDisplayCalculation.setText("");
    }

    private boolean verifyCalculation(String input){
        if(Objects.equals(input, "%")){
            return true;
        }
        return tryParseDouble(input);
    }

    private boolean tryParseDouble(String input){
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

}