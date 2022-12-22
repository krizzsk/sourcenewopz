package com.didi.sdk.component.protocol;

import android.content.Context;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;

public interface IPushComponent {
    void dispatcherPush(String str, DPushBody dPushBody);

    void dispatcherPush(String str, DPushBody dPushBody, String str2);

    void initPush(Context context);

    void initPushConfig(Context context);

    void registerPush(DPushListener dPushListener);

    void startPush();

    void stopPush();

    boolean unregisterPush(DPushListener dPushListener);
}
