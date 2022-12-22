package com.google.android.gms.common.util.concurrent;

import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
final class zza implements Runnable {
    private final Runnable zza;

    public zza(Runnable runnable, int i) {
        this.zza = runnable;
    }

    public final void run() {
        SystemUtils.setProcessThreadPriority(0);
        this.zza.run();
    }
}
