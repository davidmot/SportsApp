package com.example.davidmoz.sportsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Button buttonChangeSettings, buttonCancelPending, buttonConfirmPendings, buttonCancelConfirmMatches, buttonConfirmMatches, butteonCancelUpcoming;
    private ListView listViewUpcoming, listViewConfirm, listViewPending;
    private TextView textViewHello;


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
}
