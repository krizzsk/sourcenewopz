package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqa implements zzesa<zzbzl<zzbus>> {
    private final zzesn<zzbva> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzbqa(zzesn<zzbva> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzbqa zzb(zzesn<zzbva> zzesn, zzesn<Executor> zzesn2) {
        return new zzbqa(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
