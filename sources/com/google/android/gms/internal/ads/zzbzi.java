package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbzi implements zzesa<zzbzh> {
    private final zzesn<Set<zzbzl<zzbze>>> zzfxl;

    private zzbzi(zzesn<Set<zzbzl<zzbze>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbzi zzt(zzesn<Set<zzbzl<zzbze>>> zzesn) {
        return new zzbzi(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbzh(this.zzfxl.get());
    }
}
