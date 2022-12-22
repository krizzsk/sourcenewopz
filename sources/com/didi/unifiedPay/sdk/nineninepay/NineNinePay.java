package com.didi.unifiedPay.sdk.nineninepay;

import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.model.PrepayInfo;

public class NineNinePay extends PayMethod {
    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
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

    /* access modifiers changed from: protected */
    public boolean passwordCheck(PrepayInfo prepayInfo) {
        return (prepayInfo == null || prepayInfo.mPasswordModel == null || prepayInfo.resultType != 6) ? false : true;
    }
}
