package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxo implements zzesa<zzbxf> {
    private final zzesn<Set<zzbzl<zzbxn>>> zzfxl;

    private zzbxo(zzesn<Set<zzbzl<zzbxn>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbxo zzs(zzesn<Set<zzbzl<zzbxn>>> zzesn) {
        return new zzbxo(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbxf(this.zzfxl.get());
    }
}
