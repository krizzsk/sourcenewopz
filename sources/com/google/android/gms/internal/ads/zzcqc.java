package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcqc implements Callable {
    private final zzebt zzgbc;
    private final zzebt zzgkr;

    zzcqc(zzebt zzebt, zzebt zzebt2) {
        this.zzgkr = zzebt;
        this.zzgbc = zzebt2;
    }

    public final Object call() {
        zzebt zzebt = this.zzgkr;
        zzebt zzebt2 = this.zzgbc;
        return new zzcqp((zzcqs) zzebt.get(), ((zzcqm) zzebt2.get()).zzgsh, ((zzcqm) zzebt2.get()).zzgsg);
    }
}
