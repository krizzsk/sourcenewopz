package com.didi.component.phoneentrance.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.taxis99.R;

public class PhoneEntranceV2View extends PhoneEntranceBaseView {
    public void setSecurityVisible(boolean z) {
    }

    public PhoneEntranceV2View(Context context, ViewGroup viewGroup, boolean z) {
        super(context, viewGroup, z);
    }

    /* access modifiers changed from: protected */
    public View inflateView(Context context, ViewGroup viewGroup) {
        if (this.isBigCard) {
            return LayoutInflater.from(context).inflate(R.layout.global_phone_entrance_v2_view, viewGroup, false);
        }
        return LayoutInflater.from(context).inflate(R.layout.global_phone_entrance_v2_small_view, viewGroup, false);
    }
}
