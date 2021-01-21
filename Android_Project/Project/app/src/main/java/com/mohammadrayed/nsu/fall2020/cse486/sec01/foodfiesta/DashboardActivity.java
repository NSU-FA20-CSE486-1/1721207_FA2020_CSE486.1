package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.dashboard_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] menu= {"Mutton Biryani", "Pizza Pepperonni", "Beef Korma", "Egg Noodles", "Plain Rice", "Chicken Tikka", "Beef Kebab", "Grilled Chicken", "Morog Pulao"};
        recyclerView.setAdapter(new MenuListAdapter(menu));

    }
}