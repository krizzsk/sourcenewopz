package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqd<T> {
    private final Executor executor;
    private final zzcov zzfzf;
    private final zzdpm zzfzg;
    private final zzdtg zzfzh;
    private final zzbkl zzfzi;
    private final zzcwr<T> zzfzj;
    /* access modifiers changed from: private */
    public final zzbxf zzfzk;
    private final zzdpi zzfzl;
    private final zzcpr zzfzm;
    private final zzbsc zzfzn;
    private final zzcpk zzfzo;
    private final zzctc zzfzp;

    zzbqd(zzcov zzcov, zzdpm zzdpm, zzdtg zzdtg, zzbkl zzbkl, zzcwr<T> zzcwr, zzbxf zzbxf, zzdpi zzdpi, zzcpr zzcpr, zzbsc zzbsc, Executor executor2, zzcpk zzcpk, zzctc zzctc) {
        this.zzfzf = zzcov;
        this.zzfzg = zzdpm;
        this.zzfzh = zzdtg;
        this.zzfzi = zzbkl;
        this.zzfzj = zzcwr;
        this.zzfzk = zzbxf;
        this.zzfzl = zzdpi;
        this.zzfzm = zzcpr;
        this.zzfzn = zzbsc;
        this.executor = executor2;
        this.zzfzo = zzcpk;
        this.zzfzp = zzctc;
    }

    private final zzebt<zzdpi> zza(zzebt<zzauj> zzebt) {
        if (this.zzfzl != null) {
            return this.zzfzh.zzt(zzdth.SERVER_TRANSACTION).zze(zzebh.zzag(this.zzfzl)).zzayi();
        }
        zzr.zzlb().zzna();
        if (this.zzfzg.zzhnx.zzcip != null) {
            return this.zzfzh.zzt(zzdth.SERVER_TRANSACTION).zze(this.zzfzf.zzasl()).zzayi();
        }
        zzdsy<I> zza = this.zzfzh.zza(zzdth.SERVER_TRANSACTION, zzebt);
        zzcpk zzcpk = this.zzfzo;
        zzcpk.getClass();
        return zza.zza(zzbqc.zza(zzcpk)).zzayi();
    }

    public final zzebt<zzdpi> zza(zzauj zzauj) {
        return zza((zzebt<zzauj>) zzebh.zzag(zzauj));
    }

    public final zzebt<zzdpi> zzalu() {
        return zza(this.zzfzn.zzamd());
    }

    public final zzebt<T> zzb(zzebt<zzdpi> zzebt) {
        zzdsy<O2> zza = this.zzfzh.zza(zzdth.RENDERER, zzebt).zzb(new zzbqf(this)).zza(this.zzfzj);
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcxh)).booleanValue()) {
            zza = zza.zza((long) ((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS);
        }
        return zza.zzayi();
    }

    public final zzebt<T> zzb(zzauj zzauj) {
        return zzb(zza(zzauj));
    }

    public final zzebt<T> zzalv() {
        return zzb(zzalu());
    }

    public final zzbxf zzalw() {
        return this.zzfzk;
    }

    public final zzebt<zzauj> zza(zzdrc zzdrc) {
        zzdst<E, O2> zzayi = this.zzfzh.zza(zzdth.GET_CACHE_KEY, this.zzfzn.zzamd()).zza(new zzbqe(this, zzdrc)).zzayi();
        zzebh.zza(zzayi, new zzbqh(this), this.executor);
        return zzayi;
    }

    public final zzebt<Void> zzc(zzauj zzauj) {
        zzdst<E, I> zzayi = this.zzfzh.zza(zzdth.NOTIFY_CACHE_HIT, this.zzfzm.zzm(zzauj)).zzayi();
        zzebh.zza(zzayi, new zzbqg(this), this.executor);
        return zzayi;
    }

    public final zzvh zze(Throwable th) {
        return zzdqh.zza(th, this.zzfzp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdrc zzdrc, zzauj zzauj) throws Exception {
        zzauj.zzdyu = zzdrc;
        return this.zzfzm.zzl(zzauj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdpi zzc(zzdpi zzdpi) throws Exception {
        this.zzfzi.zzb(zzdpi);
        return zzdpi;
    }
}
