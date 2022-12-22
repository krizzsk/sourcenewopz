package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdlp<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdru<AdT> {
    private final zzdmh<R, zzdrj<AdT>> zzhke;

    public zzdlp(zzdmh<R, zzdrj<AdT>> zzdmh) {
        this.zzhke = zzdmh;
    }

    public final void zzb(Throwable th) {
    }

    public final zzebt<zzdrj<AdT>> zza(zzdrx zzdrx) {
        zzdls zzdls = (zzdls) zzdrx;
        return this.zzhke.zza(zzdls.zzhki, zzdls.zzhkh);
    }

    public final void zza(zzdrj<AdT> zzdrj) {
        zzdrj.zzhrj = ((zzbsh) this.zzhke.zzavm()).zzahd();
    }
}
