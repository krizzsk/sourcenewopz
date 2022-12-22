package com.didi.global.globaluikit.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LEGODialogFragment extends LEGOBaseAlertDialogFragment {

    /* renamed from: a */
    private LEGORealUsedModel f22484a;

    public static LEGODialogFragment newInstance(LEGOBaseDialogModel lEGOBaseDialogModel) {
        LEGODialogFragment lEGODialogFragment = new LEGODialogFragment();
        if (lEGOBaseDialogModel != null) {
            lEGODialogFragment.f22484a = lEGOBaseDialogModel.convert();
        }
        return lEGODialogFragment;
    }

    public static LEGODialogFragment newInstance(LEGORealUsedModel lEGORealUsedModel) {
        LEGODialogFragment lEGODialogFragment = new LEGODialogFragment();
        lEGODialogFragment.f22484a = lEGORealUsedModel;
        return lEGODialogFragment;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f22484a == null) {
            return null;
        }
        return new C8649a(getContext(), this.f22484a).mo66913a();
    }
}
