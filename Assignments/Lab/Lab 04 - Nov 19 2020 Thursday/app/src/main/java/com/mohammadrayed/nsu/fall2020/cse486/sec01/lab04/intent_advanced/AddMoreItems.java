package com.mohammadrayed.nsu.fall2020.cse486.sec01.lab04.intent_advanced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddMoreItems extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final String EXTRA_MSG= "com.mohammadrayed.nsu.fall2020.cse486.sec01.lab04.intent_advanced.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_more_items);


    }
    public void addRice (View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.putExtra(EXTRA_MSG, "Rice");
        startActivity(intent1);
    }
    public void addCheese (View view){
        Intent intent2 = new Intent(this, MainActivity.class);
        intent2.putExtra(EXTRA_MSG, "Cheese");
        startActivity(intent2);
    }
    public void addNoodles (View view){
        Intent intent3 = new Intent(this, MainActivity.class);
        intent3.putExtra(EXTRA_MSG, "Noodles");
        startActivity(intent3);
    }
    public void addParatha (View view){
        Intent intent4 = new Intent(this, MainActivity.class);
        intent4.putExtra(EXTRA_MSG, "Paratha");
        startActivity(intent4);
    }
}