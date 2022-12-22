package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmh implements zzesa<zzcmf> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzclz> zzgon;
    private final zzesn<Set<zzcme>> zzgoo;

    private zzcmh(zzesn<zzclz> zzesn, zzesn<Set<zzcme>> zzesn2, zzesn<Clock> zzesn3) {
        this.zzgon = zzesn;
        this.zzgoo = zzesn2;
        this.zzfvh = zzesn3;
    }

    public static zzcmh zzw(zzesn<zzclz> zzesn, zzesn<Set<zzcme>> zzesn2, zzesn<Clock> zzesn3) {
        return new zzcmh(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzcmf(this.zzgon.get(), this.zzgoo.get(), this.zzfvh.get());
    }
}
