package com.didi.global.globalgenerickit.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GGKCustomFragment extends GGKBaseAlertDialogFragment {

    /* renamed from: a */
    private View f22063a;

    public static GGKCustomFragment getInstance(View view) {
        GGKCustomFragment gGKCustomFragment = new GGKCustomFragment();
        gGKCustomFragment.f22063a = view;
        return gGKCustomFragment;
    }

    public void setRootView(View view) {
        this.f22063a = view;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f22063a;
    }
}
