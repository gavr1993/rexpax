package com.rexpax.ui.activity;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;

import com.rexpax.R;
import com.rexpax.ui.AbstractActivity;
import com.rexpax.ui.fragment.containers.LoginContainerFragment;

/**
 * Created by Anton on 30.7.15.
 */

public class LoginBaseActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(new LoginContainerFragment(), null, false);
    }

    @Override
    public int getFragmentReplacementResource() {
        return R.id.fragment_login_placeholder;
    }

    @Override
    public int getContentViewResource() {
        return R.layout.activity_login_base;
    }

    @Override
    public int getToolbarTitleResource() {
        return 0;
    }

    @Override
    public ActionBar getActionBarSupported() {
        return null;
    }

    @Override
    public void setActionBarVisibility(boolean isVisible) {

    //#debug
        Log.d("setActionBarVisibility ", String.valueOf(isVisible));
        if (getSupportActionBar() != null) {
            if (isVisible) {
                getSupportActionBar().show();
            } else {
                getSupportActionBar().hide();
            }
        }
    }

    @Override
    public void setActionBarTitle(String title, int gravity) {

    }

    @Override
    public void showHideProgress(boolean show, int textId) {

    }

    @Override
    public void showHideProgress(boolean show) {

    }

    @Override
    public void setDrawerLock(int mode) {

    }

    @Override
    public void toggleMenu() {

    }
}
