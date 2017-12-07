package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SetTimeActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmTime;
    private NumberPicker numberPickerHour;
    private Spinner spinnerWeekday;
    String weekday [] = {"Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    String record = "";
    String userSport;
    String userCity;
    String userState;


    private ListView listViewOverTime;


    ArrayAdapter<String> adapter;

    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        NumberPicker numberPickerHour =(NumberPicker)findViewById(R.id.numberPickerHour);
        numberPickerHour.setMinValue(0);
        numberPickerHour.setMaxValue(23);
        numberPickerHour.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            }
        });

        Intent intentgoMenu = getIntent();
        final String email2= intentgoMenu.getStringExtra("email");

        Intent intentgoCSport = getIntent();
        final String email1 = intentgoCSport.getStringExtra("email");

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userRef = db.getReference("Users");

        if (email1.equals("")) {
            userRef.orderByChild("userEmail").equalTo(email2).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    userRef.orderByChild("userEmail").equalTo(email2).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            User userfound = new User();
                            userSport= userfound.userSport;
                            userCity = userfound.userCity;
                            userState= userfound.userState;
                        }
                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        }
                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {
                        }
                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        } else {
            userRef.orderByChild("userEmail").equalTo(email1).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    userRef.orderByChild("userEmail").equalTo(email1).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            User userfound = new User();

                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }






        buttonConfirmTime=(Button) findViewById(R.id.buttonConfirmTime);
        buttonConfirmTime.setOnClickListener(this);


        spinnerWeekday=(Spinner) findViewById(R.id.spinnerWeekday);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,weekday);
        spinnerWeekday.setAdapter(adapter);



        spinnerWeekday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)

                {
                    case 0:
                        record = "Monday";
                        break;
                    case 1:
                        record = "Tuesday";
                        break;
                    case 2:
                        record = "Wednesday";
                        break;
                    case 3:
                        record = "Thursday";
                        break;
                    case 4:
                        record="Friday";
                        break;
                    case 5:
                    record="Saturday";
                    break;
                    case 6:
                        record="Sunday";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuHome = getMenuInflater();
        menuHome.inflate(R.menu.mainmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {


        if (v==spinnerWeekday) {
            int position = spinnerWeekday.getSelectedItemPosition();
            String selectedText = (String) spinnerWeekday.getSelectedItem();}


        else if (v == buttonConfirmTime) {

            Intent intentgoToSettings = new Intent(this, OverviewActivity.class);
            this.startActivity(intentgoToSettings);
        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.home){
        Intent intentMenuHome=new Intent(this,HomeActivity.class);
        this.startActivity(intentMenuHome);}

        else if(item.getItemId()==R.id.settings){
        Intent intentMenuAddInventory=new Intent(this,SettingsActivity.class);
        this.startActivity(intentMenuAddInventory);}

        else if(item.getItemId()==R.id.logout){
        Intent intentMenuInventoryCheck=new Intent(this,MainLogIn.class);
        this.startActivity(intentMenuInventoryCheck);}

        return super.onOptionsItemSelected(item);




}
}
