package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends Activity implements View.OnClickListener {
    private Button buttonCompleteRegister;
    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword1, editTextPassword2, Birthday;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;


    private SimpleDateFormat dateFormatter;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intentgoCSport = getIntent();
        final String email = intentgoCSport.getStringExtra("email");


        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);


        findViewsById();

        setDateTimeField();

        editTextFirstName = (EditText) findViewById(R.id.editTextFirstname);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);


        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextEmail.setText(email);
        editTextPassword1 = (EditText) findViewById(R.id.editTextPassword1);
        editTextPassword2 = (EditText) findViewById(R.id.editTextPassword2);

        buttonCompleteRegister = (Button) findViewById(R.id.buttonCompleteRegister);
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

    private void findViewsById() {
        Birthday = (EditText) findViewById(R.id.Birthday);
        Birthday.setInputType(InputType.TYPE_NULL);
        Birthday.requestFocus();

    }

    private void setDateTimeField() {
        Birthday.setOnClickListener(this);


        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Birthday.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
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
        String userFirstName = editTextFirstName.getText().toString();
        String userLastName = editTextLastName.getText().toString();
        String userBirthday = Birthday.getText().toString();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userProfile = user.getUid().toString();


            if(v== Birthday) {
                fromDatePickerDialog.show();
            } else if (email.equals("") || password1.equals("")|| password2.equals("") || userFirstName.equals("") || userLastName.equals("")|| password1.equals("")) {
                Toast.makeText(RegisterActivity.this, userProfile, Toast.LENGTH_SHORT).show();
            } else if (password1.equals(password2) ) {
                createAccount(email, password1);

            } else { Toast.makeText(RegisterActivity.this, "Passwords are not coherent", Toast.LENGTH_SHORT).show();}

    }

    public void createAccount(final String email, final String password1) {
        mAuth.createUserWithEmailAndPassword(email, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful())  {
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }  else{
                            signIn(email, password1);
                        }
                    }
                });
    }

    public void signIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String userProfile = user.getUid().toString();

                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference userRef = db.getReference().child(userProfile);

                    String email = editTextEmail.getText().toString();
                    String userFirstName = editTextFirstName.getText().toString();
                    String userLastName = editTextLastName.getText().toString();


                    User myUser = new User(userFirstName, userLastName, email, "Test", "Test", "Test", "Test", "Test", "Test");
                    userRef.setValue(myUser);
                    Toast.makeText(RegisterActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    goToCSport();
                    ;
                }
            }
        });
    }


    public void goToCSport() {
        String email = editTextEmail.getText().toString();
        String password1 = editTextPassword1.getText().toString();
        String password2 = editTextPassword2.getText().toString();
        String userFirstName = editTextFirstName.getText().toString();
        String userLastName = editTextLastName.getText().toString();
        String userBirthday = Birthday.getText().toString();

        Intent intentgoCSport = new Intent(this, CSportActivity.class);
        intentgoCSport.putExtra("email",email);
        intentgoCSport.putExtra("userFirstName", userFirstName );
        intentgoCSport.putExtra("userLastName", userLastName);
        intentgoCSport.putExtra("userBirthday", userBirthday);

        this.startActivity(intentgoCSport);

    }

}
