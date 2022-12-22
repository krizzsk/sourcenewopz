package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzfb implements ThreadFactory {
    private final ThreadFactory zzzb = Executors.defaultThreadFactory();
    private final AtomicInteger zzzc = new AtomicInteger(1);

    zzfb() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzzb.newThread(runnable);
        int andIncrement = this.zzzc.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
