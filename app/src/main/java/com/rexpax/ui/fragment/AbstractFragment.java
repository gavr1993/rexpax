package com.rexpax.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.rexpax.R;
import com.rexpax.ui.IFragmentListener;
import com.rexpax.utils.KeyboardUtils;

/**
 * Created by Anton on 30.7.15.
 */
public abstract class AbstractFragment extends Fragment {

    protected IFragmentListener fragmentListener;

    public AbstractFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentListener = (IFragmentListener) activity;
        } catch (ClassCastException classCastException) {
            throw new IllegalAccessError("Activity MUST implement IFragmentListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayoutId(), container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setActionBarVisibility(showActionBarDefault());
    }

    protected void setActionBarVisibility(boolean isVisible) {
        fragmentListener.setActionBarVisibility(isVisible);
    }

    protected boolean showActionBarDefault() {
        return true;
    }

    protected ActionBar getSupportActionBar() {
        return fragmentListener.getActionBarSupported();
    }

    protected void setActionBarTitle(String title) {
        fragmentListener.setActionBarTitle(title, Gravity.LEFT);
    }

    protected void setActionBarTitle(String title, int gravity) {
        fragmentListener.setActionBarTitle(title, gravity);
    }

//    protected void setupFragment(final NavMenu menuItem, final boolean forceNew) {
//        fragmentListener.setupFragment(menuItem, forceNew);
//    }

    protected void hideKeyboard() {
        if(getActivity() != null) {
            KeyboardUtils.hideKeyboard(getActivity());
        }
    }

    protected void showKeyboard(EditText editText) {
        if(editText != null && getActivity() != null) {
            KeyboardUtils.showKeyboard(editText, getActivity());
        }
    }

    protected void popBackStack() {
        ((AbstractFragment) getParentFragment()).popFragment();
    }

    protected abstract int getFragmentLayoutId();

    protected void replaceParentFragment(Fragment abstractFragment, Bundle bundle, boolean addToBackStack) {
        fragmentListener.replaceFragment(abstractFragment, bundle, addToBackStack);
    }

    public boolean popParentFragment() {
        Fragment parent = getParentFragment();
        FragmentManager fm;
        if (parent != null) {
            fm = parent.getFragmentManager();
        } else {
            fm = getFragmentManager();
        }
        boolean isPop = false;
        if (fm.getBackStackEntryCount() > 0) {
            isPop = true;
            try {
                fm.popBackStack();
            } catch (IllegalStateException e) {
                Log.e("StackFragment", "popFragment: " + e.getMessage());
            }
        }
        return isPop;
    }

    public boolean popFragment() {
        Log.e("test", "pop fragment: " + getChildFragmentManager().getBackStackEntryCount());
        boolean isPop = false;
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            isPop = true;
            try {
                getChildFragmentManager().popBackStack();
            } catch (IllegalStateException e) {
                Log.e("StackFragment", "popFragment: " + e.getMessage());
            }
        }
        return isPop;
    }

    public void replaceChildFragment(final Fragment fragment, final Bundle bundle, final boolean addToBackStack) {
        ((AbstractFragment) getParentFragment()).replaceFragment(fragment, bundle, addToBackStack);
    }

    public void replaceFragment(final Fragment fragment, final Bundle bundle, final boolean addToBackStack) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        transaction.replace(R.id.container_framelayout, fragment);
        transaction.commitAllowingStateLoss();
        try {
            getChildFragmentManager().executePendingTransactions();
        } catch (IllegalStateException e) {
            Log.e("StackFragment", "replaceFragment: " + e.getMessage());
        }
    }

    public void setTitleForActionBar(){

    }
}
