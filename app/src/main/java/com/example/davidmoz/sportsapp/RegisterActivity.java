package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends Activity implements View.OnClickListener {
    private Button buttonCompleteRegister;
    private EditText editTextFirstName, editTextLastName, editTextBirthdate, editTextEmail, editTextPassword1, editTextPassword2;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextFirstName=(EditText) findViewById(R.id.editTextFirstname);
        editTextLastName=(EditText) findViewById(R.id.editTextLastName);
        editTextBirthdate=(EditText) findViewById((R.id.editTextBirthDate));
        editTextEmail=(EditText) findViewById(R.id.editTextEmail);
        editTextPassword1=(EditText) findViewById(R.id.editTextPassword1);
        editTextPassword2=(EditText) findViewById(R.id.editTextPassword2);

        buttonCompleteRegister=(Button)findViewById(R.id.buttonCompleteRegister);
        buttonCompleteRegister.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d("TAG", "onAuthStateChanged:signed_in" + user.getUid());
                } else {
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                }
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onClick(View v) {
        String email = editTextEmail.getText().toString();
        String password1 = editTextPassword1.getText().toString();
        String password2 = editTextPassword2.getText().toString();
        String firstname = editTextFirstName.getText().toString();
        String lastname = editTextLastName.getText().toString();


            if (email.equals("") || password1.equals("")|| password2.equals("") || firstname.equals("") || lastname.equals("")|| password1.equals("")) {
                Toast.makeText(RegisterActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            } else if (password1.equals(password2) ) {
                createAccount(email, password1);
            } else { Toast.makeText(RegisterActivity.this, "Passwords are not coherent", Toast.LENGTH_SHORT).show();}

    }


    public void createAccount(String email, String password1) {
        mAuth.createUserWithEmailAndPassword(email, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful())  {
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }  else{
                            Toast.makeText(RegisterActivity.this, "Regristaiton Succesful", Toast.LENGTH_SHORT).show();
                            goToCSport();
                        }
                    }
                });


    }
    public void goToCSport() {
        Intent intentgoCSport = new Intent(this, CSportActivity.class);
        this.startActivity(intentgoCSport);
    }


}
