package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbbp implements Runnable {
    private final int zzehh;
    private final zzbbq zzekx;

    zzbbp(zzbbq zzbbq, int i) {
        this.zzekx = zzbbq;
        this.zzehh = i;
    }

    public final void run() {
        this.zzekx.zzdp(this.zzehh);
    }
}
