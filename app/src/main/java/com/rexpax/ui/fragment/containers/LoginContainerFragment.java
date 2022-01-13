package com.rexpax.ui.fragment.containers;

import com.rexpax.ui.fragment.ContainerFragment;
import com.rexpax.ui.fragment.LoginFragment;

/**
 * Created by Anton on 31.07.2015.
 */
public class LoginContainerFragment extends ContainerFragment {
    @Override
    protected void initView() {
        replaceFragment(new LoginFragment(), getArguments(), false);
    }
}
