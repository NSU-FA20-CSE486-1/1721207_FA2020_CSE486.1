package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth fireA;
    EditText email, password;
    TextView existaccountbtn;
    Button loginbtn;
    ProgressBar login_progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email= findViewById(R.id.login_email_input);
        password= findViewById(R.id.login_password_input);
        existaccountbtn= findViewById(R.id.login_existingaccount);
        loginbtn= findViewById(R.id.login_button);

        fireA= FirebaseAuth.getInstance();
      //  fireEx= ((FirebaseAuthException) task.getException()).getErrorCode();

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

    }

    /*  Intent launchDashboard = new Intent(this, DashboardActivity.class);

    public void identify_credentials(View view) {
        String teststoredphone= "01765910669";
        String teststoredpassword= "mypassword1234";

        String phonenumber = view.findViewById(R.id.login_phone);
        String password = view.findViewById(R.id.login_password);

        if ( phonenumber == teststoredphone && password == teststoredpassword) {
            startActivity(launchDashboard);
        }
    } */