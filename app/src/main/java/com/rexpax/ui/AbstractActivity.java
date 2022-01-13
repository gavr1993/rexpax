package com.rexpax.ui;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rexpax.R;
import com.rexpax.utils.KeyboardUtils;


public abstract class AbstractActivity extends AppCompatActivity implements IFragmentListener {

    protected FragmentManager fragmentManager;
    protected TextView actionBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        setContentView(getContentViewResource());
    }

    @SuppressLint("LongLogTag")
    private void replaceFragment(Fragment abstractFragment, Bundle bundle, boolean addToBackStack, int replacementID) {
        KeyboardUtils.hideKeyboard(this);
        String fragmentName = abstractFragment.getClass().getName();
        //#debug
        Log.d("Replacing fragment with ", fragmentName);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragmentName);
        }

        Fragment fragment = Fragment.instantiate(AbstractActivity.this, fragmentName, bundle);
        fragmentTransaction.replace(replacementID, fragment, fragmentName);

        try {
            fragmentTransaction.commitAllowingStateLoss();

        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void replaceFragment(Fragment abstractFragment, Bundle bundle, boolean addToBackStack) {
        replaceFragment(abstractFragment, bundle, addToBackStack,
                getFragmentReplacementResource());
    }

    @Override
    public void setActionBarTitle (String title, int gravity){
        getActionBar().setTitle(title);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(getString(R.string.app_name));
    }

    public abstract int getFragmentReplacementResource();
    public abstract int getContentViewResource();
    public abstract int getToolbarTitleResource();
}
