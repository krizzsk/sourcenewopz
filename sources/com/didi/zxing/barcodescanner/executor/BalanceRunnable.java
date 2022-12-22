package com.didi.zxing.barcodescanner.executor;

import android.os.SystemClock;

public abstract class BalanceRunnable implements Runnable {
    private long executeTime;
    private C14951a executorCallback;

    public void clear() {
    }

    public abstract void execute();

    public final void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        execute();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.executeTime = elapsedRealtime2;
        C14951a aVar = this.executorCallback;
        if (aVar != null) {
            aVar.onFinish(this, elapsedRealtime2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setExecutorCallback(C14951a aVar) {
        this.executorCallback = aVar;
    }
}
