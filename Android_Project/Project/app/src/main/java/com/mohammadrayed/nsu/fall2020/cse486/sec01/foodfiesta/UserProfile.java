package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
    }

    public void editProfile(View view) {
      //  public static int EDIT_SUCCESSFUL = 1;

       // Intent launchEditProfileWindow = new Intent(this, EditProfile.class);
        //startActivityForResult(launchEditProfileWindow, EDIT_SUCCESSFUL);
    }
}