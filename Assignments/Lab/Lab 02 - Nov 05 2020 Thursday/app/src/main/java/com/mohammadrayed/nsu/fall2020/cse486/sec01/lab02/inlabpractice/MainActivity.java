package com.mohammadrayed.nsu.fall2020.cse486.sec01.lab02.inlabpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.editTextTextEmailAddress);
        password=(EditText) findViewById(R.id.editTextTextPassword);

    }


    public void showToast(View view) {
        Toast toast_success=Toast.makeText(this, R.string.toast_msg_success, Toast.LENGTH_SHORT );
        Toast toast_unsuccess=Toast.makeText(this, R.string.toast_msg_unsuccess, Toast.LENGTH_SHORT);
        if(username.getText().toString().equals("lab02@gmail.com") && password.getText().toString().equals("password")) {
            toast_success.show();
        }
        else{
            toast_unsuccess.show();
        }
    }
}