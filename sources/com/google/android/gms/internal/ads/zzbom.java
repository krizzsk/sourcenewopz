package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbom implements Runnable {
    private final Runnable zzfsq;
    private final zzbok zzfxw;

    zzbom(zzbok zzbok, Runnable runnable) {
        this.zzfxw = zzbok;
        this.zzfsq = runnable;
    }

    public final void run() {
        this.zzfxw.zze(this.zzfsq);
    }
}
