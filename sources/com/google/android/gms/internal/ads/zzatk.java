package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzatk implements Runnable {
    private final String zzdkl;
    private final zzbas zzdvd;

    zzatk(zzbas zzbas, String str) {
        this.zzdvd = zzbas;
        this.zzdkl = str;
    }

    public final void run() {
        this.zzdvd.zzen(this.zzdkl);
    }
}
