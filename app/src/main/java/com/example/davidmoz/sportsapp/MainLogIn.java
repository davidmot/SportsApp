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

public class MainLogIn extends Activity implements View.OnClickListener {
    private Button buttonLogin, buttonRegister;
    private EditText editTextEmail, editTextPassword;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log_in);

        buttonLogin = (Button) findViewById(R.id.buttonLogIn);
        buttonLogin.setOnClickListener(this);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

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
        String password = editTextPassword.getText().toString();

        if (v.getId() == buttonLogin.getId()) {
            if (email.equals("") || password.equals("")) {
                Toast.makeText(MainLogIn.this,"Please Fill out Email and Password", Toast.LENGTH_SHORT).show();
            } else {signIn(email, password);}

        } else if (v.getId() == buttonRegister.getId()) {
            Intent intentRegistrate = new Intent(this, RegisterActivity.class);
            this.startActivity(intentRegistrate);
        }

    }

    public void signIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(MainLogIn.this, "Login Failed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainLogIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    goToMenu();
                }
            }
        });
    }

    public void goToMenu() {
        Intent intentgoMenu = new Intent(this, OverviewActivity.class);
        this.startActivity(intentgoMenu);
    }
}
