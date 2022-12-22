package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqr implements Runnable {
    private final /* synthetic */ zzjm zzajy;
    private final /* synthetic */ zzqj zzbnk;

    zzqr(zzqj zzqj, zzjm zzjm) {
        this.zzbnk = zzqj;
        this.zzajy = zzjm;
    }

    public final void run() {
        this.zzajy.zzgr();
        this.zzbnk.zzbnj.zzf(this.zzajy);
    }
}
