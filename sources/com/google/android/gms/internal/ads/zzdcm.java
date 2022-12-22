package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcm implements zzdhe<Object> {
    private final Executor executor;
    private final zzebt<String> zzhdi;

    public zzdcm(zzebt<String> zzebt, Executor executor2) {
        this.zzhdi = zzebt;
        this.executor = executor2;
    }

    public final zzebt<Object> zzatu() {
        return zzebh.zzb(this.zzhdi, zzdcl.zzbpa, this.executor);
    }
}
