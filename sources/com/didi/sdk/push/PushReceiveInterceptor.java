package com.didi.sdk.push;

import com.didi.sdk.push.PushResponse;

public interface PushReceiveInterceptor<T extends PushResponse> {
    T intercept(T t);
}
