package com.rexpax.ui.activity;

import android.support.v7.app.ActionBar;
import android.util.Log;
import com.rexpax.ui.AbstractActivity;

/**
 * Created by ppp on 03.08.15.
 */

public abstract class BaseFragmentActivity extends AbstractActivity {

    @Override
    public ActionBar getActionBarSupported() {
        return getSupportActionBar();
    }

    @Override
    public void setActionBarVisibility(boolean isVisible) {
        //#debug
        Log.d("setActionBarVisibility ", String.valueOf(isVisible));
        if (getActionBarSupported() != null) {
            if (isVisible) {
                getSupportActionBar().show();
            } else {
                getSupportActionBar().hide();
            }
        }
    }

    @Override
    public void setActionBarTitle(String title, int gravity) {
        setTitle(title);
    }
}
