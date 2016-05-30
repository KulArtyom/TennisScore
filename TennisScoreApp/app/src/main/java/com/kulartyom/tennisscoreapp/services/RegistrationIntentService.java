package com.kulartyom.tennisscoreapp.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by KulArtyom on 27.05.2016.
 */
public class RegistrationIntentService extends IntentService {
    // ===========================================================
    // Constants
    // ===========================================================
    private static final String TAG = RegistrationIntentService.class.getSimpleName();

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    public RegistrationIntentService(String name) {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
