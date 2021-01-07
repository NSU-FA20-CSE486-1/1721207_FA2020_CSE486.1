package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Intent launchDashboard = new Intent(this, DashboardActivity.class);

    public void identify_credentials(View view) {
        String teststoredphone= "01765910669";
        String teststoredpassword= "mypassword1234";

        String phonenumber = view.findViewById(R.id.login_phone);
        String password = view.findViewById(R.id.login_password);

        if ( phonenumber == teststoredphone && password == teststoredpassword) {
            startActivity(DashboardActivity);
        }
    }
}