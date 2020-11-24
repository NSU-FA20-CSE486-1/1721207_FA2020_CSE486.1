package com.mohammadrayed.nsu.fall2020.cse486.sec01.lab03.intentactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText numberText;
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final String extraMsg= "com.mohammadrayed.nsu.fall2020.cse4846.sec01.lab03.intentactivity.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberText= findViewById(R.id.user_phone);

    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Okay!");
        Intent intent = new Intent(this, SecondActivity.class);
        String display_message= numberText.getText().toString();
        intent.putExtra(extraMsg, display_message);
        startActivity(intent);
    }

}