package com.rexpax.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;


/**
 * Created by Anton on 30.7.15.
 */
public interface IFragmentListener {

    void replaceFragment(Fragment abstractFragment, Bundle bundle, boolean addToBackStack);

    ActionBar getActionBarSupported();

    void setActionBarVisibility(boolean isVisible);

    void setActionBarTitle(String title, int gravity);

    void showHideProgress(final boolean show, final int textId);

    void showHideProgress(final boolean show);

    void setDrawerLock(final int mode);

    //ServiceHelper getServiceHelper();

    void toggleMenu();

    //void setupFragment(NavMenu menuItem, boolean forceNew);

    //PushObserver getPushObserver();
}
