package com.didi.sdk.push;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PushConnectionDispatcher {
    private final List<PushConnectionListener> connectionListeners;

    private PushConnectionDispatcher() {
        this.connectionListeners = new ArrayList();
        Iterator<S> it = ServiceLoader.load(PushConnectionListener.class).iterator();
        while (it.hasNext()) {
            PushConnectionListener pushConnectionListener = (PushConnectionListener) it.next();
            if (pushConnectionListener != null) {
                this.connectionListeners.add(pushConnectionListener);
            }
        }
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static PushConnectionDispatcher INSTANCE = new PushConnectionDispatcher();

        private SingletonHolder() {
        }
    }

    public static PushConnectionDispatcher getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void registerConnectionListener(PushConnectionListener pushConnectionListener) {
        if (pushConnectionListener != null) {
            synchronized (this.connectionListeners) {
                this.connectionListeners.add(pushConnectionListener);
            }
        }
    }

    public void unregisterConnectionListener(PushConnectionListener pushConnectionListener) {
        if (pushConnectionListener != null) {
            synchronized (this.connectionListeners) {
                this.connectionListeners.remove(pushConnectionListener);
            }
        }
    }

    public void notifyConnection(PushConnResult pushConnResult) {
        ArrayList<PushConnectionListener> arrayList;
        synchronized (this.connectionListeners) {
            arrayList = new ArrayList<>(this.connectionListeners);
        }
        for (PushConnectionListener onConnection : arrayList) {
            onConnection.onConnection(pushConnResult);
        }
    }
}
