package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdba implements Runnable {
    private final zzday zzhcf;
    private final zzvh zzhcg;

    zzdba(zzday zzday, zzvh zzvh) {
        this.zzhcf = zzday;
        this.zzhcg = zzvh;
    }

    public final void run() {
        zzday zzday = this.zzhcf;
        zzday.zzhce.zzhca.zzatn().zzd(this.zzhcg);
    }
}
