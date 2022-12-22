package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcjo implements zzesa<zzcja> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzacv> zzfft;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzbve> zzfxo;
    private final zzesn<zzei> zzgfg;
    private final zzesn<zztz> zzgku;
    private final zzesn<zzbfq> zzgly;
    private final zzesn<zzb> zzgmo;

    private zzcjo(zzesn<zzbfq> zzesn, zzesn<Context> zzesn2, zzesn<zzei> zzesn3, zzesn<zzacv> zzesn4, zzesn<zzbar> zzesn5, zzesn<zzb> zzesn6, zzesn<zztz> zzesn7, zzesn<zzbve> zzesn8) {
        this.zzgly = zzesn;
        this.zzeyq = zzesn2;
        this.zzgfg = zzesn3;
        this.zzfft = zzesn4;
        this.zzfsw = zzesn5;
        this.zzgmo = zzesn6;
        this.zzgku = zzesn7;
        this.zzfxo = zzesn8;
    }

    public static zzcjo zza(zzesn<zzbfq> zzesn, zzesn<Context> zzesn2, zzesn<zzei> zzesn3, zzesn<zzacv> zzesn4, zzesn<zzbar> zzesn5, zzesn<zzb> zzesn6, zzesn<zztz> zzesn7, zzesn<zzbve> zzesn8) {
        return new zzcjo(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7, zzesn8);
    }

    public final /* synthetic */ Object get() {
        return new zzcja(this.zzgly.get(), this.zzeyq.get(), this.zzgfg.get(), this.zzfft.get(), this.zzfsw.get(), this.zzgmo.get(), this.zzgku.get(), this.zzfxo.get());
    }
}
