package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzad;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcts implements zzcsz<zzbne> {
    private final Context context;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzboa zzgwe;
    private final zzdxw<zzdot, zzad> zzgwf;

    public zzcts(zzboa zzboa, Context context2, Executor executor, zzcja zzcja, zzdpm zzdpm, zzdxw<zzdot, zzad> zzdxw) {
        this.context = context2;
        this.zzgwe = zzboa;
        this.zzfur = executor;
        this.zzgix = zzcja;
        this.zzfzg = zzdpm;
        this.zzgwf = zzdxw;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (zzdot.zzhmh == null || zzdot.zzhmh.zzdui == null) ? false : true;
    }

    public final zzebt<zzbne> zzb(zzdpi zzdpi, zzdot zzdot) {
        return zzebh.zzb(zzebh.zzag(null), new zzctv(this, zzdpi, zzdot), this.zzfur);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzbfi zzbfi) {
        zzbfi.zzadz();
        zzbgc zzabv = zzbfi.zzabv();
        if (this.zzfzg.zzhnw != null && zzabv != null) {
            zzabv.zzb(this.zzfzg.zzhnw);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzb(zzdpi zzdpi, zzdot zzdot, Object obj) throws Exception {
        View view;
        zzvt zzb = zzdpr.zzb(this.context, zzdot.zzhmj);
        zzbfi zza = this.zzgix.zza(zzb, zzdot, zzdpi.zzhnt.zzeuy);
        zza.zzbb(zzdot.zzdyj);
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() || !zzdot.zzadh) {
            view = new zzcjr(this.context, zza.getView(), this.zzgwf.apply(zzdot));
        } else {
            view = zzbos.zza(this.context, zza.getView(), zzdot);
        }
        zzboa zzboa = this.zzgwe;
        zzbps zzbps = new zzbps(zzdpi, zzdot, (String) null);
        zza.getClass();
        zzbnh zza2 = zzboa.zza(zzbps, new zzbnl(view, zza, zzctu.zzm(zza), zzdpr.zzh(zzb)));
        zza2.zzahy().zza(zza, false, (zzaii) null);
        zza2.zzahk().zza(new zzctx(zza), zzbat.zzekj);
        zza2.zzahy();
        zzebt<?> zza3 = zzcjc.zza(zza, zzdot.zzhmh.zzdug, zzdot.zzhmh.zzdui);
        if (zzdot.zzead) {
            zza.getClass();
            zza3.addListener(zzctw.zze(zza), this.zzfur);
        }
        zza3.addListener(new zzctz(this, zza), this.zzfur);
        return zzebh.zzb(zza3, new zzcty(zza2), (Executor) zzbat.zzekj);
    }
}
