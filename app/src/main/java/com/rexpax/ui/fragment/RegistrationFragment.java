package com.rexpax.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rexpax.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends AbstractFragment {


    public RegistrationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated (View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_registration;
    }

    @Override
    protected boolean showActionBarDefault() {
        return false;
    }
}
