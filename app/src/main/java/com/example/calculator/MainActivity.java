package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView inputTextView, resultTextView;
    String textForNumbers = "", currentSign = "", LHS = "", RHS = "";
    double res = 0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputTextView = findViewById(R.id.textView_calculator);
        resultTextView = findViewById(R.id.textView_result);
    }

    public void onClickNumbers(View view) {
        textForNumbers = ((Button) view).getText().toString();
        inputTextView.append(textForNumbers);
        if (!currentSign.isEmpty()) {
            RHS = inputTextView.getText().toString();
            onCalculate(LHS, currentSign, RHS);
            isNumberDecimal(resultTextView);
        }
    }

    public void onClickSign(View view) {
        Button operator = ((Button) view);
        if (currentSign.isEmpty()) {
            LHS = inputTextView.getText().toString();
            inputTextView.setText("");
            currentSign = operator.getText().toString();
        } else {
            currentSign = operator.getText().toString();
            inputTextView.setText("");
            LHS = res + "";
        }

    }

    public void onClickMinus(View view) {
        inputTextView.append("-");
    }

    public void onClickEqual(View view) {
        isNumberDecimal(inputTextView);
        resultTextView.setText("");
    }

    private void isNumberDecimal(TextView txtView) {
        if (res % 1 == 0)
            txtView.setText(String.valueOf((int) res));

        else
            txtView.setText(String.valueOf(res));
    }

    public void onCalculate(String firstNum, String currentSign, String secondNum) {

        double _LHS = Double.parseDouble(firstNum);
        double _RHS = Double.parseDouble(secondNum);
        if (currentSign.equals("+"))
            res = _LHS + _RHS;
        else if (currentSign.equals("-"))
            res = _LHS - _RHS;
        else if (currentSign.equals("/"))
            res = _LHS / _RHS;
        else if (currentSign.equals("%"))
            res = _LHS % _RHS;
        else if (currentSign.equals("x"))
            res = _LHS * _RHS;
    }

    public void onClickAC(View view) {
        currentSign = "";
        textForNumbers = "";
        inputTextView.setText("");
        resultTextView.setText("");

    }
}
