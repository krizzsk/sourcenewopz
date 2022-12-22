package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcob implements zzesa<zzbzl<zzbvm>> {
    private final zzesn<zzcpi> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzcob(zzesn<zzcpi> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcob zzaj(zzesn<zzcpi> zzesn, zzesn<Executor> zzesn2) {
        return new zzcob(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
