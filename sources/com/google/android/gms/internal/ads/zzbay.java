package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbay implements Executor {
    private final Handler zzekm = new zzg(Looper.getMainLooper());

    zzbay() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzr.zzkv();
                zzj.zza(zzr.zzkz().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.zzekm.post(runnable);
        }
    }
}
