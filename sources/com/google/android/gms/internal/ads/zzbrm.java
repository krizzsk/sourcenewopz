package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbrm implements zzesa<zzbzl<zzbtq>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzclp> zzgab;
    private final zzesn<zzcqv> zzgac;

    private zzbrm(zzesn<zzclp> zzesn, zzesn<Executor> zzesn2, zzesn<zzcqv> zzesn3) {
        this.zzgab = zzesn;
        this.zzeyl = zzesn2;
        this.zzgac = zzesn3;
    }

    public static zzbrm zzj(zzesn<zzclp> zzesn, zzesn<Executor> zzesn2, zzesn<zzcqv> zzesn3) {
        return new zzbrm(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        zzbzl zzbzl;
        zzclp zzclp = this.zzgab.get();
        Executor executor = this.zzeyl.get();
        zzcqv zzcqv = this.zzgac.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzbzl = new zzbzl(zzcqv, executor);
        } else {
            zzbzl = new zzbzl(zzclp, executor);
        }
        return (zzbzl) zzesg.zzbd(zzbzl);
    }
}
