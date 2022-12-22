package com.didichuxing.omega.sdk.leak;

import com.didichuxing.alpha.lag.HandlerThreadFactory;

public class LeakWatcherWrapper {
    private LeakWatcher mWatcher;

    public static LeakWatcherWrapper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        static final LeakWatcherWrapper INSTANCE = new LeakWatcherWrapper();

        private InstanceHolder() {
        }
    }

    private LeakWatcherWrapper() {
        this.mWatcher = new LeakWatcher(HandlerThreadFactory.getTimerThreadHandler(), new GCTrigger());
    }

    public void watch(Object obj) {
        LeakWatcher leakWatcher = this.mWatcher;
        if (leakWatcher != null) {
            leakWatcher.watch(obj);
        }
    }

    public void watch(Object obj, String str) {
        LeakWatcher leakWatcher = this.mWatcher;
        if (leakWatcher != null) {
            leakWatcher.watch(obj, str);
        }
    }
}
