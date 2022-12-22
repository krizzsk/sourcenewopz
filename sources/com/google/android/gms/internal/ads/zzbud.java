package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbud implements zzesa<zzbty> {
    private final zzesn<Set<zzbzl<zzbsy>>> zzfxl;

    private zzbud(zzesn<Set<zzbzl<zzbsy>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbud zzk(zzesn<Set<zzbzl<zzbsy>>> zzesn) {
        return new zzbud(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbty(this.zzfxl.get());
    }
}
