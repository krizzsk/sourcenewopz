package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbtk implements zzesa<zzbtf> {
    private final zzesn<Set<zzbzl<zzbtm>>> zzfxl;

    private zzbtk(zzesn<Set<zzbzl<zzbtm>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbtk zzh(zzesn<Set<zzbzl<zzbtm>>> zzesn) {
        return new zzbtk(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbtf(this.zzfxl.get());
    }
}
