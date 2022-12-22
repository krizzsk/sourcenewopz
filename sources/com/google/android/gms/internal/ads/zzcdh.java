package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcdh implements Runnable {
    private final zzcdz zzgge;

    private zzcdh(zzcdz zzcdz) {
        this.zzgge = zzcdz;
    }

    static Runnable zza(zzcdz zzcdz) {
        return new zzcdh(zzcdz);
    }

    public final void run() {
        this.zzgge.zzaof();
    }
}
