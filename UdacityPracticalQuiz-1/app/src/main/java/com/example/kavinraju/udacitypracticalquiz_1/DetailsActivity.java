package com.example.kavinraju.udacitypracticalquiz_1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class DetailsActivity extends AppCompatActivity {

    private String name, email, desp;

    TextView textViewName , textViewEmail, textViewDesp;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        inflatViews();
        getSharedPrefDeatils();
        updateUI();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_from_left , R.anim.slide_to_right);
            }
        });

    }

    private void inflatViews(){

        imageButton = findViewById(R.id.imageButton);
        textViewName = findViewById(R.id.textView_name);
        textViewEmail = findViewById(R.id.textView_email);
        textViewDesp= findViewById(R.id.textView_desp);
    }


    private void getSharedPrefDeatils() {

        SharedPreferences sharedPreferences = getSharedPreferences(SharredPref_Utils.sharedPrefName, MODE_PRIVATE);

        name = sharedPreferences.getString(SharredPref_Utils.name_key, "Demo USer");
        email = sharedPreferences.getString(SharredPref_Utils.email_key, "demouser@gmail.com");
        desp = sharedPreferences.getString(SharredPref_Utils.desp_key, "This is all about the Demo User. This app is made for Udacity Practical Quiz-1 ");
    }

    private void updateUI(){

        if ( name != null && email != null && desp != null ){

            textViewName.setText(name);
            textViewEmail.setText(email);
            textViewDesp.setText(desp);
        }
    }
}
/*

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();
        }
        });*/
