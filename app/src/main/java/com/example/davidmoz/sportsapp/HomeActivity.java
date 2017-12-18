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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class HomeActivity extends Activity implements View.OnClickListener {

    private Button buttonChangeSettings;
    private TextView textViewHello, textViewLocation1, textViewSport1, textViewTime1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        buttonChangeSettings=(Button)findViewById(R.id.buttonChangeSettings);
        buttonChangeSettings.setOnClickListener(this);

        textViewLocation1=(TextView)findViewById(R.id.textViewLocation1);
        textViewHello=(TextView)findViewById(R.id.textViewHello);
        textViewSport1=(TextView)findViewById(R.id.textViewSport1);
        textViewTime1=(TextView)findViewById(R.id.textViewTime1);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userProfile = user.getUid().toString();

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userRef = db.getReference().child(userProfile);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User userData = dataSnapshot.getValue(User.class);
                textViewHello.setText("Hello  "+userData.userFirstName+" !");
                textViewSport1.setText(userData.userSport);
                textViewLocation1.setText(userData.userCity+" , "+userData.userState);
                textViewTime1.setText(userData.userStartTime+":00 to "+userData.userEndTime);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






    }

    public void goToMenu() {
        Intent intentgoMenu = new Intent(this, OverviewActivity.class);
        this.startActivity(intentgoMenu);
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

    @Override
    public void onClick(View v) {

        if (v==buttonChangeSettings) {
            Intent goToSsettings = new Intent(this, CSportActivity.class);
            this.startActivity(goToSsettings);
        }

    }
}

