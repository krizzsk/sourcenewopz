package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcdl implements Runnable {
    private final boolean zzemp;
    private final zzcdf zzgfn;

    zzcdl(zzcdf zzcdf, boolean z) {
        this.zzgfn = zzcdf;
        this.zzemp = z;
    }

    public final void run() {
        this.zzgfn.zzbl(this.zzemp);
    }
}
