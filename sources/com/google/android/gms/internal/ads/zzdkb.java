package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdkb implements Runnable {
    private final zzvh zzhcg;
    private final zzdkc zzhip;

    zzdkb(zzdkc zzdkc, zzvh zzvh) {
        this.zzhip = zzdkc;
        this.zzhcg = zzvh;
    }

    public final void run() {
        zzdkc zzdkc = this.zzhip;
        zzdkc.zzhir.zzhil.zzd(this.zzhcg);
    }
}
