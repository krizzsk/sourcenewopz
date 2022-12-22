package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;

public class EvaluatedUnpayView extends BasePayEntranceView {
    public void addSupplement(DeductionInfo deductionInfo, String str) {
    }

    public int getLayoutId() {
        return R.layout.global_pe_pay_evaluated;
    }

    public void removeSupplement() {
    }

    public void setMessage(CharSequence charSequence) {
    }

    public void setPrice(double d) {
    }

    public void setPrice(String str) {
    }

    public EvaluatedUnpayView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        findView(R.id.oc_pay_entrance_goto_pay_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EvaluatedUnpayView.this.mOnPayListener != null) {
                    EvaluatedUnpayView.this.performOnPay("0", "0");
                }
            }
        });
    }

    public void setActionText(String str) {
        ((TextView) findView(R.id.oc_pay_entrance_goto_pay)).setText(str);
    }
}
