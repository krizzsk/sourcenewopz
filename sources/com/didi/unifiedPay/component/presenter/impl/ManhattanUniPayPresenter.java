package com.didi.unifiedPay.component.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.trackupload.sdk.Constants;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.taxis99.R;

public class ManhattanUniPayPresenter extends NonTripUnifiedPaymetPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f44379a;

    /* access modifiers changed from: protected */
    public String getOfflineEnv() {
        return "";
    }

    public ManhattanUniPayPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
        this.f44379a = (Activity) context;
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        super.onPaySuccessed(i, str);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("code", 1);
                bundle.putString("message", ManhattanUniPayPresenter.this.mContext.getString(R.string.oc_pay_success_string));
                intent.putExtras(bundle);
                ManhattanUniPayPresenter.this.f44379a.setResult(-1, intent);
                ManhattanUniPayPresenter.this.f44379a.finish();
            }
        }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
    }

    /* access modifiers changed from: protected */
    public boolean isOnlineEnv() {
        return !UniPayParamUtil.isTestNow();
    }
}
