package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbav implements ThreadFactory {
    private final /* synthetic */ String zzekk;
    private final AtomicInteger zzzc = new AtomicInteger(1);

    zzbav(String str) {
        this.zzekk = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzekk;
        int andIncrement = this.zzzc.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
