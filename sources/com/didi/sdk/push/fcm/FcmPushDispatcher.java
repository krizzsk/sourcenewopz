package com.didi.sdk.push.fcm;

import com.didi.sdk.push.manager.DPushBody;
import java.util.ArrayList;
import java.util.List;

public class FcmPushDispatcher {
    private static volatile FcmPushDispatcher instance;
    private List<FcmPushListener> listeners = new ArrayList();

    public interface FcmPushListener {
        void onMessageReceived(DPushBody dPushBody);
    }

    private FcmPushDispatcher() {
    }

    public static FcmPushDispatcher getInstance() {
        if (instance == null) {
            synchronized (FcmPushDispatcher.class) {
                if (instance == null) {
                    instance = new FcmPushDispatcher();
                }
            }
        }
        return instance;
    }

    public void dispatchMessages(DPushBody dPushBody) {
        for (FcmPushListener next : this.listeners) {
            if (next != null) {
                next.onMessageReceived(dPushBody);
            }
        }
    }

    public void addListener(FcmPushListener fcmPushListener) {
        if (fcmPushListener != null) {
            this.listeners.add(fcmPushListener);
        }
    }

    public void removeListener(FcmPushListener fcmPushListener) {
        if (fcmPushListener != null) {
            this.listeners.remove(fcmPushListener);
        }
    }

    public void clearListeners() {
        this.listeners.clear();
    }

    public List<FcmPushListener> getListeners() {
        return this.listeners;
    }
}
