package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdir implements zzdhe<zzdis> {
    private String packageName;
    private zzebs zzgka;
    private zzazk zzhho;

    public zzdir(zzazk zzazk, zzebs zzebs, String str) {
        this.zzhho = zzazk;
        this.zzgka = zzebs;
        this.packageName = str;
    }

    public final zzebt<zzdis> zzatu() {
        new zzbbe();
        zzebt<String> zzag = zzebh.zzag(null);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxx)).booleanValue()) {
            zzag = this.zzhho.zzeb(this.packageName);
        }
        zzebt<String> zzec = this.zzhho.zzec(this.packageName);
        return zzebh.zzb((zzebt<? extends V>[]) new zzebt[]{zzag, zzec}).zzb(new zzdiu(zzag, zzec), zzbat.zzeke);
    }
}
