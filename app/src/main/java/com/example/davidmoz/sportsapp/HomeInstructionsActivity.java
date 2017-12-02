package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeInstructionsActivity extends Activity implements View.OnClickListener {
    private TextView textViewHelloInstructions;
    private Button buttonUnderstand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_instructions);

        textViewHelloInstructions=(TextView)findViewById(R.id.textViewHello);
        buttonUnderstand=(Button)findViewById(R.id.buttonUnderstand);

    }

    @Override
    public void onClick(View v) {
        Intent gobackToHome = new Intent(this, HomeActivity.class);
        this.startActivity(gobackToHome);
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
