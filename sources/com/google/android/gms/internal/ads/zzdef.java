package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdef implements zzesa<zzddz<zzddu>> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzddt> zzhes;

    public zzdef(zzesn<zzddt> zzesn, zzesn<Clock> zzesn2) {
        this.zzhes = zzesn;
        this.zzfvh = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return (zzddz) zzesg.zzbd(new zzddz(this.zzhes.get(), 10000, this.zzfvh.get()));
    }
}
