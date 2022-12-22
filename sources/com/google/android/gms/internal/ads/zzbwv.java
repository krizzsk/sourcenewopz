package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbwv implements zzesa<zzbwt> {
    private final zzesn<Set<zzbzl<zzbwy>>> zzfxl;

    private zzbwv(zzesn<Set<zzbzl<zzbwy>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbwv zzp(zzesn<Set<zzbzl<zzbwy>>> zzesn) {
        return new zzbwv(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbwt(this.zzfxl.get());
    }
}
