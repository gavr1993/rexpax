package com.rexpax.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rexpax.R;
import com.rexpax.ui.fragment.containers.RecoveryPasswordContainerFragment;
import com.rexpax.ui.fragment.containers.RegistrationContainerFragment;

import org.w3c.dom.Text;

/**
 * Created by Anton on 31.7.15.
 */
public class LoginFragment extends AbstractFragment implements View.OnClickListener {

    //GUI
    private Button registrationBtn;
    private TextView passwordRecovery;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated (View view, Bundle bundle) {
        super.onViewCreated(view, bundle);

        registrationBtn = (Button) view.findViewById(R.id.registration_btn_login_frag);
        registrationBtn.setOnClickListener(this);

        passwordRecovery = (TextView) view.findViewById(R.id.forgot_password_text);
        passwordRecovery.setOnClickListener(this);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected boolean showActionBarDefault() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registration_btn_login_frag:
                replaceChildFragment(new RegistrationContainerFragment(), null, true);
                break;

            case R.id.forgot_password_text:
                replaceChildFragment(new RecoveryPasswordContainerFragment(), null, true);
        }

    }
}
