package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeah;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeby extends zzeah.zzh<Void> implements Runnable {
    private final Runnable zzidz;

    public zzeby(Runnable runnable) {
        this.zzidz = (Runnable) zzdyi.checkNotNull(runnable);
    }

    public final void run() {
        try {
            this.zzidz.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdys.zzj(th);
        }
    }
}
