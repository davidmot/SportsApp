package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CSportActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmCSport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csport);
        buttonConfirmCSport=(Button) findViewById(R.id.buttonConfirmCSport);

        buttonConfirmCSport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intentgoToTime = new Intent(this, SetTimeActivity.class);
        this.startActivity(intentgoToTime);

    }
}
