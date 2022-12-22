package com.didi.universal.pay.sdk.method.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;
import com.didi.universal.pay.sdk.model.ThirdPayResult;
import com.didi.universal.pay.sdk.util.LogUtil;
import java.io.Serializable;

public abstract class PayMethod implements Serializable {
    public static final int REQUEST_CODE_BANK_PAY = 104;
    public static final int REQUEST_CODE_BIND_PAYPAL = 106;
    public static final int REQUEST_CODE_BIND_VISA_CARD = 100;
    public static final int REQUEST_CODE_SIGN_DDCREDIT = 102;
    public static final int REQUEST_CODE_SIGN_ZFT = 103;
    private static final String TAG = "PayMethod";
    protected String mAppId = "";
    /* access modifiers changed from: protected */
    public PayMethodCallback mCallBack;
    /* access modifiers changed from: protected */
    public Context mContext;

    public interface PayMethodCallback {
        void doSign();

        void onComplete();

        void onError(int i, String str);

        void onPayResult(ThirdPayResult thirdPayResult);

        void onStart();

        void prepay(String str);

        void startActivityForResult(Intent intent, int i);

        void startPoll();
    }

    public abstract <T> boolean checkDataValid(T t);

    public abstract <T> boolean checkPaySupport(T t);

    public abstract void dopay(PrepayInfo prepayInfo);

    public abstract int getChannelID();

    public abstract int getRequestCodeForSign();

    public boolean supportSign() {
        return false;
    }

    public PayMethod(Context context) {
        this.mContext = context;
    }

    public void setCallbackListener(PayMethodCallback payMethodCallback) {
        this.mCallBack = payMethodCallback;
    }

    public void removeListener() {
        LogUtil.m32410fi(TAG, "removeListener");
        this.mCallBack = null;
        UnifiedPayCallback.getInstance().unRegisterAllPayCallback();
    }

    public String getAppId() {
        return this.mAppId;
    }

    /* access modifiers changed from: protected */
    public void postPayResult(final ThirdPayResult thirdPayResult) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (PayMethod.this.mCallBack != null) {
                    PayMethod.this.mCallBack.onPayResult(thirdPayResult);
                }
            }
        });
    }
}
