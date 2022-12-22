package com.didi.unifiedPay.sdk.pix;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.model.PrepayInfo;

public class PixPayMethod extends PayMethod {
    /* access modifiers changed from: protected */
    public <T> boolean checkDataValid(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (prepayInfo != null && !TextUtils.isEmpty(prepayInfo.pixCode) && this.mCallback != null) {
            this.mCallback.onNewPixCode(prepayInfo.pixCode);
            SystemUtils.log(4, "Arirus PayMethod", "onPay: ", (Throwable) null, "com.didi.unifiedPay.sdk.pix.PixPayMethod", 26);
            return false;
        } else if (!super.onPay(prepayInfo)) {
            return false;
        } else {
            initPayResultCheckAlarm(prepayInfo);
            return true;
        }
    }
}
