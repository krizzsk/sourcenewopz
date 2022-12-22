package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdes implements zzesa<zzdeq> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzdes(zzesn<Context> zzesn, zzesn<zzebs> zzesn2) {
        this.zzeyq = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzdes zzaw(zzesn<Context> zzesn, zzesn<zzebs> zzesn2) {
        return new zzdes(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzdeq(this.zzeyq.get(), this.zzeyl.get());
    }
}
