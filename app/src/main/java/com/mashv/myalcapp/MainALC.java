package com.mashv.myalcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainALC extends AppCompatActivity {
    private Button mBtnAboutAlc;
    private Button mBtnMyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtnAboutAlc = (Button)findViewById(R.id.btnAboutAlc);
        mBtnMyProfile = (Button)findViewById(R.id.btnMyProfile);

        mBtnAboutAlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webView =  new Intent(MainALC.this, AboutALC.class);
                startActivity(webView);
            }
        });


        mBtnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MainALC.this,Profile.class);
                startActivity(profile);
            }
        });
    }

}
