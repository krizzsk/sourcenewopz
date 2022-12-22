package com.didi.beatles.p099im.manager;

import com.didi.beatles.p099im.access.core.IMMessageListener;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.manager.IMMessageListenerManager */
public class IMMessageListenerManager {

    /* renamed from: a */
    private List<IMMessageListener> f9258a;

    private IMMessageListenerManager() {
        this.f9258a = null;
        this.f9258a = new ArrayList();
    }

    public static IMMessageListenerManager getInstance() {
        return ListenerManagerHolder.INSTANCE;
    }

    /* renamed from: com.didi.beatles.im.manager.IMMessageListenerManager$ListenerManagerHolder */
    private static final class ListenerManagerHolder {
        /* access modifiers changed from: private */
        public static final IMMessageListenerManager INSTANCE = new IMMessageListenerManager();

        private ListenerManagerHolder() {
        }
    }

    public void addMessageListener(IMMessageListener iMMessageListener) {
        IMLog.m6630d("[addMessageListener]");
        synchronized (this.f9258a) {
            if (this.f9258a != null && !this.f9258a.contains(iMMessageListener)) {
                this.f9258a.add(iMMessageListener);
            }
        }
    }

    public void removeMessageListener(IMMessageListener iMMessageListener) {
        IMLog.m6630d("[removeMessageListener]");
        synchronized (this.f9258a) {
            if (this.f9258a != null) {
                this.f9258a.remove(iMMessageListener);
            }
        }
    }

    public void notifyListeners() {
        StringBuilder sb = new StringBuilder();
        sb.append("[notifyListeners] listeners=");
        List<IMMessageListener> list = this.f9258a;
        sb.append(list == null ? "0" : Integer.valueOf(list.size()));
        IMLog.m6630d(sb.toString());
        synchronized (this.f9258a) {
            if (this.f9258a != null) {
                for (IMMessageListener iMMessageListener : new ArrayList(this.f9258a)) {
                    if (iMMessageListener != null) {
                        iMMessageListener.onMessageArrive();
                    }
                }
            }
        }
    }

    public void clear() {
        synchronized (this.f9258a) {
            if (this.f9258a != null) {
                this.f9258a.clear();
            }
        }
    }
}
