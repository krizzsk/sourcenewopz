package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdiv implements zzdhe<zzdiw> {
    List<String> zzdvy;
    private zzebs zzgka;
    zzabc zzhhr;

    public zzdiv(zzabc zzabc, zzebs zzebs, List<String> list) {
        this.zzhhr = zzabc;
        this.zzgka = zzebs;
        this.zzdvy = list;
    }

    public final zzebt<zzdiw> zzatu() {
        return this.zzgka.zze(new zzdiy(this));
    }
}
