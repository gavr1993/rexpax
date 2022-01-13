package com.rexpax.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.rexpax.R;
import com.rexpax.ui.components.NavigationDrawerHelper;
import com.rexpax.ui.components.ProgressDialogFragment;
import com.rexpax.ui.components.ScreenItem;

/**
 * Created by ppp on 03.08.2015.
 */
public class NavigationActivity extends BaseFragmentActivity implements NavigationDrawerHelper.NavigationDrawerListener {

    private ProgressDialogFragment dialogFragment;
    private NavigationDrawerHelper drawerHelper = null;

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setupActionBar();
        this.drawerHelper = new NavigationDrawerHelper(this);
        drawerHelper.setOnNavigationDrawerListener(this);
    }

    @Override
    public int getFragmentReplacementResource() {
        return R.id.content;
    }

    @Override
    public int getContentViewResource() {
        return R.layout.navigation_activity;
    }

    @Override
    public int getToolbarTitleResource() {
        return 0;
    }

    @Override
    public void showHideProgress(boolean show, int textId) {
        if(isFinishing()) {
            return;
        }
        if (!show && dialogFragment != null) {
            dialogFragment.dismiss();
            dialogFragment = null;
            return;
        }
        dialogFragment = new ProgressDialogFragment();
        Bundle args = new Bundle();
        String msgText = "";
        if (textId != -1) {
            msgText = getString(textId);
        }
        args.putString(ProgressDialogFragment.TEXT_ARGUMENT, msgText);
        dialogFragment.setArguments(args);
        if(!isFinishing()) {
            getSupportFragmentManager().beginTransaction().
            add(dialogFragment, ProgressDialogFragment.PROGRESS_TAG).commitAllowingStateLoss();
        }
    }

    @Override
    public void showHideProgress(boolean show) {
        showHideProgress(show, R.string.loading_str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showHideProgress(false);
    }

    @Override
    public void setDrawerLock(int mode) {
    }

    @Override
    public void toggleMenu() {
    }

    private void setupActionBar() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(getString(R.string.app_name));
    }

    public NavigationDrawerHelper getDrawerHelper() {
        return drawerHelper;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerHelper != null) {
                    drawerHelper.toggle();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerHelper != null && drawerHelper.isOpened()) {
            drawerHelper.toggle();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position, ScreenItem item) {
        switch (item) {
            case HOME:
                break;
            case ABOUT:
                break;
        }
    }
}
