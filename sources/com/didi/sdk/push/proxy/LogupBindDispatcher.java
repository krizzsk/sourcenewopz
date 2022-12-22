package com.didi.sdk.push.proxy;

import android.content.Context;
import android.net.Uri;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LogupBindDispatcher {
    private final List<LogupBindListener> bindListeners;

    private LogupBindDispatcher() {
        this.bindListeners = new ArrayList();
        Iterator<S> it = ServiceLoader.load(LogupBindListener.class).iterator();
        while (it.hasNext()) {
            LogupBindListener logupBindListener = (LogupBindListener) it.next();
            if (logupBindListener != null) {
                this.bindListeners.add(logupBindListener);
            }
        }
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static LogupBindDispatcher INSTANCE = new LogupBindDispatcher();

        private SingletonHolder() {
        }
    }

    static LogupBindDispatcher getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public void registerBindListener(LogupBindListener logupBindListener) {
        if (logupBindListener != null) {
            synchronized (this.bindListeners) {
                this.bindListeners.add(logupBindListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unregisterBindListener(LogupBindListener logupBindListener) {
        if (logupBindListener != null) {
            synchronized (this.bindListeners) {
                this.bindListeners.remove(logupBindListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyBind(Context context, Uri uri) {
        ArrayList<LogupBindListener> arrayList;
        synchronized (this.bindListeners) {
            arrayList = new ArrayList<>(this.bindListeners);
        }
        for (LogupBindListener onBind : arrayList) {
            onBind.onBind(context, uri);
        }
    }
}
