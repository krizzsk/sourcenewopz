package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcno {
    private final zzebs zzgka;
    private final zzebs zzgqb;
    private final zzcoz zzgqc;
    private final zzeru<zzcqb> zzgqd;

    public zzcno(zzebs zzebs, zzebs zzebs2, zzcoz zzcoz, zzeru<zzcqb> zzeru) {
        this.zzgqb = zzebs;
        this.zzgka = zzebs2;
        this.zzgqc = zzcoz;
        this.zzgqd = zzeru;
    }

    public final zzebt<InputStream> zze(zzauj zzauj) {
        zzebt<V> zzebt;
        String str = zzauj.packageName;
        zzr.zzkv();
        if (zzj.zzem(str)) {
            zzebt = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INTERNAL_ERROR));
        } else {
            zzebt = zzebh.zzb(this.zzgqb.zze(new zzcnr(this, zzauj)), ExecutionException.class, zzcnq.zzbpa, this.zzgka);
        }
        return zzebh.zzb(zzebt, zzcpo.class, new zzcnt(this, zzauj, Binder.getCallingUid()), this.zzgka);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzauj zzauj, int i, zzcpo zzcpo) throws Exception {
        return this.zzgqd.get().zzb(zzauj, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzf(zzauj zzauj) throws Exception {
        return (InputStream) this.zzgqc.zzi(zzauj).get((long) ((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS);
    }
}
