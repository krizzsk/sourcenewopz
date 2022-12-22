package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddg implements zzdhe<zzddd> {
    private final zzbar zzdvi;
    private final zzdpm zzfzg;
    private final zzebs zzgka;

    public zzddg(zzebs zzebs, zzdpm zzdpm, zzbar zzbar) {
        this.zzgka = zzebs;
        this.zzfzg = zzdpm;
        this.zzdvi = zzbar;
    }

    public final zzebt<zzddd> zzatu() {
        return this.zzgka.zze(new zzddf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzddd zzaua() throws Exception {
        return new zzddd(this.zzfzg.zzhob, this.zzdvi);
    }
}
