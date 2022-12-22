package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcgm implements zzesa<zzcgf> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcfw> zzffs;
    private final zzesn<zzcgs> zzffv;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzei> zzgfg;
    private final zzesn<zzb> zzgkt;
    private final zzesn<zztz> zzgku;

    public zzcgm(zzesn<Context> zzesn, zzesn<zzcfw> zzesn2, zzesn<zzei> zzesn3, zzesn<zzbar> zzesn4, zzesn<zzb> zzesn5, zzesn<zztz> zzesn6, zzesn<Executor> zzesn7, zzesn<zzdpm> zzesn8, zzesn<zzcgs> zzesn9, zzesn<ScheduledExecutorService> zzesn10) {
        this.zzeyq = zzesn;
        this.zzffs = zzesn2;
        this.zzgfg = zzesn3;
        this.zzfsw = zzesn4;
        this.zzgkt = zzesn5;
        this.zzgku = zzesn6;
        this.zzeyl = zzesn7;
        this.zzfxn = zzesn8;
        this.zzffv = zzesn9;
        this.zzfty = zzesn10;
    }

    public final /* synthetic */ Object get() {
        return new zzcgf(this.zzeyq.get(), this.zzffs.get(), this.zzgfg.get(), this.zzfsw.get(), this.zzgkt.get(), this.zzgku.get(), this.zzeyl.get(), this.zzfxn.get(), this.zzffv.get(), this.zzfty.get());
    }
}
