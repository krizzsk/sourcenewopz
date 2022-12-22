package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzq implements zzal {
    private final Executor zzaa;

    public zzq(Handler handler) {
        this.zzaa = new zzt(this, handler);
    }

    public final void zza(zzab<?> zzab, zzag<?> zzag) {
        zza(zzab, zzag, (Runnable) null);
    }

    public final void zza(zzab<?> zzab, zzag<?> zzag, Runnable runnable) {
        zzab.zzk();
        zzab.zzc("post-response");
        this.zzaa.execute(new zzs(zzab, zzag, runnable));
    }

    public final void zza(zzab<?> zzab, zzap zzap) {
        zzab.zzc("post-error");
        this.zzaa.execute(new zzs(zzab, zzag.zzc(zzap), (Runnable) null));
    }
}
