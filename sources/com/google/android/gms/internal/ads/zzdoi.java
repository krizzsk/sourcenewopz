package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdoi implements zzesa<zzdnz> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<zzdph> zzfri;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdnb> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdmh<zzcis, zzcip>> zzhif;
    private final zzesn<zzdpo> zzhig;

    public zzdoi(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzbhh> zzesn3, zzesn<zzdmh<zzcis, zzcip>> zzesn4, zzesn<zzdnb> zzesn5, zzesn<zzdpo> zzesn6, zzesn<zzdph> zzesn7) {
        this.zzhie = zzesn;
        this.zzfxf = zzesn2;
        this.zzeym = zzesn3;
        this.zzhif = zzesn4;
        this.zzhbp = zzesn5;
        this.zzhig = zzesn6;
        this.zzfri = zzesn7;
    }

    public final /* synthetic */ Object get() {
        return new zzdnz(this.zzhie.get(), this.zzfxf.get(), this.zzeym.get(), this.zzhif.get(), this.zzhbp.get(), this.zzhig.get(), this.zzfri.get());
    }
}
