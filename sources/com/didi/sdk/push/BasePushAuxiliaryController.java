package com.didi.sdk.push;

import java.util.concurrent.atomic.AtomicBoolean;

public class BasePushAuxiliaryController implements PushConnectionListener {
    private static final String TAG = "BasePushAuxiliaryController";
    private AtomicBoolean isStart = new AtomicBoolean(false);

    /* access modifiers changed from: package-private */
    public void start() {
        if (this.isStart.compareAndSet(false, true)) {
            PushLog.m26280d(TAG, "called");
            new PushConnectDetector().startCheck();
            new PushDnsRefresh().start();
        }
    }

    public void onConnection(PushConnResult pushConnResult) {
        if (pushConnResult.getRetCode() == 0) {
            start();
        }
    }
}
