package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdqp implements zzesa<zzdqm> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbac> zzfby;

    private zzdqp(zzesn<Context> zzesn, zzesn<zzbac> zzesn2) {
        this.zzeyq = zzesn;
        this.zzfby = zzesn2;
    }

    public static zzdqp zzbe(zzesn<Context> zzesn, zzesn<zzbac> zzesn2) {
        return new zzdqp(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzdqm(this.zzeyq.get(), this.zzfby.get());
    }
}
