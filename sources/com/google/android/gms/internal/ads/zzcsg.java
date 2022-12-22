package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsg implements Callable {
    private final zzcsh zzguk;

    zzcsg(zzcsh zzcsh) {
        this.zzguk = zzcsh;
    }

    public final Object call() {
        return this.zzguk.getWritableDatabase();
    }
}
