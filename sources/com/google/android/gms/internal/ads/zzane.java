package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzane {
    private static zzane zzdmt;
    private AtomicBoolean zzdmu = new AtomicBoolean(false);

    public static zzane zzvd() {
        if (zzdmt == null) {
            zzdmt = new zzane();
        }
        return zzdmt;
    }

    zzane() {
    }

    public final Thread zzc(Context context, String str) {
        if (!this.zzdmu.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzanh(this, context, str));
        thread.start();
        return thread;
    }
}
