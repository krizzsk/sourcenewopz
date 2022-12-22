package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbdd implements Runnable {
    private final int zzehh;
    private final int zzehi;
    private final zzbcv zzepq;

    zzbdd(zzbcv zzbcv, int i, int i2) {
        this.zzepq = zzbcv;
        this.zzehh = i;
        this.zzehi = i2;
    }

    public final void run() {
        this.zzepq.zzr(this.zzehh, this.zzehi);
    }
}
