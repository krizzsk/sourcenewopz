package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzql implements Runnable {
    private final /* synthetic */ String zzajo;
    private final /* synthetic */ long zzajp;
    private final /* synthetic */ long zzajq;
    private final /* synthetic */ zzqj zzbnk;

    zzql(zzqj zzqj, String str, long j, long j2) {
        this.zzbnk = zzqj;
        this.zzajo = str;
        this.zzajp = j;
        this.zzajq = j2;
    }

    public final void run() {
        this.zzbnk.zzbnj.zzd(this.zzajo, this.zzajp, this.zzajq);
    }
}
