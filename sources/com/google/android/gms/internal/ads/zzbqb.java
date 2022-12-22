package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqb implements zzesa<zzbzl<zzbtq>> {
    private final zzesn<zzbva> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzbqb(zzesn<zzbva> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzbqb zzc(zzesn<zzbva> zzesn, zzesn<Executor> zzesn2) {
        return new zzbqb(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
