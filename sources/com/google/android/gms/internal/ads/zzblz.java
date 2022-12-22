package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzblz implements zzrr {
    private final Clock zzbqq;
    private Runnable zzefm = null;
    private final ScheduledExecutorService zzfvp;
    private ScheduledFuture<?> zzfvq;
    private long zzfvr = -1;
    private long zzfvs = -1;
    private boolean zzfvt = false;

    public zzblz(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfvp = scheduledExecutorService;
        this.zzbqq = clock;
        zzr.zzky().zza(this);
    }

    public final void zzq(boolean z) {
        if (z) {
            zzajx();
        } else {
            zzajw();
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.zzefm = runnable;
        long j = (long) i;
        this.zzfvr = this.zzbqq.elapsedRealtime() + j;
        this.zzfvq = this.zzfvp.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    private final synchronized void zzajw() {
        if (!this.zzfvt) {
            if (this.zzfvq == null || this.zzfvq.isDone()) {
                this.zzfvs = -1;
            } else {
                this.zzfvq.cancel(true);
                this.zzfvs = this.zzfvr - this.zzbqq.elapsedRealtime();
            }
            this.zzfvt = true;
        }
    }

    private final synchronized void zzajx() {
        if (this.zzfvt) {
            if (this.zzfvs > 0 && this.zzfvq != null && this.zzfvq.isCancelled()) {
                this.zzfvq = this.zzfvp.schedule(this.zzefm, this.zzfvs, TimeUnit.MILLISECONDS);
            }
            this.zzfvt = false;
        }
    }
}
