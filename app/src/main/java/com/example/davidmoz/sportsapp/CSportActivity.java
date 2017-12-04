package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CSportActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmCSport;
    private RadioButton radioButtonGolf, radioButtonTennis, radioButtonChess;
    private EditText editTextState, editTextCity;
    private TextView userSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csport);

        userSport=(TextView) findViewById(R.id.textViewSelectedSport);

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

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userRef = db.getReference("Users");


        if (v == radioButtonChess) {
            radioButtonTennis.setChecked(false);
            radioButtonGolf.setChecked(false);
            radioButtonChess.setChecked(true);
            userSport.setText("Chess");

        } else if (v == radioButtonGolf) {
            radioButtonTennis.setChecked(false);
            radioButtonGolf.setChecked(true);
            radioButtonChess.setChecked(false);
            userSport.setText("Golf");

        } else if (v == radioButtonTennis) {
            radioButtonTennis.setChecked(true);
            radioButtonGolf.setChecked(false);
            radioButtonChess.setChecked(false);
            userSport.setText("Tennis");

        } else if (v == buttonConfirmCSport) {
            if (editTextState.equals("") || editTextCity.equals("") || userSport.equals(""))
            { Toast.makeText(CSportActivity.this, "Please Fill out all Fields", Toast.LENGTH_SHORT).show();
            } else {
                Intent intentgoToTime = new Intent(this, SetTimeActivity.class);
                this.startActivity(intentgoToTime);
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
            Intent intentMenuAddInventory = new Intent (this, OverviewActivity.class);
            this.startActivity(intentMenuAddInventory);}

        else if (item.getItemId() == R.id.logout){
            Intent intentMenuInventoryCheck = new Intent (this, MainLogIn.class);
            this.startActivity(intentMenuInventoryCheck);}

        return super.onOptionsItemSelected(item);
    }

}
