package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdmx implements Runnable {
    private final zzvh zzhcg;
    private final zzdmt zzhkz;

    zzdmx(zzdmt zzdmt, zzvh zzvh) {
        this.zzhkz = zzdmt;
        this.zzhcg = zzvh;
    }

    public final void run() {
        zzdmt zzdmt = this.zzhkz;
        zzdmt.zzhkx.zzhkv.zzd(this.zzhcg);
    }
}
