package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdlu<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdmh<R, zzdly<AdT>> {
    private final Executor executor;
    private final zzdqz zzhkm;
    private zzebi<Void> zzhkn = new zzdlv(this);

    public zzdlu(zzdqz zzdqz, Executor executor2) {
        this.zzhkm = zzdqz;
        this.executor = executor2;
    }

    public final /* bridge */ /* synthetic */ Object zzavm() {
        return null;
    }

    public final zzebt<zzdly<AdT>> zza(zzdmm zzdmm, zzdmj<R> zzdmj) {
        return zzebc.zzg(new zzdmb(this.zzhkm, zzdmm.zzhku, zzdmj, this.executor).zzavr()).zzb(new zzdlt(this, zzdmm, zzdmj), this.executor).zza(Exception.class, new zzdlw(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdmm zzdmm, zzdmj zzdmj, zzdmf zzdmf) throws Exception {
        zzdri zzdri = zzdmf.zzhkj;
        zzauj zzauj = zzdmf.zzgrg;
        zzdrj<?> zza = zzdri != null ? this.zzhkm.zza(zzdri) : null;
        if (zzdri == null) {
            return zzebh.zzag(null);
        }
        if (!(zza == null || zzauj == null)) {
            zzebh.zza(((zzbsh) zzdmj.zzc(zzdmm.zzhku).zzahg()).zzahd().zzc(zzauj), this.zzhkn, this.executor);
        }
        return zzebh.zzag(new zzdly(zzdri, zzauj, zza));
    }
}
