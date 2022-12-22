package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdoe implements zzebi<zzcip> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzdof zzhln;
    final /* synthetic */ zzdnz zzhlo;

    zzdoe(zzdnz zzdnz, zzdav zzdav, zzdof zzdof) {
        this.zzhlo = zzdnz;
        this.zzhcc = zzdav;
        this.zzhln = zzdof;
    }

    public final void zzb(Throwable th) {
        zzvh zzvh;
        zzcis zzcis = (zzcis) this.zzhlo.zzhim.zzavm();
        if (zzcis == null) {
            zzvh = zzdqh.zza(th, (zzctc) null);
        } else {
            zzvh = zzcis.zzahd().zze(th);
        }
        synchronized (this.zzhlo) {
            if (zzcis != null) {
                zzcis.zzahe().zzd(zzvh);
                this.zzhlo.zzfur.execute(new zzdog(this, zzvh));
            } else {
                this.zzhlo.zzhlj.zzd(zzvh);
                this.zzhlo.zze(this.zzhln).zzaix().zzahd().zzalw().zzamr();
            }
            zzdqa.zza(zzvh.errorCode, th, "RewardedAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcip zzcip = (zzcip) obj;
        synchronized (this.zzhlo) {
            zzcip.zzaln().zza(this.zzhlo.zzhlj);
            this.zzhcc.onSuccess(zzcip);
            Executor zzb = this.zzhlo.zzfur;
            zzdnb zza = this.zzhlo.zzhlj;
            zza.getClass();
            zzb.execute(zzdod.zzb(zza));
            this.zzhlo.zzhlj.onAdMetadataChanged();
        }
    }
}
