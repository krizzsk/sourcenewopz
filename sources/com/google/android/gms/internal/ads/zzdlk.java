package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdlk<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdmh<R, zzdrj<AdT>> {
    private final Executor executor = zzebv.zzbbe();
    private R zzhju;

    public final zzebt<zzdrj<AdT>> zza(zzdmm zzdmm, zzdmj<R> zzdmj) {
        zzebt<zzdpi> zzebt;
        zzbsg<R> zzc = zzdmj.zzc(zzdmm.zzhku);
        zzc.zza(new zzdmp(true));
        R r = (zzbsh) zzc.zzahg();
        this.zzhju = r;
        zzbqd zzahd = r.zzahd();
        zzdrj zzdrj = new zzdrj();
        if (zzdmm.zzhkt != null) {
            zzebt = zzahd.zza(zzdmm.zzhkt);
        } else {
            zzebt = zzahd.zzalu();
        }
        return zzebc.zzg(zzebt).zzb(new zzdlj(this, zzdrj, zzahd), this.executor).zza(new zzdlm(zzdrj), this.executor);
    }

    public final /* synthetic */ Object zzavm() {
        return this.zzhju;
    }
}
