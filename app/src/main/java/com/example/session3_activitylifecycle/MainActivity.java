package com.example.session3_activitylifecycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("lifecycle","creat");
        name=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("btuuoncloxked","thr btdsfjhg");
                String username=name.getText().toString();
                String userpassword=password.getText().toString();
                showData(username,userpassword);
            }
        });


    }
public void showData(String user,String pass){
        if(user==""||pass==""){
            new AlertDialog.Builder(this)
                    .setTitle("data")
                    .setMessage("Pleas Enter Any value to show")
                    .create()
                    .show();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("data")
                    .setMessage("username is "+user+"\n password is "+pass)
                    .create()
                    .show();
        }

}
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("lifecycle","start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("lifecycle","resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("lifecycle","pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("lifecycle","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("lifecycle","destroy");
    }
}