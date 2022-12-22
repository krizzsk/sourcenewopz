package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcuo implements zzcsz<zzbne> {
    private final ScheduledExecutorService zzftq;
    /* access modifiers changed from: private */
    public final zzbsx zzgcz;
    private final zzebs zzgka;
    /* access modifiers changed from: private */
    public final zzboa zzgwu;
    private final zzcts zzgwv;

    public zzcuo(zzboa zzboa, zzcts zzcts, zzbsx zzbsx, ScheduledExecutorService scheduledExecutorService, zzebs zzebs) {
        this.zzgwu = zzboa;
        this.zzgwv = zzcts;
        this.zzgcz = zzbsx;
        this.zzftq = scheduledExecutorService;
        this.zzgka = zzebs;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return zzdpi.zzhns.zzfzg.zzawb() != null && this.zzgwv.zza(zzdpi, zzdot);
    }

    public final zzebt<zzbne> zzb(zzdpi zzdpi, zzdot zzdot) {
        return this.zzgka.zze(new zzcur(this, zzdpi, zzdot));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbne zzc(zzdpi zzdpi, zzdot zzdot) throws Exception {
        return this.zzgwu.zza(new zzbps(zzdpi, zzdot, (String) null), new zzboo(zzdpi.zzhns.zzfzg.zzawb(), new zzcuq(this, zzdpi, zzdot))).zzaio();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdpi zzdpi, zzdot zzdot) {
        zzebh.zza(zzebh.zza(this.zzgwv.zzb(zzdpi, zzdot), (long) zzdot.zzhmr, TimeUnit.SECONDS, this.zzftq), new zzcut(this), this.zzgka);
    }
}
