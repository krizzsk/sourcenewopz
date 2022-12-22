package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbaw extends ScheduledThreadPoolExecutor {
    zzbaw(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }

    public final void execute(Runnable runnable) {
        super.execute(zzdxe.zzazx().zzf(runnable));
    }
}
