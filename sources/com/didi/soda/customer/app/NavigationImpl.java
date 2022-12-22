package com.didi.soda.customer.app;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class NavigationImpl implements INavigation {

    /* renamed from: a */
    private FragmentManager f40334a;

    public NavigationImpl(FragmentManager fragmentManager) {
        this.f40334a = fragmentManager;
    }

    public void dismissDialog(DialogFragment dialogFragment) {
        if (dialogFragment.isAdded() && dialogFragment.getFragmentManager() != null) {
            dialogFragment.dismiss();
        }
    }

    public void showDialog(DialogFragment dialogFragment) {
        FragmentManager fragmentManager;
        if (!dialogFragment.isAdded() && (fragmentManager = this.f40334a) != null) {
            dialogFragment.show(fragmentManager, "");
        }
    }
}
