package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcee implements zzesa<zzbzl<zzbvb>> {
    private final zzesn<zzdah> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzcee(zzesn<zzdah> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzcee zzu(zzesn<zzdah> zzesn, zzesn<Executor> zzesn2) {
        return new zzcee(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
