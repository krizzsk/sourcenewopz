package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclm implements zzesa<zzcll> {
    private final zzesn<zztz> zzgma;
    private final zzesn<Map<zzdth, zzcln>> zzgns;

    private zzclm(zzesn<zztz> zzesn, zzesn<Map<zzdth, zzcln>> zzesn2) {
        this.zzgma = zzesn;
        this.zzgns = zzesn2;
    }

    public static zzclm zzae(zzesn<zztz> zzesn, zzesn<Map<zzdth, zzcln>> zzesn2) {
        return new zzclm(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcll(this.zzgma.get(), this.zzgns.get());
    }
}
