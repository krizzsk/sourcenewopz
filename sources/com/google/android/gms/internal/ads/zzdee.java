package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdee implements zzdhe<zzdeb> {
    private final zzdpm zzfzg;
    private final zzebs zzgka;
    private final String zzhcu;
    private final zzckd zzher;

    public zzdee(zzebs zzebs, zzckd zzckd, zzdpm zzdpm, String str) {
        this.zzgka = zzebs;
        this.zzher = zzckd;
        this.zzfzg = zzdpm;
        this.zzhcu = str;
    }

    public final zzebt<zzdeb> zzatu() {
        return this.zzgka.zze(new zzded(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdeb zzaud() throws Exception {
        return new zzdeb(this.zzher.zzr(this.zzfzg.zzhny, this.zzhcu), this.zzher.zzaqr());
    }
}
