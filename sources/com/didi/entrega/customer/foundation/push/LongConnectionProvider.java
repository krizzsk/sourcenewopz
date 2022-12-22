package com.didi.entrega.customer.foundation.push;

import android.content.Context;
import com.didi.entrega.customer.foundation.push.base.BaseLongConnectionService;
import com.didi.foundation.sdk.liveconnection.ConnectionListener;
import com.didi.foundation.sdk.liveconnection.LogListener;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Option;
import com.didi.foundation.sdk.liveconnection.Request;

public final class LongConnectionProvider {
    public static final int COMMON_TOPIC = 3794;
    public static final int OUTER_TOPIC = 601;
    public static final int PAY_TOPIC = 2304;

    /* renamed from: a */
    private BaseLongConnectionService f19944a;

    private LongConnectionProvider() {
        this.f19944a = new BaseLongConnectionService();
    }

    public static LongConnectionProvider getInstance() {
        return Holder.PROVIDER;
    }

    public void init(Context context, Option option) {
        this.f19944a.init(context, option);
    }

    public boolean isConnected() {
        return this.f19944a.isConnected();
    }

    public void registerConnectListener(ConnectionListener connectionListener) {
        this.f19944a.registerConnectListener(connectionListener);
    }

    public void registerMessageListener(MessageListener messageListener) {
        this.f19944a.registerMessageListener(messageListener);
    }

    public void release() {
        this.f19944a.release();
    }

    public void sendRequest(Request request) {
        this.f19944a.sendRequest(request);
    }

    public void setLogListener(LogListener logListener) {
        this.f19944a.setLogListener(logListener);
    }

    public void startConnect() {
        this.f19944a.startConnect();
    }

    public void stopConnect() {
        this.f19944a.stopConnect();
    }

    public void unRegisterMessageListener(MessageListener messageListener) {
        this.f19944a.unRegisterMessageListener(messageListener);
    }

    public void unregisterConnectionListener(ConnectionListener connectionListener) {
        this.f19944a.unregisterConnectionListener(connectionListener);
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final LongConnectionProvider PROVIDER = new LongConnectionProvider();

        private Holder() {
        }
    }
}
