package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetTimeActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        buttonConfirmTime=(Button) findViewById(R.id.buttonConfirmTime);
        buttonConfirmTime.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intentgoToSettings=new Intent(this, OverviewActivity.class);
        this.startActivity(intentgoToSettings);
    }
}
