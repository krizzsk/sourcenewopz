package com.didi.unifiedPay.sdk.paypay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.model.PayPayModel;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.util.DeviceUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;

public class PaypayPayMethod<T extends PrepayInfo> extends PayMethod {
    public static final String PAYPAYPOLLACTION = "com.xiaojukeji.action.paypayPollAction";

    /* renamed from: a */
    private static WeakReference<FragmentActivity> f44592a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BroadcastReceiver f44593b = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            LocalBroadcastManager.getInstance(PaypayPayMethod.this.mActivity).unregisterReceiver(PaypayPayMethod.this.f44593b);
            if (intent.getExtras() != null && intent.getExtras().getInt("code", 0) == 1) {
                PaypayPayMethod.this.initPayResultCheckAlarm((PrepayInfo) null);
            }
        }
    };

    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkDataValid(T t) {
        PrepayInfo prepayInfo = (PrepayInfo) t;
        return (prepayInfo == null || prepayInfo.paypayParams == null) ? false : true;
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (!super.onPay(prepayInfo)) {
            return false;
        }
        PayPayModel payPayModel = prepayInfo.paypayParams;
        if (TextUtils.isEmpty(payPayModel.appPayString)) {
            initPayResultCheckAlarm(prepayInfo);
            return true;
        } else if (DeviceUtil.isSchemeSupport(this.mActivity, payPayModel.appPayString)) {
            try {
                f44592a = new WeakReference<>(this.mActivity);
                LocalBroadcastManager.getInstance(this.mActivity).registerReceiver(this.f44593b, new IntentFilter("com.xiaojukeji.action.paypayPollAction"));
                Intent intent = new Intent();
                intent.setData(Uri.parse(URLDecoder.decode(payPayModel.appPayString)));
                intent.setAction("android.intent.action.VIEW");
                this.mActivity.startActivity(intent);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        PaypayPayMethod.this.mCallback.onPayFail(new PayError(7), PaypayPayMethod.this.mActivity.getString(R.string.oc_uni_pay_result_unknown));
                    }
                }, 1000);
                return true;
            } catch (Exception e) {
                LogUtil.m31684d("PaypayPayMethod", e.toString());
                this.mCallback.onPayFail(new PayError(2), this.mActivity.getString(R.string.oc_uni_pay_not_support));
                return true;
            }
        } else {
            this.mCallback.onPayFail(new PayError(2), this.mActivity.getString(R.string.oc_uni_pay_not_support));
            return true;
        }
    }

    public static Activity getActivity() {
        WeakReference<FragmentActivity> weakReference = f44592a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }
}
