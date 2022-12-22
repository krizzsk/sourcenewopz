package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdsy<O> {
    private final E zzhsw;
    private final String zzhsx;
    private final List<zzebt<?>> zzhsz;
    final /* synthetic */ zzdss zzhta;
    private final zzebt<?> zzhtb;
    private final zzebt<O> zzhtc;

    private zzdsy(zzdss zzdss, E e, String str, zzebt<?> zzebt, List<zzebt<?>> list, zzebt<O> zzebt2) {
        this.zzhta = zzdss;
        this.zzhsw = e;
        this.zzhsx = str;
        this.zzhtb = zzebt;
        this.zzhsz = list;
        this.zzhtc = zzebt2;
    }

    public final zzdsy<O> zzgv(String str) {
        return new zzdsy(this.zzhta, this.zzhsw, str, this.zzhtb, this.zzhsz, this.zzhtc);
    }

    public final <O2> zzdsy<O2> zzb(zzdsr<O, O2> zzdsr) {
        return zza(new zzdtb(zzdsr));
    }

    public final <O2> zzdsy<O2> zza(zzear<O, O2> zzear) {
        return zza(zzear, (Executor) this.zzhta.zzgka);
    }

    private final <O2> zzdsy<O2> zza(zzear<O, O2> zzear, Executor executor) {
        return new zzdsy(this.zzhta, this.zzhsw, this.zzhsx, this.zzhtb, this.zzhsz, zzebh.zzb(this.zzhtc, zzear, executor));
    }

    public final <O2> zzdsy<O2> zze(zzebt<O2> zzebt) {
        return zza(new zzdta(zzebt), (Executor) zzbat.zzekj);
    }

    public final <T extends Throwable> zzdsy<O> zza(Class<T> cls, zzdsr<T, O> zzdsr) {
        return zza(cls, new zzdtd(zzdsr));
    }

    public final <T extends Throwable> zzdsy<O> zza(Class<T> cls, zzear<T, O> zzear) {
        zzdss zzdss = this.zzhta;
        return new zzdsy(zzdss, this.zzhsw, this.zzhsx, this.zzhtb, this.zzhsz, zzebh.zzb(this.zzhtc, cls, zzear, zzdss.zzgka));
    }

    public final zzdsy<O> zza(long j, TimeUnit timeUnit) {
        zzdss zzdss = this.zzhta;
        return new zzdsy(zzdss, this.zzhsw, this.zzhsx, this.zzhtb, this.zzhsz, zzebh.zza(this.zzhtc, j, timeUnit, zzdss.zzfvp));
    }

    public final zzdst<E, O> zzayi() {
        E e = this.zzhsw;
        String str = this.zzhsx;
        if (str == null) {
            str = this.zzhta.zzu(e);
        }
        zzdst<E, O> zzdst = new zzdst<>(e, str, this.zzhtc);
        this.zzhta.zzhsv.zza(zzdst);
        this.zzhtb.addListener(new zzdtc(this, zzdst), zzbat.zzekj);
        zzebh.zza(zzdst, new zzdtf(this, zzdst), zzbat.zzekj);
        return zzdst;
    }

    public final zzdsy<O> zzv(E e) {
        return this.zzhta.zza(e, zzayi());
    }

    /* synthetic */ zzdsy(zzdss zzdss, Object obj, String str, zzebt zzebt, List list, zzebt zzebt2, zzdsv zzdsv) {
        this(zzdss, obj, (String) null, zzebt, list, zzebt2);
    }
}
