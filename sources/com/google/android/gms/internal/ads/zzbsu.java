package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbsu implements zzesa<zzaxo> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdot> zzfvi;
    private final zzbsr zzgbk;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<zzaxq> zzgbm;

    private zzbsu(zzbsr zzbsr, zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzaxq> zzesn4) {
        this.zzgbk = zzbsr;
        this.zzeyq = zzesn;
        this.zzgbl = zzesn2;
        this.zzfvi = zzesn3;
        this.zzgbm = zzesn4;
    }

    public static zzbsu zza(zzbsr zzbsr, zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzaxq> zzesn4) {
        return new zzbsu(zzbsr, zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        Context context = this.zzeyq.get();
        zzbar zzbar = this.zzgbl.get();
        zzdot zzdot = this.zzfvi.get();
        zzaxq zzaxq = this.zzgbm.get();
        if (zzdot.zzhml != null) {
            return new zzaxf(context, zzbar, zzdot.zzhml, zzdot.zzhmh.zzdug, zzaxq);
        }
        return null;
    }
}
