package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzczf implements zzesa<zzczb> {
    private final zzesn<Executor> zzeyl;

    public zzczf(zzesn<Executor> zzesn) {
        this.zzeyl = zzesn;
    }

    public final /* synthetic */ Object get() {
        return new zzczb(this.zzeyl.get());
    }
}
