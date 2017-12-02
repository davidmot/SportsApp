package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class SetTimeActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmTime, buttonAddTime, buttonRemoveTime;
    private NumberPicker numberPickerHour;
    private Spinner spinnerWeekday;
    private ListView listViewOverTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        buttonAddTime=(Button) findViewById(R.id.buttonAddTime);
        buttonRemoveTime=(Button) findViewById(R.id.buttonRemoveTime);

        numberPickerHour=(NumberPicker) findViewById(R.id.numberPickerHour);

        spinnerWeekday=(Spinner) findViewById(R.id.spinnerWeekday);

        listViewOverTime=(ListView)findViewById(R.id.listViewOverviewTime);

        buttonConfirmTime=(Button) findViewById(R.id.buttonConfirmTime);
        buttonConfirmTime.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intentgoToSettings=new Intent(this, OverviewActivity.class);
        this.startActivity(intentgoToSettings);
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
