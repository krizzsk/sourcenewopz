package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzebv {
    public static Executor zzbbe() {
        return zzeba.INSTANCE;
    }

    public static zzebs zza(ExecutorService executorService) {
        if (executorService instanceof zzebs) {
            return (zzebs) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzebw((ScheduledExecutorService) executorService);
        }
        return new zzebx(executorService);
    }

    static Executor zza(Executor executor, zzeah<?> zzeah) {
        zzdyi.checkNotNull(executor);
        zzdyi.checkNotNull(zzeah);
        if (executor == zzeba.INSTANCE) {
            return executor;
        }
        return new zzebu(executor, zzeah);
    }
}
