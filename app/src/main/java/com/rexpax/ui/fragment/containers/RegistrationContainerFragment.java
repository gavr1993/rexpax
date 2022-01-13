package com.rexpax.ui.fragment.containers;

import com.rexpax.ui.fragment.ContainerFragment;
import com.rexpax.ui.fragment.RegistrationFragment;

/**
 * Created by Anton on 03.08.2015.
 */
public class RegistrationContainerFragment extends ContainerFragment {
    @Override
    protected void initView() {
        replaceFragment(new RegistrationFragment(), getArguments(), true);
    }
}
