package com.didiglobal.ddmirror.monitor.event;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didiglobal.ddmirror.monitor.PrismMonitor;

public class AppLifecycleObserver implements LifecycleObserver {
    PrismMonitor mPrismMonitor = PrismMonitor.getInstance();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppBackground() {
        if (this.mPrismMonitor.isMonitoring()) {
            this.mPrismMonitor.post(2);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppForeground() {
        if (this.mPrismMonitor.isMonitoring()) {
            this.mPrismMonitor.post(3);
        }
    }
}
