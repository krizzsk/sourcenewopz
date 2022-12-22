package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzio implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ int zzajt;
    private final /* synthetic */ long zzaju;
    private final /* synthetic */ long zzajv;

    zzio(zzik zzik, int i, long j, long j2) {
        this.zzajr = zzik;
        this.zzajt = i;
        this.zzaju = j;
        this.zzajv = j2;
    }

    public final void run() {
        this.zzajr.zzajn.zzb(this.zzajt, this.zzaju, this.zzajv);
    }
}
