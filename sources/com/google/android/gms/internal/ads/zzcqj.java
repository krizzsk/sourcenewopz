package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcqj implements Callable {
    private final zzebt zzfyy;
    private final zzebt zzgbc;
    private final zzcqb zzgse;

    zzcqj(zzcqb zzcqb, zzebt zzebt, zzebt zzebt2) {
        this.zzgse = zzcqb;
        this.zzgbc = zzebt;
        this.zzfyy = zzebt2;
    }

    public final Object call() {
        return this.zzgse.zza(this.zzgbc, this.zzfyy);
    }
}
