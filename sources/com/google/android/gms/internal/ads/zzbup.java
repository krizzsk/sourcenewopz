package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbup implements zzesa<zzbun> {
    private final zzesn<Set<zzbzl<zzbus>>> zzfxl;

    private zzbup(zzesn<Set<zzbzl<zzbus>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbup zzn(zzesn<Set<zzbzl<zzbus>>> zzesn) {
        return new zzbup(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbun(this.zzfxl.get());
    }
}
