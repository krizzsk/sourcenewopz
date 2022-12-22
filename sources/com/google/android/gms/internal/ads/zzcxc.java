package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcxc implements zzcsz<zzcip> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzail zzgvp;
    private final boolean zzgvq = ((Boolean) zzww.zzra().zzd(zzabq.zzdbr)).booleanValue();
    private final zzcis zzgyj;

    public zzcxc(Context context2, zzbar zzbar, zzdpm zzdpm, Executor executor, zzcis zzcis, zzcja zzcja, zzail zzail) {
        this.context = context2;
        this.zzfzg = zzdpm;
        this.zzgyj = zzcis;
        this.zzfur = executor;
        this.zzbpj = zzbar;
        this.zzgix = zzcja;
        this.zzgvp = zzail;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (zzdot.zzhmh == null || zzdot.zzhmh.zzdui == null) ? false : true;
    }

    public final zzebt<zzcip> zzb(zzdpi zzdpi, zzdot zzdot) {
        zzcjq zzcjq = new zzcjq();
        zzebt<zzcip> zzb = zzebh.zzb(zzebh.zzag(null), new zzcxf(this, zzdot, zzdpi, zzcjq), this.zzfur);
        zzcjq.getClass();
        zzb.addListener(zzcxe.zza(zzcjq), this.zzfur);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzc(zzdot zzdot, zzdpi zzdpi, zzcjq zzcjq, Object obj) throws Exception {
        zzdot zzdot2 = zzdot;
        zzdpi zzdpi2 = zzdpi;
        zzbfi zza = this.zzgix.zza(this.zzfzg.zzbpy, zzdot2, zzdpi2.zzhnt.zzeuy);
        zza.zzbb(zzdot2.zzdyj);
        zzcjq.zzc(this.context, zza.getView());
        zzbbe zzbbe = new zzbbe();
        zzcis zzcis = this.zzgyj;
        zzbps zzbps = new zzbps(zzdpi2, zzdot2, (String) null);
        zzcxi zzcxi = r1;
        zzcxi zzcxi2 = new zzcxi(this.context, this.zzgix, this.zzfzg, this.zzbpj, zzdot, zzbbe, zza, this.zzgvp, this.zzgvq);
        zzcir zza2 = zzcis.zza(zzbps, new zzciq(zzcxi, zza));
        zzbbe.set(zza2);
        zzaix.zza(zza, (zzaiw) zza2.zzajb());
        zza2.zzahk().zza(new zzcxh(zza), zzbat.zzekj);
        zza2.zzahy().zza(zza, true, (zzaii) this.zzgvq ? this.zzgvp : null);
        zza2.zzahy();
        zzdot zzdot3 = zzdot;
        return zzebh.zzb(zzcjc.zza(zza, zzdot3.zzhmh.zzdug, zzdot3.zzhmh.zzdui), new zzcxg(this, zza, zzdot3, zza2), this.zzfur);
    }
}
