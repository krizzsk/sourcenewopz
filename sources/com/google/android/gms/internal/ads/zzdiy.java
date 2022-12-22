package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdiy implements Callable {
    private final zzdiv zzhht;

    zzdiy(zzdiv zzdiv) {
        this.zzhht = zzdiv;
    }

    public final Object call() {
        zzdiv zzdiv = this.zzhht;
        return new zzdiw(zzdiv.zzhhr.zzf(zzdiv.zzdvy));
    }
}
