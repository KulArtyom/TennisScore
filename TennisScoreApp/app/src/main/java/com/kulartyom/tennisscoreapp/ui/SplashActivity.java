package com.kulartyom.tennisscoreapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.kulartyom.tennisscoreapp.R;
import com.kulartyom.tennisscoreapp.constans.Constants;


public class SplashActivity extends AppCompatActivity {

    // ===========================================================
    // Constants
    // ===========================================================
    public static final String TAG = SplashActivity.class.getSimpleName();

    // ===========================================================
    // Fields
    // ===========================================================


    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        splashIntent();
        Log.d(TAG, "SplashActivity onCreate");
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void splashIntent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splash);
            }
        }, Constants.SPLASH_TIME_OUT);
        Log.d(TAG, "SplashActivity splashIntent");
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
