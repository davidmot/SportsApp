package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class timeoverview extends Activity implements Button.OnClickListener{

    private TextView textViewDay;
    private TextView textView14;
    private TextView textView13;
    private TextView textViewStart;
    private TextView textViewEnd;
    private Button buttonConfirm;
    private Button buttonChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeoverview);

        buttonChange = (Button)findViewById(R.id.buttonChange);
        buttonConfirm = (Button)findViewById(R.id.buttonChange);
        textViewDay = (TextView)findViewById(R.id.textViewDay);
        textView14 = (TextView)findViewById(R.id.textView14);
        textView13 = (TextView)findViewById(R.id.textView13);
        textViewStart = (TextView)findViewById(R.id.textViewStartingTime);
        textViewEnd = (TextView)findViewById(R.id.textViewEndTime);

        final Double dblstarttime;
        final Double dblendtime;

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //How to check start/end time here from database?
        DatabaseReference myLookupRef = database.getReference("message");
        myLookupRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //How to retrieve hour picker data from firebase here?
                textViewStart.setText(dblstarttime.toString());
                textViewEnd.setText(dblendtime.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent intentChange = new Intent(this,SetTimeActivity.class);
        this.startActivity(intentChange);

        Intent intentConfirm = new Intent(this,HomeActivity.class);
        this.startActivity(intentConfirm);

    }
}
