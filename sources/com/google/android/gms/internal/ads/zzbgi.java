package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbgi implements Runnable {
    private final String zzdkl;
    private final zzbgg zzewq;

    zzbgi(zzbgg zzbgg, String str) {
        this.zzewq = zzbgg;
        this.zzdkl = str;
    }

    public final void run() {
        this.zzewq.zzfo(this.zzdkl);
    }
}
