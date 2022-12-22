package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyi implements zzesa<zzcyc> {
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzboa> zzgvz;
    private final zzesn<Context> zzgzq;
    private final zzesn<zzacm> zzgzr;

    public zzcyi(zzesn<Context> zzesn, zzesn<zzboa> zzesn2, zzesn<zzdtg> zzesn3, zzesn<zzebs> zzesn4, zzesn<zzacm> zzesn5) {
        this.zzgzq = zzesn;
        this.zzgvz = zzesn2;
        this.zzfxq = zzesn3;
        this.zzfxf = zzesn4;
        this.zzgzr = zzesn5;
    }

    public final /* synthetic */ Object get() {
        return new zzcyc(this.zzgzq.get(), this.zzgvz.get(), this.zzfxq.get(), this.zzfxf.get(), this.zzgzr.get());
    }
}
