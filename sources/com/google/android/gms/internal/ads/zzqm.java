package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqm implements Runnable {
    private final /* synthetic */ zzjm zzajs;
    private final /* synthetic */ zzqj zzbnk;

    zzqm(zzqj zzqj, zzjm zzjm) {
        this.zzbnk = zzqj;
        this.zzajs = zzjm;
    }

    public final void run() {
        this.zzbnk.zzbnj.zze(this.zzajs);
    }
}
