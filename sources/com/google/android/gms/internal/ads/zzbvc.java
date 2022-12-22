package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbvc implements zzesa<zzbva> {
    private final zzesn<zzdot> zzfua;
    private final zzesn<Set<zzbzl<zzbvb>>> zzfxl;

    private zzbvc(zzesn<Set<zzbzl<zzbvb>>> zzesn, zzesn<zzdot> zzesn2) {
        this.zzfxl = zzesn;
        this.zzfua = zzesn2;
    }

    public static zzbvc zzr(zzesn<Set<zzbzl<zzbvb>>> zzesn, zzesn<zzdot> zzesn2) {
        return new zzbvc(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzbva(this.zzfxl.get(), this.zzfua.get());
    }
}
