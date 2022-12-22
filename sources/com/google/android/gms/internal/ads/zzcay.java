package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcay implements zzesa<zzbzl<zzbsy>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcbx> zzfvz;
    private final zzcak zzgdr;

    private zzcay(zzcak zzcak, zzesn<zzcbx> zzesn, zzesn<Executor> zzesn2) {
        this.zzgdr = zzcak;
        this.zzfvz = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcay zzb(zzcak zzcak, zzesn<zzcbx> zzesn, zzesn<Executor> zzesn2) {
        return new zzcay(zzcak, zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), this.zzeyl.get()));
    }
}
