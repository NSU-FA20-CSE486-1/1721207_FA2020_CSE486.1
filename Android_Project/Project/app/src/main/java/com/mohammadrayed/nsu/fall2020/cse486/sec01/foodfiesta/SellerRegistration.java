package com.mohammadrayed.nsu.fall2020.cse486.sec01.foodfiesta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class SellerRegistration {




    public class SellerRegistration extends AppCompatActivity {

        TextInputLayout Fname,Lname,Email,Pass,cpass,mobileno,houseno;
        Button signup, Emaill, Phone;
        FirebaseAuth FAuth;
        DatabaseReference databaseReference;
        FirebaseDatabase firebaseDatabase;
        String fname,lname,emailid,password,confpassword,mobile,house;
        String role="Seller";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_seller_registration);

            Fname = (TextInputLayout)findViewById(R.id.Firstname);
            Lname = (TextInputLayout)findViewById(R.id.Lastname);
            Email = (TextInputLayout)findViewById(R.id.Email);
            Pass = (TextInputLayout)findViewById(R.id.Pwd);
            cpass = (TextInputLayout)findViewById(R.id.Cpass);
            mobileno = (TextInputLayout)findViewById(R.id.Mobileno);
            houseno = (TextInputLayout)findViewById(R.id.houseNo);

            signup = (Button)findViewById(R.id.Signup);
            Emaill = (Button)findViewById(R.id.email);
            Phone = (Button)findViewById(R.id.phone);

            databaseReference = firebaseDatabase.getInstance().getReference("Seller");
            FAuth = FirebaseAuth.getInstance();

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    fname = Fname.getEditText().getText().toString().trim();
                    lname = Lname.getEditText().getText().toString().trim();
                    emailid = Email.getEditText().getText().toString().trim();
                    mobile = mobileno.getEditText().getText().toString().trim();
                    password = Pass.getEditText().getText().toString().trim();
                    confpassword = cpass.getEditText().getText().toString().trim();
                    Area = area.getEditText().getText().toString().trim();
                    house = houseno.getEditText().getText().toString().trim();
                    Pincode = pincode.getEditText().getText().toString().trim();

                    if (isValid()){
                        final ProgressDialog mDialog = new ProgressDialog(SellerRegistration.this);
                        mDialog.setCancelable(false);
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.setMessage("Loading please wait......");
                        mDialog.show();

                        FAuth.createUserWithEmailAndPassword(emailid,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    String useridd = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                    databaseReference = FirebaseDatabase.getInstance().getReference("User").child(useridd);
                                    final HashMap<String , String> hashMap = new HashMap<>();
                                    hashMap.put("Role",role);
                                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            HashMap<String , String> hashMap1 = new HashMap<>();
                                            hashMap1.put("Phone No",mobile);
                                            hashMap1.put("Email Id",emailid);
                                            hashMap1.put("Password",password);
                                            firebaseDatabase.getInstance().getReference("Seller")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override

                                                        }
                                                    });

                                                }
                                            });

                                        }
                                    });
                                }
                            }
                        });
                    }
//
                }
            });