package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView email, full_name, password, address;
    ProgressBar prg_bar;
    Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        email= findViewById(R.id.register_phone);
        password= findViewById(R.id.register_password);
        full_name= findViewById(R.id.register_full_name);
        register_button = findViewById(R.id.register_button);

        fireA= FirebaseAuth.getInstance();
        //  fireEx= ((FirebaseAuthException) task.getException()).getErrorCode();

        existaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterUser.class));
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email= email.getText().toString().trim();
                String Password= password.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is empty");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    password.setError("Password is empty");
                    return;
                }
                if(Password.length() < 8){
                    password.setError("Password is less than 8 characters");
                    password.setText("");
                    return;
                }

                login_progressbar.setVisibility(View.VISIBLE);

                fireA.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        }
                        else {
                            String errorMsg = ((FirebaseAuthException) task.getException()).getErrorCode();

                            switch (errorMsg) {

                                case "ERROR_INVALID_CREDENTIAL":
                                    Toast.makeText(MainActivity.this, "Invalid Credentials. Try again.", Toast.LENGTH_LONG).show();
                                    break;

                                case "ERROR_INVALID_EMAIL":
                                    Toast.makeText(MainActivity.this, "Invalid Email.", Toast.LENGTH_LONG).show();
                                    email.setError("The email is incorrect.");
                                    break;

                                case "ERROR_WRONG_PASSWORD":
                                    Toast.makeText(MainActivity.this, "The password is invalid or the user does not have a password.", Toast.LENGTH_LONG).show();
                                    password.setError("password is incorrect ");
                                    password.setText("");
                                    break;

                                case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                                    Toast.makeText(MainActivity.this, "An account already exists with that email", Toast.LENGTH_LONG).show();
                                    break;

                                case "ERROR_USER_NOT_FOUND":
                                    Toast.makeText(MainActivity.this, "No user with provided credentials found", Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }

                    }
                });
            }

        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}