package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzckp implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzcku> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzckp(zzesn<zzcku> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzckp zzab(zzesn<zzcku> zzesn, zzesn<Executor> zzesn2) {
        return new zzckp(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
