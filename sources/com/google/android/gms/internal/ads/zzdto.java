package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdto implements zzesa<zzdtj> {
    private final zzesn<Set<zzbzl<zzdtm>>> zzfxl;

    private zzdto(zzesn<Set<zzbzl<zzdtm>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzdto zzar(zzesn<Set<zzbzl<zzdtm>>> zzesn) {
        return new zzdto(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzdtj(this.zzfxl.get());
    }
}
