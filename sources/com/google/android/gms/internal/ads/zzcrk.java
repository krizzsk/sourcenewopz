package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcrk implements Callable {
    private final zzcrj zzgsy;

    private zzcrk(zzcrj zzcrj) {
        this.zzgsy = zzcrj;
    }

    static Callable zza(zzcrj zzcrj) {
        return new zzcrk(zzcrj);
    }

    public final Object call() {
        return this.zzgsy.getWritableDatabase();
    }
}
