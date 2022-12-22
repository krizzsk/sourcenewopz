package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzpw implements ThreadFactory {
    private final /* synthetic */ String zzblc;

    zzpw(String str) {
        this.zzblc = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zzblc);
    }
}
