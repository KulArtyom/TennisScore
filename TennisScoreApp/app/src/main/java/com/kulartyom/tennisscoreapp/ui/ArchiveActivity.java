package com.kulartyom.tennisscoreapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kulartyom.tennisscoreapp.R;
import com.kulartyom.tennisscoreapp.database.Games;
import java.util.List;

public class ArchiveActivity extends AppCompatActivity {
    // ===========================================================
    // Constants
    // ===========================================================
    private static final String TAG = ArchiveActivity.class.getSimpleName();

    // ===========================================================
    // Fields
    // ===========================================================


    private TextView textView;
    private Button mButtonClear;
    private List<Games> allContacts;


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
        setContentView(R.layout.activity_archive);
        findViews();

        allContacts = Games.listAll(Games.class);
        textView.setText(allContacts.toString());
        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Games.deleteAll(Games.class);
                textView.setText(null);
            }
        });
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void findViews() {
        textView = (TextView) findViewById(R.id.tv_archive);
        mButtonClear = (Button) findViewById(R.id.btn_clear);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
