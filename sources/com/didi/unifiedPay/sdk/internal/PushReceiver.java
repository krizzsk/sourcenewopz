package com.didi.unifiedPay.sdk.internal;

import com.didi.unifiedPay.sdk.model.PushMessage;

public interface PushReceiver {
    void onReceive(PushMessage pushMessage);
}
