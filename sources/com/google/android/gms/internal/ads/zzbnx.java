package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbnx implements zzesa<Set<zzbzl<zzqw>>> {
    private final zzesn<zzbox> zzfvz;
    private final zzbnl zzfxk;

    public zzbnx(zzbnl zzbnl, zzesn<zzbox> zzesn) {
        this.zzfxk = zzbnl;
        this.zzfvz = zzesn;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(new zzbzl(this.zzfvz.get(), zzbat.zzekj)));
    }
}
