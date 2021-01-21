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

    TextView email, full_name, password, address, existing_account, phone;
    ProgressBar prg_bar;
    Button register_button;
    FirebaseAuth fireA;

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

        email= findViewById(R.id.register_email);
        phone= findViewById(R.id.register_phone);
        password= findViewById(R.id.register_password);
        full_name= findViewById(R.id.register_full_name);
        register_button = findViewById(R.id.register_button);
        existing_account = findViewById(R.id.login_existingaccount);
        address = findViewById(R.id.register_address);

        fireA= FirebaseAuth.getInstance();
        //  fireEx= ((FirebaseAuthException) task.getException()).getErrorCode();

       existing_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email= email.getText().toString().trim();
                String Password= password.getText().toString().trim();
                String Full_name= full_name.getText().toString().trim();
                String Address= address.getText().toString().trim();
                String Phone= phone.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is empty");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    password.setError("Password is empty");
                    return;
                }

                if(TextUtils.isEmpty(Full_name)){
                    email.setError("Full Name is empty");
                    return;
                }
                if(TextUtils.isEmpty(Address)){
                    password.setError("Address is empty");
                    return;
                } if(TextUtils.isEmpty(Phone)){
                    password.setError("Phone number is empty");
                    return;
                }
                if(Phone.length() < 11){
                    password.setError("Number is invalid");
                    password.setText("");
                    return;
                }
                if(Password.length() < 8){
                    password.setError("Password is less than 8 characters");
                    password.setText("");
                    return;
                }

                //_progressbar.setVisibility(View.VISIBLE);

                fireA.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        }
                        else {
                            String errorMsg = ((FirebaseAuthException) task.getException()).getErrorCode();

                            switch (errorMsg) {

                                case "ERROR_INVALID_EMAIL":
                                    Toast.makeText(RegisterUser.this, "Invalid Email.", Toast.LENGTH_LONG).show();
                                    email.setError("The email is incorrect.");
                                    break;

                                case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                                    Toast.makeText(RegisterUser.this, "An account already exists with that email", Toast.LENGTH_LONG).show();
                                    break;

                            }
                        }

                    }
                });
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}