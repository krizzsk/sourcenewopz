package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbns implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzesn<zzbox> zzfvz;
    private final zzbnl zzfxk;

    public zzbns(zzbnl zzbnl, zzesn<zzbox> zzesn) {
        this.zzfxk = zzbnl;
        this.zzfvz = zzesn;
    }

    public static Set<zzbzl<zzbuj>> zza(zzbnl zzbnl, zzbox zzbox) {
        return (Set) zzesg.zzbd(Collections.singleton(new zzbzl(zzbox, zzbat.zzekj)));
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzfvz.get());
    }
}
