package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbmc implements zzesa<Set<zzbzl<zzqw>>> {
    private final zzbmb zzfvu;
    private final zzesn<zzbox> zzfvz;

    public zzbmc(zzbmb zzbmb, zzesn<zzbox> zzesn) {
        this.zzfvu = zzbmb;
        this.zzfvz = zzesn;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(new zzbzl(this.zzfvz.get(), zzbat.zzekj)));
    }
}
