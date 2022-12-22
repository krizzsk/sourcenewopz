package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcux implements zzcsz<zzcaj> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzail zzgvp;
    private final boolean zzgvq = ((Boolean) zzww.zzra().zzd(zzabq.zzdbr)).booleanValue();
    private final zzcbj zzgwq;

    public zzcux(Context context2, zzbar zzbar, zzdpm zzdpm, Executor executor, zzcbj zzcbj, zzcja zzcja, zzail zzail) {
        this.context = context2;
        this.zzfzg = zzdpm;
        this.zzgwq = zzcbj;
        this.zzfur = executor;
        this.zzbpj = zzbar;
        this.zzgix = zzcja;
        this.zzgvp = zzail;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (zzdot.zzhmh == null || zzdot.zzhmh.zzdui == null) ? false : true;
    }

    public final zzebt<zzcaj> zzb(zzdpi zzdpi, zzdot zzdot) {
        zzcjq zzcjq = new zzcjq();
        zzebt<zzcaj> zzb = zzebh.zzb(zzebh.zzag(null), new zzcuw(this, zzdot, zzdpi, zzcjq), this.zzfur);
        zzcjq.getClass();
        zzb.addListener(zzcuz.zza(zzcjq), this.zzfur);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzb(zzdot zzdot, zzdpi zzdpi, zzcjq zzcjq, Object obj) throws Exception {
        zzdot zzdot2 = zzdot;
        zzdpi zzdpi2 = zzdpi;
        zzbfi zza = this.zzgix.zza(this.zzfzg.zzbpy, zzdot2, zzdpi2.zzhnt.zzeuy);
        zza.zzbb(zzdot2.zzdyj);
        zzcjq.zzc(this.context, zza.getView());
        zzbbe zzbbe = new zzbbe();
        zzcbj zzcbj = this.zzgwq;
        zzbps zzbps = new zzbps(zzdpi2, zzdot2, (String) null);
        zzcvd zzcvd = r1;
        zzcvd zzcvd2 = new zzcvd(this.context, this.zzbpj, zzbbe, zzdot, zza, this.zzfzg, this.zzgvq, this.zzgvp);
        zzcal zza2 = zzcbj.zza(zzbps, new zzcak(zzcvd, zza));
        zzbbe.set(zza2);
        zza2.zzahk().zza(new zzcuy(zza), zzbat.zzekj);
        zza2.zzahy().zza(zza, true, (zzaii) this.zzgvq ? this.zzgvp : null);
        zza2.zzahy();
        zzdot zzdot3 = zzdot;
        return zzebh.zzb(zzcjc.zza(zza, zzdot3.zzhmh.zzdug, zzdot3.zzhmh.zzdui), new zzcvb(this, zza, zzdot3, zza2), this.zzfur);
    }
}
