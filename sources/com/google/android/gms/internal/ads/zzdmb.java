package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdmb<R extends zzbsh<? extends zzbpc>> {
    private final Executor executor;
    private final zzdmj<R> zzhkh;
    private final zzdqz zzhkm;
    private final zzdmk zzhkp;
    /* access modifiers changed from: private */
    public zzdmf zzhkq;

    public zzdmb(zzdqz zzdqz, zzdmk zzdmk, zzdmj<R> zzdmj, Executor executor2) {
        this.zzhkm = zzdqz;
        this.zzhkp = zzdmk;
        this.zzhkh = zzdmj;
        this.executor = executor2;
    }

    public final zzebt<zzdmf> zzavr() {
        zzebt zzebt;
        zzdmf zzdmf = this.zzhkq;
        if (zzdmf != null) {
            return zzebh.zzag(zzdmf);
        }
        if (!zzadr.zzdfo.get().booleanValue()) {
            zzdmf zzdmf2 = new zzdmf((zzauj) null, zzavs(), (zzdmd) null);
            this.zzhkq = zzdmf2;
            zzebt = zzebh.zzag(zzdmf2);
        } else {
            zzebt = zzebc.zzg(((zzbsh) this.zzhkh.zzc(this.zzhkp).zza(new zzdlr(this.zzhkm.zzawv().zzhqs)).zzahg()).zzahd().zza(this.zzhkm.zzawv())).zza(new zzdmg(this), this.executor).zza(zzcpo.class, new zzdmd(this), this.executor);
        }
        return zzebh.zzb(zzebt, zzdme.zzebv, this.executor);
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzdri zzavs() {
        zzdpm zzaia = ((zzbsh) this.zzhkh.zzc(this.zzhkp).zzahg()).zzaia();
        return this.zzhkm.zza(zzaia.zzhnx, zzaia.zzhny, zzaia.zzhob);
    }
}
