package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Set;

public class CSportActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmCSport;
    private RadioButton radioButtonGolf, radioButtonTennis, radioButtonChess;
    private EditText editTextState, editTextCity;
    String userSport ="";
    Double time= null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csport);

        radioButtonGolf=(RadioButton) findViewById(R.id.radioButtonGolf);
        radioButtonGolf.setOnClickListener(this);

        radioButtonChess=(RadioButton) findViewById(R.id.radioButtonChess);
        radioButtonChess.setOnClickListener(this);

        radioButtonTennis=(RadioButton)findViewById(R.id.radioButtonTennis);
        radioButtonTennis.setOnClickListener(this);

        editTextCity = (EditText)findViewById(R.id.editTextCity);
        editTextState=(EditText) findViewById(R.id.editTextState);

        buttonConfirmCSport=(Button) findViewById(R.id.buttonConfirmCSport);
        buttonConfirmCSport.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        Intent intentgoCSport = getIntent();
        final String email = intentgoCSport.getStringExtra("email");


        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userProfile = user.getUid().toString();

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userRef = db.getReference().child(userProfile);


        final String userCity = editTextCity.getText().toString();
        final String userState = editTextState.getText().toString();


        if (v == radioButtonChess) {
            radioButtonTennis.setChecked(false);
            radioButtonGolf.setChecked(false);
            radioButtonChess.setChecked(true);
            userSport = "Chess";


        } else if (v == radioButtonGolf) {
            radioButtonTennis.setChecked(false);
            radioButtonGolf.setChecked(true);
            radioButtonChess.setChecked(false);
            userSport = "Golf";

        } else if (v == radioButtonTennis) {
            radioButtonTennis.setChecked(true);
            radioButtonGolf.setChecked(false);
            radioButtonChess.setChecked(false);
            userSport = "Tennis";

        } else if (v == buttonConfirmCSport) {
            if (userCity.equals("") || userState.equals("") || userSport.equals("")) {
                Toast.makeText(CSportActivity.this, "Please Fill Out All Fields", Toast.LENGTH_SHORT).show();
          } else {
                userRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.v("no", dataSnapshot.toString());
                        userRef.child("userSport").setValue(userSport);
                        userRef.child("userCity").setValue(userCity);
                        userRef.child("userState").setValue(userState);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                Intent intentParty = new Intent(this, SetTimeActivity.class);
                this.startActivity(intentParty);

            }


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuHome = getMenuInflater();
        menuHome.inflate(R.menu.mainmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Intent intentMenuHome = new Intent(this, HomeActivity.class);
            this.startActivity(intentMenuHome);}

        else if (item.getItemId() == R.id.settings){
            Intent intentMenuAddInventory = new Intent (this, CSportActivity.class);
            this.startActivity(intentMenuAddInventory);}

        else if (item.getItemId() == R.id.logout){
            Intent intentMenuInventoryCheck = new Intent (this, MainLogIn.class);
            this.startActivity(intentMenuInventoryCheck);}

        return super.onOptionsItemSelected(item);
    }

}
