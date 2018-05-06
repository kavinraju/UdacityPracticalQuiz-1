package com.example.kavinraju.udacitypracticalquiz_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;

public class MainActivity extends AppCompatActivity {

    ImageView background;
    CardView cardView;
    Button buttonLogin;
    EditText editText_Name, editText_email , editText_Desp;

    String key_name = "name";
    String key_email = "email";
    String key_desp = "desp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inflatViews();
        if (savedInstanceState != null){
            if (savedInstanceState.containsKey(key_name)){
                editText_Name.setText(savedInstanceState.getString(key_name));
            }

            if (savedInstanceState.containsKey(key_email)){
                editText_email.setText(savedInstanceState.getString(key_email));
            }
            if (savedInstanceState.containsKey(key_desp)){
                editText_Desp.setText(savedInstanceState.getString(key_desp));
            }



        }


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( editText_Desp.getText().toString().length() == 0 ||
                        editText_email.getText().toString().length() == 0 ||
                        editText_Name.getText().toString().length() == 0 ){
                    return;
                }

                String name = editText_Name.getText().toString();
                String email = editText_email.getText().toString();
                String desp = editText_Desp.getText().toString();


                loadDeatilsIntoSharredPref(name,email,desp);

                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                intent.putExtra("from_menu" ,false);
                startActivity(intent);

                overridePendingTransition(R.anim.slide_from_right , R.anim.slide_to_left);

            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String name = editText_Name.getText().toString(); //.equals("") ? " ":editText_Name.getText().toString();
        String email = editText_email.getText().toString(); //.equals("") ? " ":editText_email.getText().toString();
        String desp = editText_Desp.getText().toString(); //.equals("") ? " ":editText_Desp.getText().toString();
        outState.putString("name" , name);
        outState.putString("email" , email);
        outState.putString("desp" , desp);


    }

    private void inflatViews(){

        buttonLogin = findViewById(R.id.login);
        editText_Name = findViewById(R.id.editText_Name);
        editText_email = findViewById(R.id.editText_email);
        editText_Desp= findViewById(R.id.editText_Desp);
        cardView = findViewById(R.id.cardView);
    }

    private void loadDeatilsIntoSharredPref(String name, String email, String desp){

        try {

            SharedPreferences sharedPreferences = getSharedPreferences(SharredPref_Utils.sharedPrefName ,MODE_PRIVATE);
;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SharredPref_Utils.name_key  , name);
            editor.putString(SharredPref_Utils.email_key,email);
            editor.putString(SharredPref_Utils.desp_key,desp);
            editor.apply();

        } catch (NumberFormatException e)
        {
            //Toast.makeText(Registration.this ," Oops "+e ,Toast.LENGTH_LONG).show();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {

            Intent intent = new Intent(this,DetailsActivity.class);
            intent.putExtra("from_menu" ,true);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_right , R.anim.slide_to_left);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int[] screenSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return new int[]{size.x,size.y};
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
       /* int[] screenSize=screenSize();
        background = findViewById(R.id.scrolling_background);
        Glide.with(this)
                .load(R.drawable.allens_home_i)
                .asBitmap()
                .override(screenSize[0]*2,screenSize[1])
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(new ImageViewTarget<Bitmap>(background) {

                    @Override
                    protected void setResource(Bitmap resource) {
                        background.setImageBitmap(resource);

                       *//* pager.post(()->{
                            AuthAdapter adapter = new AuthAdapter(getSupportFragmentManager(), pager, background, sharedElements);
                            pager.setAdapter(adapter);
                        });*//*
                    }
                });*/