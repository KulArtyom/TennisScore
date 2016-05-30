package com.kulartyom.tennisscoreapp.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.kulartyom.tennisscoreapp.R;
import com.kulartyom.tennisscoreapp.constans.Constants;
import com.kulartyom.tennisscoreapp.logic.Game;


public class SettingsDialogFragment extends DialogFragment implements View.OnClickListener, TextWatcher {
    // ===========================================================
    // Constants
    // ===========================================================
    public static final String TAG = SettingsDialogFragment.class.getSimpleName();

    // ===========================================================
    // Fields
    // ===========================================================
    private OnAppSettingsChangedListener mListener;

    private EditText mEtPlayerOneName;
    private EditText mEtPlayerTwoName;

    private RadioButton mRbBestOfThree;
    private RadioButton mRbBestOfFive;

    private Button mBtnOk;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public void setListener(OnAppSettingsChangedListener listener) {
        this.mListener = listener;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "SettingsDialogFragment onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View root = inflater.inflate(R.layout.dialog_settings, container, false);
        mBtnOk = ((Button) root.findViewById(R.id.btn_ok));
        mBtnOk.setOnClickListener(this);

        root.findViewById(R.id.btn_cancel).setOnClickListener(this);

        mEtPlayerOneName = (EditText) root.findViewById(R.id.et_player_one_name);
        mEtPlayerOneName.addTextChangedListener(this);
        mEtPlayerTwoName = (EditText) root.findViewById(R.id.et_player_two_name);
        mEtPlayerTwoName.addTextChangedListener(this);

        mRbBestOfThree = (RadioButton) root.findViewById(R.id.rb_best_of_three);
        mRbBestOfFive = (RadioButton) root.findViewById(R.id.rb_best_of_five);
        Log.d(TAG, "SettingsDialogFragment onCreateView");
        return root;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            int gameType = args.getInt(Constants.ARG_GAME_TYPE);
            if (gameType == Game.GAME_TYPE_3) {
                mRbBestOfThree.setChecked(true);
            } else {
                mRbBestOfFive.setChecked(true);
            }
        }
        Log.d(TAG, "SettingsDialogFragment onActivityCreated");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                int type = mRbBestOfThree.isChecked() ? Game.GAME_TYPE_3 : Game.GAME_TYPE_5;

                mListener.onAppSettingsChanged(
                        mEtPlayerOneName.getText().toString(),
                        mEtPlayerTwoName.getText().toString(),
                        type
                );
            case R.id.btn_cancel:
                dismiss();
                break;
        }
        Log.d(TAG, "SettingsDialogFragment onClick");
    }

    // ===========================================================
    // Methods
    // ===========================================================
    public static SettingsDialogFragment getInstance(OnAppSettingsChangedListener listener,
                                                     String namePlayerOne, String namePlayerTwo,
                                                     int gameType) {
        SettingsDialogFragment settingsDialogFragment = new SettingsDialogFragment();
        settingsDialogFragment.setListener(listener);
        Bundle args = new Bundle();
        args.putString(Constants.ARG_PLAYER_ONE_NAME, namePlayerOne);
        args.putString(Constants.ARG_PLAYER_TWO_NAME, namePlayerTwo);
        args.putInt(Constants.ARG_GAME_TYPE, gameType);
        settingsDialogFragment.setArguments(args);
        return settingsDialogFragment;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d(TAG, "SettingsDialogFragment beforeTextChanged");

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TAG, "SettingsDialogFragment onTextChanged");

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!mEtPlayerOneName.getText().toString().isEmpty() && !mEtPlayerTwoName.getText().toString().isEmpty())
            mBtnOk.setEnabled(true);
        else
            mBtnOk.setEnabled(false);
        Log.d(TAG, "SettingsDialogFragment afterTextChanged");

    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    public interface OnAppSettingsChangedListener {
        void onAppSettingsChanged(String playerOneName, String playerTwoName, int gameType);
    }

}
