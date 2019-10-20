package com.alc.android.activityanimations;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class RegistrationActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //setActionBar();
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        tb.setSubtitle("Please register here");
        tb.setSubtitleTextColor(Color.WHITE);
        tb.setTitleTextColor(Color.WHITE);
        //tb.setSubtitleTextAppearance(this, R.style.TextAppearance_AppCompat_Body1);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            tb.setForegroundGravity(Gravity.CENTER);
//        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            //Setting toolBar back arrow button icon on RegistrationActivity
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            tb.setNavigationIcon(R.drawable.ic_arrow_back);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {//from 17 API and above
                tb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        }
        findViewById(R.id.go_login_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLoginClick();
            }
        });
    }

    private void setActionBar() {
        //Setting default toolbar empty
        setTitle("");
    }

    private void handleLoginClick() {
        Intent i = new Intent();
        i.setClass(this, LoginActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
