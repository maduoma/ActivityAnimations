package com.alc.android.activityanimations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        mButton.setOnClickListener(this);

    }

    public void init(){
        mButton = findViewById(R.id.register);
    }

    @Override
    public void onClick(View v) {
            Intent myIntent = new Intent(this, RegistrationActivity.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.fade_out);
            this.startActivity(myIntent, options.toBundle());


    }
}
