package com.example.session3_activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class caluclator extends AppCompatActivity {
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caluclator);
        result=findViewById(R.id.result_tv);

    }
    String lhs="";
    String operator="";
    String rhs="";
    public void digits(View view) {
        Button digit=(Button)view;
        String presseddigit =digit.getText().toString();

        if (presseddigit.equals(".")&&result.getText().toString().contains(".")){
            Toast.makeText(caluclator.this,"You Can't add alot of ",Toast.LENGTH_SHORT).show();
            return;
        }
            result.append(presseddigit);

    }

    public void operators(View view) {
        Button operatorbtn=(Button)view;

        if(lhs.equals("")){
            lhs =result.getText().toString();
        }else{
            rhs=result.getText().toString();
            lhs=caluclate(lhs,operator,rhs);
        }
        result.setText("");
        operator=operatorbtn.getText().toString();

    }

    private String caluclate(String lhs, String operator, String rhs) {
        double lhsnumber=Double.parseDouble(lhs);
        double rhsnumber=Double.parseDouble(rhs);
        double res=0.0;
        if (operator.equals("*")){
            res=lhsnumber*rhsnumber;
        }else if (operator.equals("+")){
            res=lhsnumber+rhsnumber;
        }
        else if (operator.equals("-")){
            res=lhsnumber-rhsnumber;
        }
        else if (operator.equals("/")){
        if(rhsnumber==0){
            Toast.makeText(caluclator.this,"You Can't Divition over Zero",Toast.LENGTH_SHORT).show();
        }else
            res=lhsnumber/rhsnumber;
        }
        return res+"";
    }

    public void equalClick(View view) {
        if (operator.equals("")&&lhs.equals("")){
            return;
        }String rhs=result.getText().toString();
       String res= caluclate(lhs,operator,rhs);
       result.setText(res);
       lhs=operator="" ;
    }
}