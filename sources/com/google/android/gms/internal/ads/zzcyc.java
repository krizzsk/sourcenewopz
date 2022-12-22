package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyc implements zzcsz<zzbne> {
    private final zzdtg zzfzh;
    private final zzboa zzgwe;
    private final zzebs zzgzd;
    private final Context zzgzj;
    private final zzacm zzgzk;

    public zzcyc(Context context, zzboa zzboa, zzdtg zzdtg, zzebs zzebs, zzacm zzacm) {
        this.zzgzj = context;
        this.zzgwe = zzboa;
        this.zzfzh = zzdtg;
        this.zzgzd = zzebs;
        this.zzgzk = zzacm;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (this.zzgzk == null || zzdot.zzhmh == null || zzdot.zzhmh.zzdui == null) ? false : true;
    }

    public final zzebt<zzbne> zzb(zzdpi zzdpi, zzdot zzdot) {
        zzbnh zza = this.zzgwe.zza(new zzbps(zzdpi, zzdot, (String) null), (zzbnl) new zzcyh(this, new View(this.zzgzj), (zzbfi) null, zzcyf.zzgzo, zzdot.zzhmj.get(0)));
        return this.zzfzh.zzt(zzdth.CUSTOM_RENDER_SYN).zza((zzdsq) new zzcye(this, new zzacj(zza.zzaik(), zzdot.zzhmh.zzdug, zzdot.zzhmh.zzdui)), this.zzgzd).zzv(zzdth.CUSTOM_RENDER_ACK).zze(zzebh.zzag(zza.zzaii())).zzayi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzacj zzacj) throws Exception {
        this.zzgzk.zza(zzacj);
    }
}
