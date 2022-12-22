package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzckh implements zzesa<zzckd> {
    private final zzesn<Executor> zzeyl;

    public zzckh(zzesn<Executor> zzesn) {
        this.zzeyl = zzesn;
    }

    public final /* synthetic */ Object get() {
        return new zzckd(this.zzeyl.get());
    }
}
