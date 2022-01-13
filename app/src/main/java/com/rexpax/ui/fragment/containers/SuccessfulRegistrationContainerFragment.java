package com.rexpax.ui.fragment.containers;

import com.rexpax.ui.fragment.ContainerFragment;
import com.rexpax.ui.fragment.SuccesfulRegistrationFragment;

/**
 * Created by Anton on 03.08.2015.
 */
public class SuccessfulRegistrationContainerFragment extends ContainerFragment {
    @Override
    protected void initView() {
        replaceFragment(new SuccesfulRegistrationFragment(), getArguments(), true);
    }
}
