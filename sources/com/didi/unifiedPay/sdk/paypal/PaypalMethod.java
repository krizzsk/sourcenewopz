package com.didi.unifiedPay.sdk.paypal;

import androidx.fragment.app.FragmentActivity;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.SignObj;
import com.didi.unifiedPay.util.LogUtil;

public class PaypalMethod extends PayMethod {

    /* renamed from: a */
    private static final String f44591a = "PaypalMethod";

    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public boolean supportSign() {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkDataValid(T t) {
        return ((PrepayInfo) t) != null;
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (!super.onPay(prepayInfo)) {
            return false;
        }
        int i = prepayInfo.resultType;
        if (i != 0 && i != 2 && i != 3 && i != 4) {
            return false;
        }
        initPayResultCheckAlarm(prepayInfo);
        return true;
    }

    public void startSignPage(FragmentActivity fragmentActivity, SignObj signObj) {
        super.startSignPage(fragmentActivity, signObj);
        LogUtil.m31685fi(f44591a, "startSignPage");
        if (this.mCallback != null) {
            this.mCallback.startBindPayPal(getPayChannel(), 106);
        }
    }
}
