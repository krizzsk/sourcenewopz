package com.didi.unifiedPay.component.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.trackupload.sdk.Constants;
import com.didi.unifiedPay.component.AbsUnifiedPaymentPresenter;
import com.didi.unifiedPay.component.IViewCallback;
import com.taxis99.R;

public class TripUniPayPresenter extends AbsUnifiedPaymentPresenter {
    public static final int CODE_PAY_SUCCESS = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f44391a;

    /* renamed from: b */
    private int f44392b;

    /* renamed from: c */
    private String f44393c;

    public TripUniPayPresenter(Context context, FragmentManager fragmentManager, String str, int i, String str2, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
        this.f44391a = (Activity) context;
        this.f44392b = i;
        this.f44393c = str2;
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        super.onPaySuccessed(i, str);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("code", 1);
                bundle.putString("message", TripUniPayPresenter.this.mContext.getString(R.string.oc_pay_success_string));
                intent.putExtras(bundle);
                TripUniPayPresenter.this.f44391a.setResult(-1, intent);
                TripUniPayPresenter.this.f44391a.finish();
            }
        }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
    }

    /* access modifiers changed from: protected */
    public int getBid() {
        return this.f44392b;
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        return "" + this.f44393c;
    }
}
