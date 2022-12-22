package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbzr implements zzesa<zzbzp> {
    private final zzesn<Set<zzbzl<zzbzq>>> zzfxl;

    private zzbzr(zzesn<Set<zzbzl<zzbzq>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbzr zzu(zzesn<Set<zzbzl<zzbzq>>> zzesn) {
        return new zzbzr(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbzp(this.zzfxl.get());
    }
}
