package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzctg implements zzcsz<zzbmz> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzbmt zzgvo;
    private final zzail zzgvp;
    private final boolean zzgvq = ((Boolean) zzww.zzra().zzd(zzabq.zzdbr)).booleanValue();

    public zzctg(zzbmt zzbmt, Context context2, Executor executor, zzcja zzcja, zzdpm zzdpm, zzbar zzbar, zzail zzail) {
        this.context = context2;
        this.zzgvo = zzbmt;
        this.zzfur = executor;
        this.zzgix = zzcja;
        this.zzfzg = zzdpm;
        this.zzbpj = zzbar;
        this.zzgvp = zzail;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (zzdot.zzhmh == null || zzdot.zzhmh.zzdui == null) ? false : true;
    }

    public final zzebt<zzbmz> zzb(zzdpi zzdpi, zzdot zzdot) {
        zzcjq zzcjq = new zzcjq();
        zzebt<zzbmz> zzb = zzebh.zzb(zzebh.zzag(null), new zzctj(this, zzdot, zzdpi, zzcjq), this.zzfur);
        zzcjq.getClass();
        zzb.addListener(zzcti.zza(zzcjq), this.zzfur);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdot zzdot, zzdpi zzdpi, zzcjq zzcjq, Object obj) throws Exception {
        zzdot zzdot2 = zzdot;
        zzdpi zzdpi2 = zzdpi;
        zzbfi zza = this.zzgix.zza(this.zzfzg.zzbpy, zzdot2, zzdpi2.zzhnt.zzeuy);
        zza.zzbb(zzdot2.zzdyj);
        zzcjq.zzc(this.context, zza.getView());
        zzbbe zzbbe = new zzbbe();
        zzbmt zzbmt = this.zzgvo;
        zzbps zzbps = new zzbps(zzdpi2, zzdot2, (String) null);
        zzctm zzctm = r1;
        zzctm zzctm2 = new zzctm(this.zzbpj, zzbbe, zzdot, zza, this.zzfzg, this.zzgvq, this.zzgvp);
        zzbmr zza2 = zzbmt.zza(zzbps, new zzcak(zzctm, zza), new zzbmq(zzdot2.zzfvw));
        zza2.zzahy().zza(zza, false, (zzaii) this.zzgvq ? this.zzgvp : null);
        zzbbe.set(zza2);
        zza2.zzahk().zza(new zzctl(zza), zzbat.zzekj);
        zza2.zzahy();
        return zzebh.zzb(zzcjc.zza(zza, zzdot2.zzhmh.zzdug, zzdot2.zzhmh.zzdui), new zzctk(this, zza, zzdot2, zza2), this.zzfur);
    }
}
