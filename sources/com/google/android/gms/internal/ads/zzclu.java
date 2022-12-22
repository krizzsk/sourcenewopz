package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclu implements zzesa<zzbzl<zzdtm>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmf> zzgab;
    private final zzesn<zzcrd> zzgac;

    private zzclu(zzesn<zzcmf> zzesn, zzesn<Executor> zzesn2, zzesn<zzcrd> zzesn3) {
        this.zzgab = zzesn;
        this.zzeyl = zzesn2;
        this.zzgac = zzesn3;
    }

    public static zzclu zzu(zzesn<zzcmf> zzesn, zzesn<Executor> zzesn2, zzesn<zzcrd> zzesn3) {
        return new zzclu(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        zzbzl zzbzl;
        zzcmf zzcmf = this.zzgab.get();
        Executor executor = this.zzeyl.get();
        zzcrd zzcrd = this.zzgac.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzbzl = new zzbzl(zzcrd, executor);
        } else {
            zzbzl = new zzbzl(zzcmf, executor);
        }
        return (zzbzl) zzesg.zzbd(zzbzl);
    }
}
