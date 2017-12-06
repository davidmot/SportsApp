package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class OverviewActivity extends Activity implements View.OnClickListener {


    private Button buttonConfirmOverview, buttonChangeLocation, buttonChangeSports, buttonChangeTime;
    private TextView textViewSelectedSport, textViewRequiredTime, textViewCityName, textViewStateName;
    private ListView listViewChoosenTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        textViewSelectedSport=(TextView) findViewById(R.id.textViewSelectedSport);
        textViewRequiredTime=(TextView) findViewById(R.id.textViewRequiredTime);
        textViewCityName=(TextView) findViewById(R.id.textViewCityName);
        textViewStateName=(TextView) findViewById(R.id.textViewStateName);

        listViewChoosenTime=(ListView)findViewById(R.id.listViewChoosenTime);


        buttonChangeSports=(Button) findViewById(R.id.buttonChangeSports);
        buttonChangeSports.setOnClickListener(this);

        buttonChangeLocation=(Button)findViewById(R.id.buttonChangeLocation);
        buttonChangeLocation.setOnClickListener(this);

        buttonChangeTime=(Button) findViewById(R.id.buttonChangeTime);
        buttonChangeTime.setOnClickListener(this);

        buttonConfirmOverview = (Button) findViewById(R.id.buttonConfirmOverview);
        buttonConfirmOverview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonChangeTime) {
            Intent intentGotoTimesetting = new Intent(this, SetTimeActivity.class);
            this.startActivity(intentGotoTimesetting);
        }
        else if (v == buttonChangeSports){
            Intent intentGotosports = new Intent(this,CSportActivity.class);
            this.startActivity(intentGotosports);
        }
        else if (v == buttonChangeLocation){
            Intent intentGotolocations = new Intent(this,CSportActivity.class);
            this.startActivity(intentGotolocations);
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
            Intent intentMenuHome = new Intent(this, CSportActivity.class);
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
