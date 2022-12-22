package com.didi.sdk.push.manager;

public interface DPushListener {
    void pushBody(DPushBody dPushBody);

    DPushType pushType();

    String topic();
}
