package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzn implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzj zzegw;

    zzn(zzj zzj, Context context) {
        this.zzegw = zzj;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzegw.zzegr) {
            String unused = this.zzegw.zzbjd = zzj.zzap(this.val$context);
            this.zzegw.zzegr.notifyAll();
        }
    }
}
