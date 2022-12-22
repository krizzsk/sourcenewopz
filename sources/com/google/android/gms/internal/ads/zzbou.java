package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbou implements zzesa<zzbov> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzbfi> zzfxc;
    private final zzesn<zzdot> zzfxz;

    public zzbou(zzesn<Context> zzesn, zzesn<zzbfi> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzbar> zzesn4) {
        this.zzeyq = zzesn;
        this.zzfxc = zzesn2;
        this.zzfxz = zzesn3;
        this.zzfsw = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzbov(this.zzeyq.get(), this.zzfxc.get(), this.zzfxz.get(), this.zzfsw.get());
    }
}
