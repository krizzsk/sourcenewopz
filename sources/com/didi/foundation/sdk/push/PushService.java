package com.didi.foundation.sdk.push;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;

public final class PushService implements PushServiceProvider {

    /* renamed from: a */
    private final PushServiceProvider f21292a;

    private PushService() {
        this.f21292a = (PushServiceProvider) ServiceLoader.load(PushServiceProvider.class).get();
    }

    public static final PushService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void init(Context context, PushParam pushParam, LogListener logListener) {
        PushServiceProvider pushServiceProvider = this.f21292a;
        if (pushServiceProvider != null) {
            pushServiceProvider.init(context, pushParam, logListener);
        }
    }

    public final void uploadPushParam(Context context, PushParam pushParam) {
        PushServiceProvider pushServiceProvider = this.f21292a;
        if (pushServiceProvider != null) {
            pushServiceProvider.uploadPushParam(context, pushParam);
        }
    }

    public final void registerMessageReceiver(PushMessageReceiver pushMessageReceiver) {
        PushServiceProvider pushServiceProvider = this.f21292a;
        if (pushServiceProvider != null) {
            pushServiceProvider.registerMessageReceiver(pushMessageReceiver);
        }
    }

    public final void unRegisterMessageReceiver(PushMessageReceiver pushMessageReceiver) {
        PushServiceProvider pushServiceProvider = this.f21292a;
        if (pushServiceProvider != null) {
            pushServiceProvider.unRegisterMessageReceiver(pushMessageReceiver);
        }
    }

    public final void release() {
        PushServiceProvider pushServiceProvider = this.f21292a;
        if (pushServiceProvider != null) {
            pushServiceProvider.release();
        }
    }

    public final int getPushType() {
        PushServiceProvider pushServiceProvider = this.f21292a;
        if (pushServiceProvider != null) {
            return pushServiceProvider.getPushType();
        }
        return 0;
    }

    private static final class Singleton {
        static final PushService INSTANCE = new PushService();

        private Singleton() {
        }
    }
}
