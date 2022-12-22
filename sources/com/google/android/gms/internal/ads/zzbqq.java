package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqq implements zzesa<zzbqr> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzazr> zzfzv;

    private zzbqq(zzesn<Clock> zzesn, zzesn<zzazr> zzesn2) {
        this.zzfvh = zzesn;
        this.zzfzv = zzesn2;
    }

    public static zzbqq zzd(zzesn<Clock> zzesn, zzesn<zzazr> zzesn2) {
        return new zzbqq(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzbqr(this.zzfvh.get(), this.zzfzv.get());
    }
}
