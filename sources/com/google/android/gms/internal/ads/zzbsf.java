package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbsf implements Callable {
    private final zzbsc zzgbb;
    private final zzebt zzgbc;

    zzbsf(zzbsc zzbsc, zzebt zzebt) {
        this.zzgbb = zzbsc;
        this.zzgbc = zzebt;
    }

    public final Object call() {
        return this.zzgbb.zzc(this.zzgbc);
    }
}
