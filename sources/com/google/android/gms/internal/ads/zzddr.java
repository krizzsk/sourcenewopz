package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddr implements zzesa<zzddp> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzddr(zzesn<zzebs> zzesn, zzesn<Context> zzesn2) {
        this.zzeyl = zzesn;
        this.zzeyq = zzesn2;
    }

    public static zzddr zzau(zzesn<zzebs> zzesn, zzesn<Context> zzesn2) {
        return new zzddr(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzddp(this.zzeyl.get(), this.zzeyq.get());
    }
}
