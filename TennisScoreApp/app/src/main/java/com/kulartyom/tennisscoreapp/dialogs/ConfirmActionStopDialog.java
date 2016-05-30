package com.kulartyom.tennisscoreapp.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.kulartyom.tennisscoreapp.R;


/**
 * Created by KulArtyom on 27.05.2016.
 */
public class ConfirmActionStopDialog extends DialogFragment implements View.OnClickListener {

    // ===========================================================
    // Constants
    // ===========================================================
    public static final String TAG = ConfirmActionDialog.class.getSimpleName();

    // ===========================================================
    // Fields
    // ===========================================================

    private String mTitle;
    private ConfirmActionStopListener mListener;
    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public static ConfirmActionStopDialog getInstance(String title, ConfirmActionStopListener listener) {
        ConfirmActionStopDialog dialog = new ConfirmActionStopDialog();
        dialog.setTitle(title);
        dialog.setListener(listener);
        return dialog;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setListener(ConfirmActionStopListener listener) {
        this.mListener = listener;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View root = inflater.inflate(R.layout.dialog_confirm_action, container, false);
        root.findViewById(R.id.btn_ok).setOnClickListener(this);
        root.findViewById(R.id.btn_cancel).setOnClickListener(this);

        ((TextView) root.findViewById(R.id.tv_title)).setText(mTitle);

        Log.d(TAG, "ConfirmActionStopDialog onCreateView");
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                mListener.onConfirmActionStop();
                dismiss();
                break;
            case R.id.btn_cancel:
                mListener.onCancelActionStop();
                dismiss();
                break;
        }
        Log.d(TAG, "ConfirmActionStopDialog onClick");

    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    public interface ConfirmActionStopListener {
        void onConfirmActionStop();

        void onCancelActionStop();
    }


}
