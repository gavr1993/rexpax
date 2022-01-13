package com.rexpax.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rexpax.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecoveryPasswordFragment extends AbstractFragment {


    public RecoveryPasswordFragment() {
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_recovery_password, container, false);
//    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_recovery_password;
    }

}
