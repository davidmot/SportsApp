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

public class CSportActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmCSport;
    private RadioButton radioButtonGolf, radioButtonTennis, radioButtonChess;
    private EditText editTextState, editTextCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csport);

        radioButtonGolf=(RadioButton) findViewById(R.id.radioButtonGolf);
        radioButtonChess=(RadioButton) findViewById(R.id.radioButtonChess);
        radioButtonTennis=(RadioButton)findViewById(R.id.radioButtonTennis);

        editTextCity = (EditText)findViewById(R.id.editTextCity);
        editTextState=(EditText) findViewById(R.id.editTextState);

        buttonConfirmCSport=(Button) findViewById(R.id.buttonConfirmCSport);

        buttonConfirmCSport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intentgoToTime = new Intent(this, SetTimeActivity.class);
        this.startActivity(intentgoToTime);

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
            Intent intentMenuAddInventory = new Intent (this, SettingsActivity.class);
            this.startActivity(intentMenuAddInventory);}

        else if (item.getItemId() == R.id.logout){
            Intent intentMenuInventoryCheck = new Intent (this, MainLogIn.class);
            this.startActivity(intentMenuInventoryCheck);}

        return super.onOptionsItemSelected(item);
    }

}
