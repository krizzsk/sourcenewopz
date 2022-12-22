package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdod implements Runnable {
    private final zzdnb zzhlm;

    private zzdod(zzdnb zzdnb) {
        this.zzhlm = zzdnb;
    }

    static Runnable zzb(zzdnb zzdnb) {
        return new zzdod(zzdnb);
    }

    public final void run() {
        this.zzhlm.onAdLoaded();
    }
}
