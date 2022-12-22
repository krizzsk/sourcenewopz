package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbnm implements zzesa<zzbui> {
    private final zzbnl zzfxk;
    private final zzesn<Set<zzbzl<zzbuj>>> zzfxl;

    public zzbnm(zzbnl zzbnl, zzesn<Set<zzbzl<zzbuj>>> zzesn) {
        this.zzfxk = zzbnl;
        this.zzfxl = zzesn;
    }

    public static zzbui zza(zzbnl zzbnl, Set<zzbzl<zzbuj>> set) {
        return (zzbui) zzesg.zzbd(zzbnl.zza(set));
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzfxl.get());
    }
}
