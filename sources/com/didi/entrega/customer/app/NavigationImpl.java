package com.didi.entrega.customer.app;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class NavigationImpl implements INavigation {

    /* renamed from: a */
    private FragmentManager f19793a;

    public NavigationImpl(FragmentManager fragmentManager) {
        this.f19793a = fragmentManager;
    }

    public void dismissDialog(DialogFragment dialogFragment) {
        if (dialogFragment.isAdded() && dialogFragment.getFragmentManager() != null) {
            dialogFragment.dismiss();
        }
    }

    public void showDialog(DialogFragment dialogFragment) {
        FragmentManager fragmentManager;
        if (!dialogFragment.isAdded() && (fragmentManager = this.f19793a) != null) {
            dialogFragment.show(fragmentManager, "");
        }
    }
}
