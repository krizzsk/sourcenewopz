package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyl<AdT> implements zzcsz<AdT> {
    private final zzdtg zzfzh;
    private final zzebs zzgzd;
    private final zzacm zzgzk;
    /* access modifiers changed from: private */
    public final zzcym<AdT> zzgzt;

    public zzcyl(zzdtg zzdtg, zzebs zzebs, zzacm zzacm, zzcym<AdT> zzcym) {
        this.zzfzh = zzdtg;
        this.zzgzd = zzebs;
        this.zzgzk = zzacm;
        this.zzgzt = zzcym;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (this.zzgzk == null || zzdot.zzhmh == null || zzdot.zzhmh.zzdui == null) ? false : true;
    }

    public final zzebt<AdT> zzb(zzdpi zzdpi, zzdot zzdot) {
        zzbbe zzbbe = new zzbbe();
        zzcyt zzcyt = new zzcyt();
        zzcyt.zza(new zzcyn(this, zzbbe, zzdpi, zzdot, zzcyt));
        return this.zzfzh.zzt(zzdth.CUSTOM_RENDER_SYN).zza((zzdsq) new zzcyk(this, new zzacj(zzcyt, zzdot.zzhmh.zzdug, zzdot.zzhmh.zzdui)), this.zzgzd).zzv(zzdth.CUSTOM_RENDER_ACK).zze(zzbbe).zzayi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzacj zzacj) throws Exception {
        this.zzgzk.zza(zzacj);
    }
}
