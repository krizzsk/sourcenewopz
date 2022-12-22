package com.didi.sdk.push;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PushLifecycleManager {
    private final List<PushLifecycleCallback> lifecycleCallbacks;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static PushLifecycleManager INSTANCE = new PushLifecycleManager();

        private SingletonHolder() {
        }
    }

    public static PushLifecycleManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private PushLifecycleManager() {
        this.lifecycleCallbacks = new ArrayList();
        Iterator<S> it = ServiceLoader.load(PushLifecycleCallback.class).iterator();
        while (it.hasNext()) {
            PushLifecycleCallback pushLifecycleCallback = (PushLifecycleCallback) it.next();
            if (pushLifecycleCallback != null) {
                registerLifecycleCallback(pushLifecycleCallback);
            }
        }
    }

    public void registerLifecycleCallback(PushLifecycleCallback pushLifecycleCallback) {
        synchronized (this.lifecycleCallbacks) {
            this.lifecycleCallbacks.add(pushLifecycleCallback);
        }
    }

    public void unregisterLifecycleCallback(PushLifecycleCallback pushLifecycleCallback) {
        synchronized (this.lifecycleCallbacks) {
            this.lifecycleCallbacks.remove(pushLifecycleCallback);
        }
    }

    public void onConnect(int i, int i2) {
        ArrayList<PushLifecycleCallback> arrayList;
        synchronized (this.lifecycleCallbacks) {
            arrayList = new ArrayList<>(this.lifecycleCallbacks);
        }
        for (PushLifecycleCallback onConnect : arrayList) {
            onConnect.onConnect(i, i2);
        }
    }

    public void onDisconnect(int i, int i2) {
        ArrayList<PushLifecycleCallback> arrayList;
        synchronized (this.lifecycleCallbacks) {
            arrayList = new ArrayList<>(this.lifecycleCallbacks);
        }
        for (PushLifecycleCallback onDisConnect : arrayList) {
            onDisConnect.onDisConnect(i, i2);
        }
    }
}
