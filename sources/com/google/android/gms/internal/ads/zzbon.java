package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbon implements Runnable {
    private final AtomicReference zzfxx;

    zzbon(AtomicReference atomicReference) {
        this.zzfxx = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zzfxx.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
