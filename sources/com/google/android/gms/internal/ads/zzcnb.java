package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcnb implements zzesa<zzcmy> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<zzcmm> zzgma;

    private zzcnb(zzesn<zzcmm> zzesn, zzesn<zzbhh> zzesn2) {
        this.zzgma = zzesn;
        this.zzeym = zzesn2;
    }

    public static zzcnb zzah(zzesn<zzcmm> zzesn, zzesn<zzbhh> zzesn2) {
        return new zzcnb(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcmy(this.zzgma.get(), this.zzeym.get());
    }
}
