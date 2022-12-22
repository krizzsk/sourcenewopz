package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbjt implements Runnable {
    private final zzbjr zzfsp;
    private final Runnable zzfsq;

    zzbjt(zzbjr zzbjr, Runnable runnable) {
        this.zzfsp = zzbjr;
        this.zzfsq = runnable;
    }

    public final void run() {
        this.zzfsp.zzd(this.zzfsq);
    }
}
