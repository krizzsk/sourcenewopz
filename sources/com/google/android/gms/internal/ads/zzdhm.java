package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhm implements zzesa<zzdhk> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    public zzdhm(zzesn<zzebs> zzesn, zzesn<Context> zzesn2) {
        this.zzeyl = zzesn;
        this.zzeyq = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzdhk(this.zzeyl.get(), this.zzeyq.get());
    }
}
