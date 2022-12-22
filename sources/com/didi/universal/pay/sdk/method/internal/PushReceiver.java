package com.didi.universal.pay.sdk.method.internal;

import com.didi.universal.pay.sdk.method.model.PushMessage;

public interface PushReceiver {
    void onReceive(PushMessage pushMessage);
}
