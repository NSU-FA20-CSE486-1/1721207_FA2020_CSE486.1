package com.mohammadrayed.nsu.fall2020.cse486.sec01.lab04.intent_advanced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String item_name = intent.getStringExtra(AddMoreItems.EXTRA_MSG);
        if (item_name == "@string/rice") {
            TextView g5 = findViewById(R.id.grocery_5);
            g5.setText(item_name);
        } else if (item_name == "@string/cheese") {
            TextView g2 = findViewById(R.id.grocery_2);
            g2.setText(item_name);
        } else if (item_name == "@string/noodles") {
            TextView g3 = findViewById(R.id.grocery_3);
            g3.setText(item_name);
        } else {
            TextView g4 = findViewById(R.id.grocery_4);
            g4.setText(item_name);
        }
    }
    public void launchAddItemActivity(View view){
        Intent intent10 = new Intent(this, AddMoreItems.class);
        startActivity(intent10);
    }
}