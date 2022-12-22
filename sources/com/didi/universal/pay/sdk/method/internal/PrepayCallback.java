package com.didi.universal.pay.sdk.method.internal;

public interface PrepayCallback {
    void onFailure(Object obj, Throwable th);

    void onSuccess(Object obj, Object obj2);
}
