package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdil implements Callable {
    private final zzdim zzhhk;

    zzdil(zzdim zzdim) {
        this.zzhhk = zzdim;
    }

    public final Object call() {
        zzdim zzdim = this.zzhhk;
        return new zzdij(zzdim.zzhhl.zzf(zzdim.context));
    }
}
