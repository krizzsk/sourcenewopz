package com.didi.unifiedPay.sdk.internal;

import com.didi.unifiedPay.sdk.net.Error;

public interface PayServiceCallback<T> {
    void onFail(Error error);

    void onSuccess(T t);
}
