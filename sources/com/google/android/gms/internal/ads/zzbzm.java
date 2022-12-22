package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbzm implements zzesa<zzbzk> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Set<zzbzl<zzqw>>> zzfxl;
    private final zzesn<zzdot> zzfxz;

    private zzbzm(zzesn<Context> zzesn, zzesn<Set<zzbzl<zzqw>>> zzesn2, zzesn<zzdot> zzesn3) {
        this.zzeyq = zzesn;
        this.zzfxl = zzesn2;
        this.zzfxz = zzesn3;
    }

    public static zzbzm zzo(zzesn<Context> zzesn, zzesn<Set<zzbzl<zzqw>>> zzesn2, zzesn<zzdot> zzesn3) {
        return new zzbzm(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzbzk(this.zzeyq.get(), this.zzfxl.get(), this.zzfxz.get());
    }
}
