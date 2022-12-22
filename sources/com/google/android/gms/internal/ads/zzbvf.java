package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbvf implements Runnable {
    private final WeakReference<zzbve> zzgby;

    private zzbvf(zzbve zzbve) {
        this.zzgby = new WeakReference<>(zzbve);
    }

    public final void run() {
        zzbve zzbve = (zzbve) this.zzgby.get();
        if (zzbve != null) {
            zzbve.zzamn();
        }
    }
}
