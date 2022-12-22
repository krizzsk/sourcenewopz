package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzir implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ zzjm zzajy;

    zzir(zzik zzik, zzjm zzjm) {
        this.zzajr = zzik;
        this.zzajy = zzjm;
    }

    public final void run() {
        this.zzajy.zzgr();
        this.zzajr.zzajn.zzd(this.zzajy);
    }
}
