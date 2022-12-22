package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbey implements Runnable {
    private final boolean zzemp;
    private final long zzepu;
    private final zzbcs zzerd;

    zzbey(zzbcs zzbcs, boolean z, long j) {
        this.zzerd = zzbcs;
        this.zzemp = z;
        this.zzepu = j;
    }

    public final void run() {
        this.zzerd.zza(this.zzemp, this.zzepu);
    }
}
