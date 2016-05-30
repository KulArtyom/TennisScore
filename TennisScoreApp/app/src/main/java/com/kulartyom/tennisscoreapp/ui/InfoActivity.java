package com.kulartyom.tennisscoreapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kulartyom.tennisscoreapp.R;


public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    // ===========================================================
    // Constants
    // ===========================================================
    private static final String TAG = InfoActivity.class.getSimpleName();

    // ===========================================================
    // Fields
    // ===========================================================
    private ImageView ivVkontakte;
    private ImageView ivFacebook;
    private ImageView ivGoogle;
    private ImageView ivTwitter;

    private Button mButtonCrash;


    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
//    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
//        @Override
//        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
//            if (newToken == null) {
//                Toast.makeText(InfoActivity.this, "AccessToken invalidated", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(InfoActivity.this, LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_info);


        ivVkontakte = (ImageView) findViewById(R.id.iv_vk_share);
        ivFacebook = (ImageView) findViewById(R.id.iv_facebook_share);
        ivGoogle = (ImageView) findViewById(R.id.iv_google_share);
        ivTwitter = (ImageView) findViewById(R.id.iv_twitter_share);

        mButtonCrash = (Button) findViewById(R.id.btnCrash);

        ivFacebook.setOnClickListener(this);
        ivVkontakte.setOnClickListener(this);
        ivTwitter.setOnClickListener(this);
        ivGoogle.setOnClickListener(this);
        mButtonCrash.setOnClickListener(this);

        Log.d(TAG, "InfoActivity onCreate");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_facebook_share:

                break;
            case R.id.iv_vk_share:

                break;
            case R.id.iv_google_share:

                break;
            case R.id.iv_twitter_share:

                break;
            case R.id.btnCrash:

            default:
                break;

        }
        Log.d(TAG, "InfoActivity onClick");
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "InfoActivity onActivityResult");
    }

    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
