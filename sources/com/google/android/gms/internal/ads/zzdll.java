package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;
import com.google.android.gms.internal.ads.zzuh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdll<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdmh<R, AdT> {
    private final Executor executor;
    private final zzdmh<R, AdT> zzhim;
    private final zzdmh<R, zzdly<AdT>> zzhjv;
    private final zzdrr<AdT> zzhjw;
    private R zzhjx;

    public zzdll(zzdmh<R, AdT> zzdmh, zzdmh<R, zzdly<AdT>> zzdmh2, zzdrr<AdT> zzdrr, Executor executor2) {
        this.zzhim = zzdmh;
        this.zzhjv = zzdmh2;
        this.zzhjw = zzdrr;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzavn */
    public final synchronized R zzavm() {
        return this.zzhjx;
    }

    public final synchronized zzebt<AdT> zza(zzdmm zzdmm, zzdmj<R> zzdmj) {
        zzdpm zzaia;
        zzdmj<R> zzdmj2;
        zzdmm zzdmm2;
        zzaia = ((zzbsh) zzdmj.zzc(zzdmm.zzhku).zzahg()).zzaia();
        zzdmj2 = zzdmj;
        zzdmm2 = zzdmm;
        return zzebc.zzg(this.zzhjv.zza(zzdmm, zzdmj)).zzb(new zzdlo(this, zzdmm, new zzdls(zzdmj2, zzdmm2, zzaia.zzhnx, zzaia.zzhny, this.executor, zzaia.zzhob, (zzdri) null), zzdmj), this.executor);
    }

    private final zzebt<AdT> zza(zzdrj<AdT> zzdrj, zzdmm zzdmm, zzdmj<R> zzdmj) {
        zzbsg<R> zzc = zzdmj.zzc(zzdmm.zzhku);
        if (zzdrj.zzhrk != null) {
            zzbsh zzbsh = (zzbsh) zzc.zzahg();
            if (zzbsh.zzaib() != null) {
                zzdrj.zzhrk.zzalm().zzb(zzbsh.zzaib());
            }
            return zzebh.zzag(zzdrj.zzhrk);
        }
        zzc.zza(zzdrj.zzfbh);
        zzebt<AdT> zza = this.zzhim.zza(zzdmm, new zzdln(zzc));
        this.zzhjx = (zzbsh) this.zzhim.zzavm();
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdmj zzdmj, zzdrv zzdrv) throws Exception {
        if (zzdrv == null || zzdrv.zzhko == null || zzdrv.zzhsa == null) {
            throw new zzcnp(zzdqj.INTERNAL_ERROR, "Empty prefetch");
        }
        zzdrv.zzhko.zzhrj.zzalw().zze((zzuh.zzb) ((zzena) zzuh.zzb.zznt().zza(zzuh.zzb.zza.zznr().zzb(zzuh.zzb.zzc.IN_MEMORY).zza(zzuh.zzb.zzd.zznv())).zzbjv()));
        return zza(zzdrv.zzhko, ((zzdls) zzdrv.zzhsa).zzhki, zzdmj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdmm zzdmm, zzdls zzdls, zzdmj zzdmj, zzdly zzdly) throws Exception {
        if (zzdly != null) {
            zzdls zzdls2 = new zzdls(zzdls.zzhkh, zzdls.zzhki, zzdls.zzdvn, zzdls.zzbvf, zzdls.executor, zzdls.zzhdy, zzdly.zzhkj);
            if (zzdly.zzhko != null) {
                this.zzhjx = null;
                this.zzhjw.zzb((zzdrx) zzdls2);
                return zza(zzdly.zzhko, zzdmm, zzdmj);
            }
            zzebt<zzdrv<AdT>> zzc = this.zzhjw.zzc((zzdrx) zzdls2);
            if (zzc != null) {
                this.zzhjx = (zzbsh) zzdmj.zzc(zzdmm.zzhku).zzahg();
                return zzebh.zzb(zzc, new zzdlq(this, zzdmj), this.executor);
            }
            this.zzhjw.zzb((zzdrx) zzdls2);
            zzdmm = new zzdmm(zzdmm.zzhku, zzdly.zzgrg);
        }
        zzebt<AdT> zza = this.zzhim.zza(zzdmm, zzdmj);
        this.zzhjx = (zzbsh) this.zzhim.zzavm();
        return zza;
    }
}
