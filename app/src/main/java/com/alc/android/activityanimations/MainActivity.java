package com.alc.android.activityanimations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SPLASH_DISPLAY_TIME = 10000;
    Button mButton;
    Button mCircularReveal;
    public WelcomeScreen mWelcomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mButton.setOnClickListener(this);
        mCircularReveal.setOnClickListener(this);
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                /* Create an intent that will start the main activity. */
//                Intent mainIntent = new Intent(MainActivity.this, WelcomeScreen.class);
//                mainIntent.putExtra("id", "1");
//                //WelcomeScreen.this.startActivity(mainIntent);
//                startActivity(mainIntent);
//                /* Finish splash activity so user cant go back to it. */
//                mWelcomeScreen = new WelcomeScreen();
//                mWelcomeScreen.finish();
//                /* Apply our splash exit (fade out) and main entry (fade in) animation transitions. */
//                overridePendingTransition(R.anim.entry_anim, android.R.anim.cycle_interpolator);
//            }
//        }, SPLASH_DISPLAY_TIME);
    }

    public void init() {
        mButton = findViewById(R.id.clickMe);
        mCircularReveal = findViewById(R.id.circular_reveal);
    }

    @Override
    public void onClick(View v) {//+16
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Intent myIntent = new Intent(this, SecondActivity.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_out_up, R.anim.slide_in_up);
            this.startActivity(myIntent, options.toBundle());
        } else {//+5
            startActivity(new Intent(this, SecondActivity.class));
            overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_up);
        }
//+3
//        Intent myIntent = new Intent(this, SecondActivity.class);
//        myIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        this.startActivity(myIntent);
        if (v.getId() == R.id.circular_reveal){
            Intent activityOne = new Intent(this, ActivityOne.class);
            startActivity(activityOne);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_up);
    }


//
//        if (savedInstanceState == null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
//                intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) &&
//                intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)) {
//            rootLayout.setVisibility(View.INVISIBLE);
//
//            revealX = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_X, 0);
//            revealY = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_Y, 0);
//
//
//            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
//            if (viewTreeObserver.isAlive()) {
//                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        revealActivity(revealX, revealY);
//                        rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                    }
//                });
//            }
//        } else {
//            rootLayout.setVisibility(View.VISIBLE);
//        }
//
//        protected void revealActivity ( int x, int y){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);
//
//                // create the animator for this view (the start radius is zero)
//                Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, x, y, 0, finalRadius);
//                circularReveal.setDuration(400);
//                circularReveal.setInterpolator(new AccelerateInterpolator());
//
//                // make the view visible and start the animation
//                rootLayout.setVisibility(View.VISIBLE);
//                circularReveal.start();
//            } else {
//                finish();
//            }
//        }
//
//        protected void unRevealActivity () {
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//                finish();
//            } else {
//                float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);
//                Animator circularReveal = ViewAnimationUtils.createCircularReveal(
//                        rootLayout, revealX, revealY, finalRadius, 0);
//
//                circularReveal.setDuration(400);
//                circularReveal.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        rootLayout.setVisibility(View.INVISIBLE);
//                        finish();
//                    }
//                });
//
//
//                circularReveal.start();
//            }
//        }
//

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            onBackPressed();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
