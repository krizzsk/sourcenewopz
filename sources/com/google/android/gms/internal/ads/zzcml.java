package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcml implements zzesa<zzcmg> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzdue> zzeyz;
    private final zzesn<zzbas> zzfab;
    private final zzesn<zzdug> zzgow;

    public zzcml(zzesn<Executor> zzesn, zzesn<zzbas> zzesn2, zzesn<zzdue> zzesn3, zzesn<zzdug> zzesn4) {
        this.zzeyl = zzesn;
        this.zzfab = zzesn2;
        this.zzeyz = zzesn3;
        this.zzgow = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzcmg(this.zzeyl.get(), this.zzfab.get(), this.zzeyz.get(), this.zzgow.get());
    }
}
