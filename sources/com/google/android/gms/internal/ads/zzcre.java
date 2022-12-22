package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcre implements zzesa<zzbzl<zzbsz>> {
    private final zzesn<zzcrp> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzcre(zzesn<zzcrp> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcre zzam(zzesn<zzcrp> zzesn, zzesn<Executor> zzesn2) {
        return new zzcre(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
