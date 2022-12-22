package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcaq implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzdot> zzfvi;
    private final zzesn<zzdpm> zzfxn;
    private final zzcak zzgdr;

    private zzcaq(zzcak zzcak, zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzdpm> zzesn4) {
        this.zzgdr = zzcak;
        this.zzeyq = zzesn;
        this.zzfsw = zzesn2;
        this.zzfvi = zzesn3;
        this.zzfxn = zzesn4;
    }

    public static zzcaq zza(zzcak zzcak, zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzdpm> zzesn4) {
        return new zzcaq(zzcak, zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(new zzcan(this.zzeyq.get(), this.zzfsw.get(), this.zzfvi.get(), this.zzfxn.get()), zzbat.zzekj));
    }
}
