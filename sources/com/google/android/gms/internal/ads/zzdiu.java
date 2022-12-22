package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdiu implements Callable {
    private final zzebt zzgbc;
    private final zzebt zzgkr;

    zzdiu(zzebt zzebt, zzebt zzebt2) {
        this.zzgkr = zzebt;
        this.zzgbc = zzebt2;
    }

    public final Object call() {
        return new zzdis((String) this.zzgkr.get(), (String) this.zzgbc.get());
    }
}
