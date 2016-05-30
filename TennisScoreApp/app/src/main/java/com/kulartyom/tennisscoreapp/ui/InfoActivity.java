package com.kulartyom.tennisscoreapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kulartyom.tennisscoreapp.R;
import com.kulartyom.tennisscoreapp.constans.Constants;


public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    // ===========================================================
    // Constants
    // ===========================================================
    private static final String TAG = InfoActivity.class.getSimpleName();

    // ===========================================================
    // Fields
    // ===========================================================
    private LinearLayout mLinearLayout;

    private ImageView ivVkontakte;
    private ImageView ivFacebook;
    private ImageView ivGoogle;
    private ImageView ivTwitter;

    private Button mButtonRateUs;
    private Button mButtonReportBug;

    // ==========================================================
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
        setContentView(R.layout.activity_info);
        findViews();
        setListeners();


        assert mLinearLayout != null;
        mLinearLayout.setVisibility(View.GONE);


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
            case R.id.btn_rate:
                rateMarket();
                break;
            case R.id.btn_report_bug:
                sendMail();
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
    private void rateMarket() {
        Uri uri = Uri.parse(Constants.MARKET);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void findViews() {
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_social);
        ivVkontakte = (ImageView) findViewById(R.id.iv_vk_share);
        ivFacebook = (ImageView) findViewById(R.id.iv_facebook_share);
        ivGoogle = (ImageView) findViewById(R.id.iv_google_share);
        ivTwitter = (ImageView) findViewById(R.id.iv_twitter_share);
        mButtonRateUs = (Button) findViewById(R.id.btn_rate);
        mButtonReportBug = (Button) findViewById(R.id.btn_report_bug);

        Log.d(TAG, "InfoActivity findViews");
    }

    private void setListeners() {
        ivFacebook.setOnClickListener(this);
        ivVkontakte.setOnClickListener(this);
        ivTwitter.setOnClickListener(this);
        ivGoogle.setOnClickListener(this);
        mButtonRateUs.setOnClickListener(this);
        mButtonReportBug.setOnClickListener(this);

        Log.d(TAG, "InfoActivity setListeners");

    }

    private void sendMail() {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        String aEmailList[] = {
                Constants.MAIL
        };
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, Constants.MAIL_THEME);
        emailIntent.setType("plain/text");
        startActivity(Intent.createChooser(emailIntent, Constants.SEND_EMAIL_CHOOSER_TITLE));
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
