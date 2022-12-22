package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.taxis99.R;

public class NoStatePayNewView extends NoStatePayView {
    public int getLayoutId() {
        return R.layout.global_pe_pay_no_state_layout_new;
    }

    public NoStatePayNewView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }
}
