package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcc implements zzesa<zzdca> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcon> zzgqi;

    public zzdcc(zzesn<Executor> zzesn, zzesn<zzcon> zzesn2) {
        this.zzeyl = zzesn;
        this.zzgqi = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzdca(this.zzeyl.get(), this.zzgqi.get());
    }
}
