package com.alc.android.activityanimations;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setActionBar();
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        tb.setSubtitle("Please login");
        tb.setSubtitleTextColor(Color.WHITE);
        tb.setTitleTextColor(Color.WHITE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            //Setting toolBar back arrow button icon on LoginActivity
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            tb.setNavigationIcon(R.drawable.ic_arrow_back);
        }
        findViewById(R.id.go_reg_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRegistrationClick();
            }
        });
    }

    private void setActionBar() {
        //Setting default toolbar empty
        setTitle("");
    }

    private void handleRegistrationClick() {
        Intent i = new Intent();
        i.setClass(this, RegistrationActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
    }
}
