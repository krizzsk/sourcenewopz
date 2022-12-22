package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhq implements zzesa<zzdho> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzdhq(zzesn<zzebs> zzesn, zzesn<Context> zzesn2) {
        this.zzeyl = zzesn;
        this.zzeyq = zzesn2;
    }

    public static zzdhq zzbd(zzesn<zzebs> zzesn, zzesn<Context> zzesn2) {
        return new zzdhq(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzdho(this.zzeyl.get(), this.zzeyq.get());
    }
}
