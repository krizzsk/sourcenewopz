package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcn implements zzesa<zzdcm> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzebt<String>> zzhdj;

    private zzdcn(zzesn<zzebt<String>> zzesn, zzesn<Executor> zzesn2) {
        this.zzhdj = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzdcn zzas(zzesn<zzebt<String>> zzesn, zzesn<Executor> zzesn2) {
        return new zzdcn(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzdcm(this.zzhdj.get(), this.zzeyl.get());
    }
}
