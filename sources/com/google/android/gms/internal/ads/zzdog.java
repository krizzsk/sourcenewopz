package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdog implements Runnable {
    private final zzvh zzhcg;
    private final zzdoe zzhlp;

    zzdog(zzdoe zzdoe, zzvh zzvh) {
        this.zzhlp = zzdoe;
        this.zzhcg = zzvh;
    }

    public final void run() {
        zzdoe zzdoe = this.zzhlp;
        zzdoe.zzhlo.zzhlj.zzd(this.zzhcg);
    }
}
