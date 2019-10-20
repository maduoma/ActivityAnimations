package com.alc.android.activityanimations;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme.NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        final TextView timer = findViewById(R.id.timer);
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    WelcomeScreen.this.startActivity(new Intent(WelcomeScreen.this, MainActivity.class));
                    WelcomeScreen.this.finish();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                //overridePendingTransition(R.anim.entry_anim, android.R.anim.cycle_interpolator);
            }
        }.start();

        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(MessageFormat.format("Seconds remaining: {0}", millisUntilFinished / 1000));
            }

            public void onFinish() {
                timer.setText(R.string.done);
            }
        }.start();
    }
}

