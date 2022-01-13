package com.rexpax.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.rexpax.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class ContainerFragment extends AbstractFragment {


    private boolean mIsViewInited;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.container_fragment;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!mIsViewInited) {
            mIsViewInited = true;
            initView();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Fragment childFragment = getActiveFragment(getChildFragmentManager());
        if (childFragment != null) {
            childFragment.onActivityResult(requestCode, resultCode, intent);
        }
    }

    public Fragment getActiveFragment(final FragmentManager manager) {
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isVisible()) {
                    return fragment;
                }
            }
        }
        return null;
    }

    protected abstract void initView();

}
