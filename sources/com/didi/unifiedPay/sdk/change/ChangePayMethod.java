package com.didi.unifiedPay.sdk.change;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;

public class ChangePayMethod extends PayMethod {
    /* renamed from: a */
    private void m31655a() {
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkDataValid(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (!super.onPay(prepayInfo)) {
            return false;
        }
        if (prepayInfo.resultType != -1) {
            return true;
        }
        m31655a();
        return true;
    }

    public void createVerify(FragmentActivity fragmentActivity, IUnipayService iUnipayService, String str, PayServiceCallback<PrepayInfo> payServiceCallback) {
        this.mActivity = fragmentActivity;
        this.mPayService = iUnipayService;
        this.mPrepayCallback = payServiceCallback;
        this.mAppId = str;
        m31655a();
    }

    /* renamed from: a */
    private void m31656a(final int i, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (ChangePayMethod.this.mCallback != null) {
                    ChangePayMethod.this.mCallback.onPayFail(new PayError(i), str);
                }
            }
        });
    }
}
