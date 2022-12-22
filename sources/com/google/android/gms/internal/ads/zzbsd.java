package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbsd implements zzesa<zzbsa> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzaso> zzgau;

    private zzbsd(zzesn<Context> zzesn, zzesn<zzdot> zzesn2, zzesn<zzaso> zzesn3) {
        this.zzeyq = zzesn;
        this.zzfxz = zzesn2;
        this.zzgau = zzesn3;
    }

    public static zzbsd zzl(zzesn<Context> zzesn, zzesn<zzdot> zzesn2, zzesn<zzaso> zzesn3) {
        return new zzbsd(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzbsa(this.zzeyq.get(), this.zzfxz.get(), this.zzgau.get());
    }
}
