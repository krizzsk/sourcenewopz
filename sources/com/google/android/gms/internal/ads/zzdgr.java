package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgr implements zzesa<zzdgp> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;

    private zzdgr(zzesn<zzebs> zzesn, zzesn<Context> zzesn2, zzesn<zzbar> zzesn3) {
        this.zzeyl = zzesn;
        this.zzeyq = zzesn2;
        this.zzfsw = zzesn3;
    }

    public static zzdgr zzac(zzesn<zzebs> zzesn, zzesn<Context> zzesn2, zzesn<zzbar> zzesn3) {
        return new zzdgr(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzdgp(this.zzeyl.get(), this.zzeyq.get(), this.zzfsw.get());
    }
}
