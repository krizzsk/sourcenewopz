package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfg implements zzdhe<zzdfd> {
    private final zzdor zzfti;
    private final zzebs zzgka;

    public zzdfg(zzebs zzebs, zzdor zzdor) {
        this.zzgka = zzebs;
        this.zzfti = zzdor;
    }

    public final zzebt<zzdfd> zzatu() {
        return this.zzgka.zze(new zzdff(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfd zzaug() throws Exception {
        return new zzdfd(this.zzfti);
    }
}
