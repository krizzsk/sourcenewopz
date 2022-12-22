package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmp implements zzesa<zzcmm> {
    private final zzesn<Clock> zzfvh;

    public zzcmp(zzesn<Clock> zzesn) {
        this.zzfvh = zzesn;
    }

    public final /* synthetic */ Object get() {
        return new zzcmm(this.zzfvh.get());
    }
}
