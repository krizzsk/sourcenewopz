package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbnt implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzdot> zzfvi;
    private final zzbnl zzfxk;
    private final zzesn<zzdpm> zzfxn;

    public zzbnt(zzbnl zzbnl, zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzdpm> zzesn4) {
        this.zzfxk = zzbnl;
        this.zzeyq = zzesn;
        this.zzfsw = zzesn2;
        this.zzfvi = zzesn3;
        this.zzfxn = zzesn4;
    }

    public static zzbzl<zzbuj> zza(zzbnl zzbnl, Context context, zzbar zzbar, zzdot zzdot, zzdpm zzdpm) {
        return (zzbzl) zzesg.zzbd(new zzbzl(new zzbnk(context, zzbar, zzdot, zzdpm), zzbat.zzekj));
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzeyq.get(), this.zzfsw.get(), this.zzfvi.get(), this.zzfxn.get());
    }
}
