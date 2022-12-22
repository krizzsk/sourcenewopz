package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbtv implements zzesa<zzbts> {
    private final zzesn<Set<zzbzl<zzbtp>>> zzfxl;

    private zzbtv(zzesn<Set<zzbzl<zzbtp>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbtv zzj(zzesn<Set<zzbzl<zzbtp>>> zzesn) {
        return new zzbtv(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbts(this.zzfxl.get());
    }
}
