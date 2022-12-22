package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcba implements zzesa<Set<zzbzl<zzbze>>> {
    private final zzesn<zzcbv> zzfvz;

    private zzcba(zzesn<zzcbv> zzesn) {
        this.zzfvz = zzesn;
    }

    public static zzcba zzw(zzesn<zzcbv> zzesn) {
        return new zzcba(zzesn);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(zzbzl.zzb(this.zzfvz.get(), zzbat.zzekj)));
    }
}
