package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzctp implements zzcsz<zzbmp> {
    private final Context context;
    private final Executor zzfur;
    private final zzcja zzgix;
    private final zzbmg zzgwc;

    public zzctp(zzbmg zzbmg, Context context2, Executor executor, zzcja zzcja) {
        this.context = context2;
        this.zzgwc = zzbmg;
        this.zzfur = executor;
        this.zzgix = zzcja;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (zzdot.zzhmh == null || zzdot.zzhmh.zzdui == null) ? false : true;
    }

    public final zzebt<zzbmp> zzb(zzdpi zzdpi, zzdot zzdot) {
        return zzebh.zzb(zzebh.zzag(null), new zzcto(this, zzdpi, zzdot), this.zzfur);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdpi zzdpi, zzdot zzdot, Object obj) throws Exception {
        zzvt zzb = zzdpr.zzb(this.context, zzdot.zzhmj);
        zzbfi zza = this.zzgix.zza(zzb, zzdot, zzdpi.zzhnt.zzeuy);
        zzbly zza2 = this.zzgwc.zza(new zzbps(zzdpi, zzdot, (String) null), new zzbmb(zza.getView(), zza, zzdpr.zzh(zzb), zzdot.zzfvw, zzdot.zzfvx, zzdot.zzfvy));
        zza2.zzahy().zza(zza, false, (zzaii) null);
        zza2.zzahk().zza(new zzctr(zza), zzbat.zzekj);
        zza2.zzahy();
        return zzebh.zzb(zzcjc.zza(zza, zzdot.zzhmh.zzdug, zzdot.zzhmh.zzdui), new zzctq(zza2), (Executor) zzbat.zzekj);
    }
}
