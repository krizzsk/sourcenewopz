package com.didi.foundation.sdk.push;

import android.content.Context;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface PushServiceProvider {
    int getPushType();

    void init(Context context, PushParam pushParam, LogListener logListener);

    void registerMessageReceiver(PushMessageReceiver pushMessageReceiver);

    void release();

    void unRegisterMessageReceiver(PushMessageReceiver pushMessageReceiver);

    void uploadPushParam(Context context, PushParam pushParam);
}
