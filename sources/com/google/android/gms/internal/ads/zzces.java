package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzces implements zzesa<zzceq> {
    private final zzesn<zzchu> zzflr;
    private final zzesn<Clock> zzfvh;

    public zzces(zzesn<zzchu> zzesn, zzesn<Clock> zzesn2) {
        this.zzflr = zzesn;
        this.zzfvh = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzceq(this.zzflr.get(), this.zzfvh.get());
    }
}
