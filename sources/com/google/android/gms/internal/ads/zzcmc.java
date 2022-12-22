package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmc implements zzesa<zzcmb> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmg> zzezo;

    public zzcmc(zzesn<zzcmg> zzesn, zzesn<Executor> zzesn2) {
        this.zzezo = zzesn;
        this.zzeyl = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzcmb(this.zzezo.get(), this.zzeyl.get());
    }
}
