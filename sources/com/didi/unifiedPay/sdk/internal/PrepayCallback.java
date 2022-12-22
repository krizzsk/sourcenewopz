package com.didi.unifiedPay.sdk.internal;

public interface PrepayCallback {
    void onFailure(Object obj, Throwable th);

    void onSuccess(Object obj, Object obj2);
}
