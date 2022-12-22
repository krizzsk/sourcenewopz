package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdur implements zzesa<zzdup> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbas> zzeyu;

    public zzdur(zzesn<Executor> zzesn, zzesn<zzbas> zzesn2) {
        this.zzeyl = zzesn;
        this.zzeyu = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzdup(this.zzeyl.get(), this.zzeyu.get());
    }
}
