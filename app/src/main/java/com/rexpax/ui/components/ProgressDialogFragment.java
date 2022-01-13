package com.rexpax.ui.components;

/**
 * Created by ppp on 03.08.2015.
 */
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ProgressDialogFragment extends DialogFragment {

    public static final String PROGRESS_TAG = "PROGRESS_TAG";
    public static final String TEXT_ARGUMENT = "TEXT_ARGUMENT";

    private String dialogText = "";

    public ProgressDialogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setCancelable(false);
        Bundle args = getArguments();
        if (args != null && !args.isEmpty())  {
            if (args.containsKey(TEXT_ARGUMENT)) {
                dialogText = args.getString(TEXT_ARGUMENT);
            }
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(getActivity(), getTheme());
        dialog.setMessage(dialogText);
        dialog.setIndeterminate(true);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return dialog;
    }
}
