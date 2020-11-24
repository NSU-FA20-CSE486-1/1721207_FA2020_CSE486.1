package com.mohammadrayed.nsu.fall2020.cse486.sec01.lab03.intentactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String register_number_display= intent.getStringExtra(MainActivity.extraMsg);
        TextView confirm_registered_phonedisplay= findViewById(R.id.registered_phone);
        confirm_registered_phonedisplay.setText(register_number_display);

    }
}