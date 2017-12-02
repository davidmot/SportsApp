package com.example.davidmoz.sportsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonChangeSettings, buttonCancelPending, buttonConfirmPendings, buttonCancelConfirmMatches, buttonConfirmMatches, butteonCancelUpcoming;
    private ListView listViewUpcoming, listViewConfirm, listViewPending;
    private TextView textViewHello, textViewHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonChangeSettings=(Button) findViewById(R.id.buttonChangeSettings);

        buttonCancelPending=(Button)findViewById(R.id.buttonCancelPending);

        buttonConfirmPendings=(Button)findViewById(R.id.buttonCancelConfirmMatches);

        buttonCancelConfirmMatches=(Button)findViewById(R.id.buttonCancelConfirmMatches);

        buttonConfirmMatches=(Button) findViewById(R.id.buttonConfirmMatches);

        butteonCancelUpcoming=(Button)findViewById(R.id.buttonCancelUpcoming);

        listViewUpcoming=(ListView)findViewById(R.id.listViewUpcoming);
        listViewConfirm=(ListView)findViewById(R.id.listViewConfirm);
        listViewPending=(ListView) findViewById(R.id.listViewPending);

        textViewHello=(TextView)findViewById(R.id.textViewHello);

    }

    @Override
    public void onClick(View v) {

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
