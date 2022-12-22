package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbtn implements zzesa<zzbtl> {
    private final zzesn<Set<zzbzl<zzbtq>>> zzfxl;

    private zzbtn(zzesn<Set<zzbzl<zzbtq>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbtn zzi(zzesn<Set<zzbzl<zzbtq>>> zzesn) {
        return new zzbtn(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbtl(this.zzfxl.get());
    }
}
