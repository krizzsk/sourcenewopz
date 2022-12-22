package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzblj implements zzesa<zzblg> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzqt> zzfuw;

    private zzblj(zzesn<Context> zzesn, zzesn<zzqt> zzesn2) {
        this.zzeyq = zzesn;
        this.zzfuw = zzesn2;
    }

    public static zzblj zza(zzesn<Context> zzesn, zzesn<zzqt> zzesn2) {
        return new zzblj(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzblg(this.zzeyq.get(), this.zzfuw.get());
    }
}
