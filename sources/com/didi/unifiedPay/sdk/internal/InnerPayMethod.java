package com.didi.unifiedPay.sdk.internal;

import com.didi.unifiedPay.sdk.model.PrepayInfo;

public class InnerPayMethod extends PayMethod {
    /* access modifiers changed from: protected */
    public <T> boolean checkDataValid(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public int getPayChannel() {
        return 0;
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (!super.onPay(prepayInfo)) {
            return false;
        }
        initPayResultCheckAlarm(prepayInfo);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean passwordCheck(PrepayInfo prepayInfo) {
        return prepayInfo != null && (prepayInfo.pay_channel == 190 || prepayInfo.pay_channel == 150) && prepayInfo.mPasswordModel != null && prepayInfo.resultType == 6;
    }
}
