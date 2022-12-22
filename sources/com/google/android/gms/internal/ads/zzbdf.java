package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbdf implements Runnable {
    private final int zzehh;
    private final zzbcv zzepq;

    zzbdf(zzbcv zzbcv, int i) {
        this.zzepq = zzbcv;
        this.zzehh = i;
    }

    public final void run() {
        this.zzepq.zzdz(this.zzehh);
    }
}
