package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcdi implements Runnable {
    private final zzcdf zzgfn;
    private final zzcfl zzggf;

    zzcdi(zzcdf zzcdf, zzcfl zzcfl) {
        this.zzgfn = zzcdf;
        this.zzggf = zzcfl;
    }

    public final void run() {
        this.zzgfn.zze(this.zzggf);
    }
}
