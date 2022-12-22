package com.didi.global.globalgenerickit.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GGKDialogFragment extends GGKBaseAlertDialogFragment {

    /* renamed from: a */
    private GGKBaseDialogModel f22064a;

    public static GGKDialogFragment newInstance(GGKBaseDialogModel gGKBaseDialogModel) {
        GGKDialogFragment gGKDialogFragment = new GGKDialogFragment();
        gGKDialogFragment.f22064a = gGKBaseDialogModel;
        return gGKDialogFragment;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f22064a == null) {
            return null;
        }
        return new C8583a(getContext(), this.f22064a.mo66512a()).mo66548a();
    }
}
