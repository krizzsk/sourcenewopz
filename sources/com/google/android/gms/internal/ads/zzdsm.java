package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdsm implements zzesa<ScheduledExecutorService> {
    private final zzesn<ThreadFactory> zzhsr;

    public zzdsm(zzesn<ThreadFactory> zzesn) {
        this.zzhsr = zzesn;
    }

    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzesg.zzbd(zzdxa.zzazw().zzb(1, this.zzhsr.get(), zzdxj.zzhyj));
    }
}
