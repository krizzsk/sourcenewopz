package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrg implements zzesa<zzbzl<zzdtm>> {
    private final zzesn<zzcrs> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzcrg(zzesn<zzcrs> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcrg zzao(zzesn<zzcrs> zzesn, zzesn<Executor> zzesn2) {
        return new zzcrg(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
