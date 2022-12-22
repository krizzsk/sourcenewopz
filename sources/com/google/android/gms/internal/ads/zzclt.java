package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclt implements zzesa<zzbzl<zzbvm>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzclr> zzgab;
    private final zzesn<zzcqx> zzgac;

    private zzclt(zzesn<zzclr> zzesn, zzesn<Executor> zzesn2, zzesn<zzcqx> zzesn3) {
        this.zzgab = zzesn;
        this.zzeyl = zzesn2;
        this.zzgac = zzesn3;
    }

    public static zzclt zzt(zzesn<zzclr> zzesn, zzesn<Executor> zzesn2, zzesn<zzcqx> zzesn3) {
        return new zzclt(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        zzbzl zzbzl;
        zzclr zzclr = this.zzgab.get();
        Executor executor = this.zzeyl.get();
        zzcqx zzcqx = this.zzgac.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzbzl = new zzbzl(zzcqx, executor);
        } else {
            zzbzl = new zzbzl(zzclr, executor);
        }
        return (zzbzl) zzesg.zzbd(zzbzl);
    }
}
