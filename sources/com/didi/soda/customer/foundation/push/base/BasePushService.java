package com.didi.soda.customer.foundation.push.base;

import android.content.Context;
import com.didi.foundation.sdk.push.LogListener;
import com.didi.foundation.sdk.push.PushMessageReceiver;
import com.didi.foundation.sdk.push.PushParam;
import com.didi.foundation.sdk.push.PushService;

public final class BasePushService {
    public void init(Context context, PushParam pushParam, LogListener logListener) {
        PushService.getInstance().init(context, pushParam, logListener);
    }

    public void registerReceiver(PushMessageReceiver pushMessageReceiver) {
        PushService.getInstance().registerMessageReceiver(pushMessageReceiver);
    }

    public void unregisterReceiver(PushMessageReceiver pushMessageReceiver) {
        PushService.getInstance().unRegisterMessageReceiver(pushMessageReceiver);
    }

    public void uploadPushParam(Context context, PushParam pushParam) {
        PushService.getInstance().uploadPushParam(context, pushParam);
    }
}
