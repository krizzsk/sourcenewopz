package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqn implements Runnable {
    private final /* synthetic */ zzqj zzbnk;
    private final /* synthetic */ int zzbnl;
    private final /* synthetic */ long zzbnm;

    zzqn(zzqj zzqj, int i, long j) {
        this.zzbnk = zzqj;
        this.zzbnl = i;
        this.zzbnm = j;
    }

    public final void run() {
        this.zzbnk.zzbnj.zzg(this.zzbnl, this.zzbnm);
    }
}
