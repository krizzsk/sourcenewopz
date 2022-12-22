package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcxe implements Runnable {
    private final zzcjq zzgvr;

    private zzcxe(zzcjq zzcjq) {
        this.zzgvr = zzcjq;
    }

    static Runnable zza(zzcjq zzcjq) {
        return new zzcxe(zzcjq);
    }

    public final void run() {
        this.zzgvr.zzaql();
    }
}
