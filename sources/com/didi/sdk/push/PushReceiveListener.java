package com.didi.sdk.push;

import com.didi.sdk.push.PushResponse;

public interface PushReceiveListener<T extends PushResponse> {
    void onReceive(T t);
}
