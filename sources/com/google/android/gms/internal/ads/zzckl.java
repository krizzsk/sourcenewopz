package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzckl implements zzesa<zzbzl<zzve>> {
    private final zzesn<zzcku> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzckl(zzesn<zzcku> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzckl zzx(zzesn<zzcku> zzesn, zzesn<Executor> zzesn2) {
        return new zzckl(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
