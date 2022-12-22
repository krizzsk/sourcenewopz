package com.didi.foundation.sdk.liveconnection;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;

public final class LiveConnectionService implements LiveConnectionServiceProvider {

    /* renamed from: a */
    private final LiveConnectionServiceProvider f21182a;

    private LiveConnectionService() {
        this.f21182a = (LiveConnectionServiceProvider) ServiceLoader.load(LiveConnectionServiceProvider.class).get();
    }

    public static final LiveConnectionService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void config(Context context, Option option) {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.config(context, option);
        }
    }

    public final void start() {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.start();
        }
    }

    public final void stop() {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.stop();
        }
    }

    public final void release() {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.release();
        }
    }

    public final boolean isConnected() {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        return liveConnectionServiceProvider != null && liveConnectionServiceProvider.isConnected();
    }

    public final void registerConnectionListener(ConnectionListener connectionListener) {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.registerConnectionListener(connectionListener);
        }
    }

    public final void unRegisterConnectionListener(ConnectionListener connectionListener) {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.unRegisterConnectionListener(connectionListener);
        }
    }

    public final void removeAllConnectionListener() {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.removeAllConnectionListener();
        }
    }

    public final void registerMessageListener(MessageListener messageListener) {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.registerMessageListener(messageListener);
        }
    }

    public final void unRegisterMessageListener(MessageListener messageListener) {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.unRegisterMessageListener(messageListener);
        }
    }

    public final void removeAllMessageListener() {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.removeAllMessageListener();
        }
    }

    public final void sendRequest(Request request) {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.sendRequest(request);
        }
    }

    public final void setLogListener(LogListener logListener) {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            liveConnectionServiceProvider.setLogListener(logListener);
        }
    }

    public final LogListener getLogListener() {
        LiveConnectionServiceProvider liveConnectionServiceProvider = this.f21182a;
        if (liveConnectionServiceProvider != null) {
            return liveConnectionServiceProvider.getLogListener();
        }
        return null;
    }

    private static final class Singleton {
        static final LiveConnectionService INSTANCE = new LiveConnectionService();

        private Singleton() {
        }
    }
}
