package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbni implements zzesa<zzbng> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbzp> zzfjj;
    private final zzesn<zzbpf> zzfkj;
    private final zzesn<zzczg> zzfpi;
    private final zzesn<View> zzfub;
    private final zzesn<zzdow> zzfxb;
    private final zzesn<zzbfi> zzfxc;
    private final zzesn<zzbpd> zzfxd;
    private final zzesn<zzcdy> zzfxe;
    private final zzesn<Executor> zzfxf;

    public zzbni(zzesn<zzbpf> zzesn, zzesn<Context> zzesn2, zzesn<zzdow> zzesn3, zzesn<View> zzesn4, zzesn<zzbfi> zzesn5, zzesn<zzbpd> zzesn6, zzesn<zzcdy> zzesn7, zzesn<zzbzp> zzesn8, zzesn<zzczg> zzesn9, zzesn<Executor> zzesn10) {
        this.zzfkj = zzesn;
        this.zzeyq = zzesn2;
        this.zzfxb = zzesn3;
        this.zzfub = zzesn4;
        this.zzfxc = zzesn5;
        this.zzfxd = zzesn6;
        this.zzfxe = zzesn7;
        this.zzfjj = zzesn8;
        this.zzfpi = zzesn9;
        this.zzfxf = zzesn10;
    }

    public static zzbng zza(zzbpf zzbpf, Context context, zzdow zzdow, View view, zzbfi zzbfi, zzbpd zzbpd, zzcdy zzcdy, zzbzp zzbzp, zzeru<zzczg> zzeru, Executor executor) {
        return new zzbng(zzbpf, context, zzdow, view, zzbfi, zzbpd, zzcdy, zzbzp, zzeru, executor);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfkj.get(), this.zzeyq.get(), this.zzfxb.get(), this.zzfub.get(), this.zzfxc.get(), this.zzfxd.get(), this.zzfxe.get(), this.zzfjj.get(), zzesb.zzat(this.zzfpi), this.zzfxf.get());
    }
}
