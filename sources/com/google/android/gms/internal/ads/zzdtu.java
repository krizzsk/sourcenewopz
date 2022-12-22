package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdtu implements zzesa<zzdts> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbas> zzfab;

    public zzdtu(zzesn<Executor> zzesn, zzesn<zzbas> zzesn2) {
        this.zzeyl = zzesn;
        this.zzfab = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzdts(this.zzeyl.get(), this.zzfab.get());
    }
}
