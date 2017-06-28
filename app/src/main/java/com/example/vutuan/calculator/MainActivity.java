package com.example.vutuan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtResult;
    private String operation="", numberA="", numberB="", result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtResult= (EditText) findViewById(R.id.edtResult);

        int arrayButton[]={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,
                R.id.btnDelete,R.id.btnAdd,R.id.btnSub,R.id.btnMultiply,R.id.btnDivide,R.id.btnDot,R.id.btnEqual};

        for (int i=0;i<arrayButton.length;i++){
            View view=(View) findViewById(arrayButton[i]);
            view.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                operation="+";
                edtResult.setText(operation);
                break;
            case R.id.btnSub:
                operation="-";
                edtResult.setText(operation);
                break;
            case R.id.btnMultiply:
                operation="*";
                edtResult.setText(operation);
                break;
            case R.id.btnDivide:
                operation="/";
                edtResult.setText(operation);
                break;
            case R.id.btnDot:
                operation=".";
                numberA+=operation;
                Log.d("numberA",numberA);
                edtResult.setText(numberA);
                break;
            case R.id.btnEqual:
                operation="=";
                break;
            default:
                String temp=((Button) v).getText().toString();
                numberA=edtResult.getText().toString();
                if (numberA=="+"||numberA=="-"||numberA=="*"||numberA=="/"){
                    edtResult.setText(operation);
                    Log.d("tag","true");
                }

                Log.d("res: ",numberA);
                numberA+=temp;
                Log.d("numberA",numberA);
                edtResult.setText(numberA);


        }
    }
}
