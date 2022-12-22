package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbcd implements Runnable {
    private final zzbcb zzemo;
    private final boolean zzemp;

    zzbcd(zzbcb zzbcb, boolean z) {
        this.zzemo = zzbcb;
        this.zzemp = z;
    }

    public final void run() {
        this.zzemo.zzay(this.zzemp);
    }
}
