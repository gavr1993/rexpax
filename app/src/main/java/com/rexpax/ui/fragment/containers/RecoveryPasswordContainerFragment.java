package com.rexpax.ui.fragment.containers;

import com.rexpax.ui.fragment.ContainerFragment;
import com.rexpax.ui.fragment.RecoveryPasswordFragment;

/**
 * Created by Anton on 03.08.2015.
 */
public class RecoveryPasswordContainerFragment extends ContainerFragment {
    @Override
    protected void initView() {
        replaceFragment(new RecoveryPasswordFragment(), getArguments(), true);
    }
}
