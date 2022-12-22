package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdio implements zzesa<zzdim> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zztk> zzfad;

    public zzdio(zzesn<zztk> zzesn, zzesn<zzebs> zzesn2, zzesn<Context> zzesn3) {
        this.zzfad = zzesn;
        this.zzeyl = zzesn2;
        this.zzeyq = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzdim(this.zzfad.get(), this.zzeyl.get(), this.zzeyq.get());
    }
}
