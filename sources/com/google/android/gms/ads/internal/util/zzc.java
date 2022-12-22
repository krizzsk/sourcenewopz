package com.google.android.gms.ads.internal.util;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzc implements Runnable {
    private final /* synthetic */ zza zzeft;

    zzc(zza zza) {
        this.zzeft = zza;
    }

    public final void run() {
        Thread unused = this.zzeft.thread = Thread.currentThread();
        this.zzeft.zzwp();
    }
}
