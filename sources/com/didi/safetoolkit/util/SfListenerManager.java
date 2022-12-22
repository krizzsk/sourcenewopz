package com.didi.safetoolkit.util;

import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;

public class SfListenerManager {

    /* renamed from: a */
    private static MonitorDataUpdateListener f34536a;

    public interface MonitorDataUpdateListener {
        void monitorUpdate(SfViewMonitorMenuModel sfViewMonitorMenuModel);
    }

    public static void setMonitorUpdateListener(MonitorDataUpdateListener monitorDataUpdateListener) {
        f34536a = monitorDataUpdateListener;
    }

    public static MonitorDataUpdateListener getMonitorUpdateListener() {
        return f34536a;
    }

    public static void removeMonitorUpdateListener() {
        f34536a = null;
    }
}
