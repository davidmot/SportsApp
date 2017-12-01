package com.example.davidmoz.sportsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OverviewActivity extends Activity implements View.OnClickListener {
    private Button buttonConfirmOverview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        buttonConfirmOverview = (Button) findViewById(R.id.buttonConfirmOverview);
        buttonConfirmOverview.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intentGoToHome = new Intent(this, HomeActivity.class);
        this.startActivity(intentGoToHome);

    }
}
