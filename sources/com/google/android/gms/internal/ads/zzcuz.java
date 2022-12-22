package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcuz implements Runnable {
    private final zzcjq zzgvr;

    private zzcuz(zzcjq zzcjq) {
        this.zzgvr = zzcjq;
    }

    static Runnable zza(zzcjq zzcjq) {
        return new zzcuz(zzcjq);
    }

    public final void run() {
        this.zzgvr.zzaql();
    }
}
