package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;

public class CashPayView extends BasePayEntranceView {

    /* renamed from: a */
    private TextView f15022a;

    /* renamed from: b */
    private TextView f15023b;

    /* renamed from: c */
    private TextView f15024c;

    public int getLayoutId() {
        return R.layout.global_pe_pay_cash_view;
    }

    public void removeSupplement() {
    }

    public void setActionText(String str) {
    }

    public void setPrice(double d) {
    }

    public CashPayView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        this.f15022a = (TextView) findView(R.id.oc_pay_message_view);
        this.f15023b = (TextView) findView(R.id.oc_pay_title_view);
        this.f15024c = (TextView) findView(R.id.oc_pay_value_view);
    }

    public void setPrice(String str) {
        this.f15024c.setText(str);
    }

    public void setMessage(CharSequence charSequence) {
        this.f15022a.setText(charSequence);
    }

    public void addSupplement(DeductionInfo deductionInfo, String str) {
        if (deductionInfo != null) {
            this.f15023b.setText(deductionInfo.name);
        }
    }
}
