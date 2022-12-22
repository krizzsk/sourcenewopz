package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;

public class NoStatePayView extends BasePayEntranceView {
    public void addSupplement(DeductionInfo deductionInfo, String str) {
    }

    public int getLayoutId() {
        return R.layout.global_pe_pay_no_state_layout;
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
    }

    public void removeSupplement() {
    }

    public void setActionText(String str) {
    }

    public void setMessage(CharSequence charSequence) {
    }

    public void setPrice(double d) {
    }

    public void setPrice(String str) {
    }

    public NoStatePayView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return findView(R.id.oc_pay_no_state_contener);
    }
}
