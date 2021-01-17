package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth fireA;
    EditText email, password;
    TextView existaccountbtn;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email= findViewById(R.id.login_email_input);
        password= findViewById(R.id.login_password_input);
        existaccountbtn= findViewById(R.id.login_existingaccount);
        loginbtn= findViewById(R.id.login_button);

        fireA= FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email= email.getText().toString().trim();
                String Password= password.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is empty");
                }
                if(TextUtils.isEmpty(password)){
                    password.setError("Password is empty");
                }
                if(password.length() < 6){
                    password.setError("Password is less than 8 characters");
                }
                fireA.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        }
                    }
                })
            }
        });

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
}