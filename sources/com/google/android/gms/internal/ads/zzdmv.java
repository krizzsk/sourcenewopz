package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdmv implements Runnable {
    private final zzdmt zzhkz;

    zzdmv(zzdmt zzdmt) {
        this.zzhkz = zzdmt;
    }

    public final void run() {
        this.zzhkz.zzhkx.zzhkv.onAdLoaded();
    }
}
