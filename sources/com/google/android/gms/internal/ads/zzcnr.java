package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnr implements Callable {
    private final zzcno zzgqf;
    private final zzauj zzgqg;

    zzcnr(zzcno zzcno, zzauj zzauj) {
        this.zzgqf = zzcno;
        this.zzgqg = zzauj;
    }

    public final Object call() {
        return this.zzgqf.zzf(this.zzgqg);
    }
}
