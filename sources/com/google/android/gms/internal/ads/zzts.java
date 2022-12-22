package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzts implements Runnable {
    private final zzbbe zzbwk;
    private final Future zzbwl;

    zzts(zzbbe zzbbe, Future future) {
        this.zzbwk = zzbbe;
        this.zzbwl = future;
    }

    public final void run() {
        zzbbe zzbbe = this.zzbwk;
        Future future = this.zzbwl;
        if (zzbbe.isCancelled()) {
            future.cancel(true);
        }
    }
}
