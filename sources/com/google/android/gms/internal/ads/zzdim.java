package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdim implements zzdhe<zzdij> {
    Context context;
    private zzebs zzgka;
    zztk zzhhl;

    public zzdim(zztk zztk, zzebs zzebs, Context context2) {
        this.zzhhl = zztk;
        this.zzgka = zzebs;
        this.context = context2;
    }

    public final zzebt<zzdij> zzatu() {
        return this.zzgka.zze(new zzdil(this));
    }
}
