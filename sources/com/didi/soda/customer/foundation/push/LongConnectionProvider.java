package com.didi.soda.customer.foundation.push;

import android.content.Context;
import com.didi.foundation.sdk.liveconnection.ConnectionListener;
import com.didi.foundation.sdk.liveconnection.LogListener;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Option;
import com.didi.foundation.sdk.liveconnection.Request;
import com.didi.soda.customer.foundation.push.base.BaseLongConnectionService;

public final class LongConnectionProvider {
    public static final int COMMON_TOPIC = 3793;
    public static final int OUTER_TOPIC = 601;
    public static final int PAY_TOPIC = 2304;

    /* renamed from: a */
    private BaseLongConnectionService f40953a;

    private LongConnectionProvider() {
        this.f40953a = new BaseLongConnectionService();
    }

    public static LongConnectionProvider getInstance() {
        return Holder.PROVIDER;
    }

    public void init(Context context, Option option) {
        this.f40953a.init(context, option);
    }

    public boolean isConnected() {
        return this.f40953a.isConnected();
    }

    public void registerConnectListener(ConnectionListener connectionListener) {
        this.f40953a.registerConnectListener(connectionListener);
    }

    public void registerMessageListener(MessageListener messageListener) {
        this.f40953a.registerMessageListener(messageListener);
    }

    public void release() {
        this.f40953a.release();
    }

    public void sendRequest(Request request) {
        this.f40953a.sendRequest(request);
    }

    public void setLogListener(LogListener logListener) {
        this.f40953a.setLogListener(logListener);
    }

    public void startConnect() {
        this.f40953a.startConnect();
    }

    public void stopConnect() {
        this.f40953a.stopConnect();
    }

    public void unRegisterMessageListener(MessageListener messageListener) {
        this.f40953a.unRegisterMessageListener(messageListener);
    }

    public void unregisterConnectionListener(ConnectionListener connectionListener) {
        this.f40953a.unregisterConnectionListener(connectionListener);
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final LongConnectionProvider PROVIDER = new LongConnectionProvider();

        private Holder() {
        }
    }
}
