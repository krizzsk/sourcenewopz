package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdld implements Runnable {
    private final zzczm zzhbu;

    private zzdld(zzczm zzczm) {
        this.zzhbu = zzczm;
    }

    static Runnable zzb(zzczm zzczm) {
        return new zzdld(zzczm);
    }

    public final void run() {
        this.zzhbu.onAdLoaded();
    }
}
