package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzdxi;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbl {
    private Handler handler = null;
    private final Object lock = new Object();
    private HandlerThread zzeiq = null;
    private int zzeir = 0;

    public final Looper zzaai() {
        Looper looper;
        synchronized (this.lock) {
            if (this.zzeir != 0) {
                Preconditions.checkNotNull(this.zzeiq, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzeiq == null) {
                zzd.zzed("Starting the looper thread.");
                HandlerThread handlerThread = new HandlerThread("LooperProvider");
                this.zzeiq = handlerThread;
                handlerThread.start();
                this.handler = new zzdxi(this.zzeiq.getLooper());
                zzd.zzed("Looper thread started.");
            } else {
                zzd.zzed("Resuming the looper thread");
                this.lock.notifyAll();
            }
            this.zzeir++;
            looper = this.zzeiq.getLooper();
        }
        return looper;
    }

    public final Handler getHandler() {
        return this.handler;
    }
}
