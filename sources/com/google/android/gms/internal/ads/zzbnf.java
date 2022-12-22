package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbnf implements zzesa<zzbve> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<ScheduledExecutorService> zzfwv;

    public zzbnf(zzesn<ScheduledExecutorService> zzesn, zzesn<Clock> zzesn2) {
        this.zzfwv = zzesn;
        this.zzfvh = zzesn2;
    }

    public static zzbve zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbve) zzesg.zzbd(new zzbve(scheduledExecutorService, clock));
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfwv.get(), this.zzfvh.get());
    }
}
