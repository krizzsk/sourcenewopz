package com.didi.map.sdk.degrade;

import com.didi.map.sdk.navtracker.log.DLog;

public class CrashMonitorImplV2 implements ICrashMonitor {

    /* renamed from: a */
    private static volatile boolean f28088a = false;

    public void start(ICrashListener iCrashListener) {
        if (f28088a) {
            DLog.m20199d("ccc", "crash monitor v2 already init", new Object[0]);
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new DegradeUncaughtExceptionHandler(iCrashListener));
        f28088a = true;
        DLog.m20199d("ccc", "degrade handler is ready", new Object[0]);
    }
}
