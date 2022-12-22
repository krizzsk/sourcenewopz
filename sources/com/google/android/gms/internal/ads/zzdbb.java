package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdbb implements Runnable {
    private final zzday zzhcf;

    zzdbb(zzday zzday) {
        this.zzhcf = zzday;
    }

    public final void run() {
        this.zzhcf.zzhce.zzhca.zzatm().onAdLoaded();
    }
}
