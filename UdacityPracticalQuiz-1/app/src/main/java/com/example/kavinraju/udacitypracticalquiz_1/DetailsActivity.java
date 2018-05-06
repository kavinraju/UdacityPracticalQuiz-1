package com.example.kavinraju.udacitypracticalquiz_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class DetailsActivity extends AppCompatActivity {

    private String name, email, desp;

    TextView textViewName , textViewEmail, textViewDesp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        inflatViews();
        getSharedPrefDeatils();
        updateUI();



    }

    private void inflatViews(){

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

        Intent intent = getIntent();
        boolean fromMenu = intent.getBooleanExtra("from_menu", true);

        if (fromMenu){
            textViewName.setText("Demo Name");
            textViewEmail.setText("demo@gmail.com");
            textViewDesp.setText("This is all about Demo description");
        } else {

            if (name != null && email != null && desp != null) {

                textViewName.setText(name);
                textViewEmail.setText(email);
                textViewDesp.setText(desp);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_from_left , R.anim.slide_to_right);
        return true;
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
