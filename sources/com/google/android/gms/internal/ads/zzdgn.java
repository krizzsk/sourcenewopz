package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgn implements zzesa<zzdgl> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzdgn(zzesn<zzayd> zzesn, zzesn<zzebs> zzesn2, zzesn<Context> zzesn3) {
        this.zzecg = zzesn;
        this.zzeyl = zzesn2;
        this.zzeyq = zzesn3;
    }

    public static zzdgn zzab(zzesn<zzayd> zzesn, zzesn<zzebs> zzesn2, zzesn<Context> zzesn3) {
        return new zzdgn(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzdgl(this.zzecg.get(), this.zzeyl.get(), this.zzeyq.get());
    }
}
