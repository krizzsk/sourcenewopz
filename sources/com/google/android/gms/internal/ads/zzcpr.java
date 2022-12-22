package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcpr {
    private final zzebs zzgka;
    private final zzeru<zzcqb> zzgqd;
    private final zzcpe zzgru;

    public zzcpr(zzebs zzebs, zzcpe zzcpe, zzeru<zzcqb> zzeru) {
        this.zzgka = zzebs;
        this.zzgru = zzcpe;
        this.zzgqd = zzeru;
    }

    private final <RetT> zzebt<RetT> zza(zzauj zzauj, zzcpy<InputStream> zzcpy, zzcpy<InputStream> zzcpy2, zzear<InputStream, RetT> zzear) {
        zzebt<V> zzebt;
        String str = zzauj.packageName;
        zzr.zzkv();
        if (zzj.zzem(str)) {
            zzebt = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INTERNAL_ERROR));
        } else {
            zzebt = zzebh.zzb(zzcpy.zzq(zzauj), ExecutionException.class, zzcpq.zzbpa, this.zzgka);
        }
        return zzebc.zzg(zzebt).zzb(zzear, this.zzgka).zza(zzcpo.class, new zzcpt(this, zzcpy2, zzauj, zzear), (Executor) this.zzgka);
    }

    public final zzebt<zzauj> zzl(zzauj zzauj) {
        zzcps zzcps = new zzcps(zzauj);
        zzcpe zzcpe = this.zzgru;
        zzcpe.getClass();
        return zza(zzauj, (zzcpy<InputStream>) zzcpv.zza(zzcpe), (zzcpy<InputStream>) new zzcpu(this), zzcps);
    }

    public final zzebt<Void> zzm(zzauj zzauj) {
        if (zzfh.zzar(zzauj.zzdyv)) {
            return zzebh.immediateFailedFuture(new zzcnp(zzdqj.INVALID_REQUEST, "Pool key missing from removeUrl call."));
        }
        return zza(zzauj, (zzcpy<InputStream>) new zzcpw(this), (zzcpy<InputStream>) new zzcpz(this), zzcpx.zzbpa);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzn(zzauj zzauj) {
        return this.zzgqd.get().zzgk(zzauj.zzdyv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzo(zzauj zzauj) {
        return this.zzgru.zzgj(zzauj.zzdyv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzp(zzauj zzauj) {
        return this.zzgqd.get().zzc(zzauj, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzcpy zzcpy, zzauj zzauj, zzear zzear, zzcpo zzcpo) throws Exception {
        return zzebh.zzb(zzcpy.zzq(zzauj), zzear, (Executor) this.zzgka);
    }
}
