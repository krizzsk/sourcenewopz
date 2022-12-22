package com.didi.universal.pay.sdk.method.internal;

import com.didi.universal.pay.sdk.net.model.Error;

public interface PayServiceCallback<T> {
    void onFail(Error error);

    void onSuccess(T t);
}
