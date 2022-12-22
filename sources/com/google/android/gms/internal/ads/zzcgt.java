package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcgt implements zzesa<zzcgp> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcgf> zzgkd;

    public zzcgt(zzesn<Executor> zzesn, zzesn<zzcgf> zzesn2) {
        this.zzeyl = zzesn;
        this.zzgkd = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzcgp(this.zzeyl.get(), this.zzgkd.get());
    }
}
