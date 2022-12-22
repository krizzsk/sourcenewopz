package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrh implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzcrp> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzcrh(zzesn<zzcrp> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcrh zzap(zzesn<zzcrp> zzesn, zzesn<Executor> zzesn2) {
        return new zzcrh(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
