package com.example.vutuan.calculator;

import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtResult;
    private String operation="", numberA="", numberB="", result="";
    private float elementA, elementB, elementResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtResult= (EditText) findViewById(R.id.edtResult);
        edtResult.setText("0");

        int arrayButton[]={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,
                R.id.btnDelete,R.id.btnAdd,R.id.btnSub,R.id.btnMultiply,R.id.btnDivide,R.id.btnDot,R.id.btnEqual};

        for (int i=0;i<arrayButton.length;i++){
            View view=(View) findViewById(arrayButton[i]);
            view.setOnClickListener(this);
        }

    }

    private void getElementA(){
        numberA=edtResult.getText().toString();
        edtResult.setText("0");
        result="";
    }

    private void parseFloat(){
        elementA=Float.parseFloat(numberA);
        elementB=Float.parseFloat(numberB);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                operation="+";
                getElementA();
                break;
            case R.id.btnSub:
                operation="-";
                getElementA();
                break;
            case R.id.btnMultiply:
                operation="*";
                getElementA();
                break;
            case R.id.btnDivide:
                operation="/";
                getElementA();
                break;
            case R.id.btnDot:
                result+=".";
                edtResult.setText(result);
                break;
            case R.id.btnDelete:
                edtResult.setText("0");
                numberA="";
                numberB="";
                result="";
                break;
            case R.id.btnEqual:
                numberB=edtResult.getText().toString();
                Log.d("A",numberA);
                Log.d("operation",operation);
                Log.d("B",numberB);
                parseFloat();
                if (operation=="+"){
                    elementResult=elementA+elementB;
                    edtResult.setText(String.valueOf(elementResult));
                    numberA=String.valueOf(elementResult);
                    Log.d("Result",elementResult+"");
                } else if (operation=="-"){
                    elementResult=elementA-elementB;
                    edtResult.setText(String.valueOf(elementResult));
                    numberA=String.valueOf(elementResult);
                    Log.d("Result",elementResult+"");
                } else if (operation=="*"){
                    elementResult=elementA*elementB;
                    edtResult.setText(String.valueOf(elementResult));
                    numberA=String.valueOf(elementResult);
                    Log.d("Result",elementResult+"");
                } else if (operation=="/"){
                    elementResult=elementA/elementB;
                    edtResult.setText(String.valueOf(elementResult));
                    numberA=String.valueOf(elementResult);
                    Log.d("Result",elementResult+"");
                }

                break;
            default:
                String temp=((Button) v).getText().toString();
                result=edtResult.getText().toString();
                if (result.charAt(0)=='0'){
                    result="";
                    
                }
                result+=temp;
                edtResult.setText(result);

        }
    }
}
