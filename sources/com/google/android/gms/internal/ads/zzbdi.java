package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbdi implements Runnable {
    private final boolean zzemp;
    private final zzbcv zzepq;
    private final long zzepu;

    zzbdi(zzbcv zzbcv, boolean z, long j) {
        this.zzepq = zzbcv;
        this.zzemp = z;
        this.zzepu = j;
    }

    public final void run() {
        this.zzepq.zzc(this.zzemp, this.zzepu);
    }
}
