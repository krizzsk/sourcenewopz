package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbve extends zzbxq<zzbvi> {
    private final Clock zzbqq;
    private boolean zzfux = false;
    private final ScheduledExecutorService zzfvp;
    private long zzfvr = -1;
    private long zzfvs = -1;
    private ScheduledFuture<?> zzgbx;

    public zzbve(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfvp = scheduledExecutorService;
        this.zzbqq = clock;
    }

    public final synchronized void onPause() {
        if (!this.zzfux) {
            if (this.zzgbx == null || this.zzgbx.isCancelled()) {
                this.zzfvs = -1;
            } else {
                this.zzgbx.cancel(true);
                this.zzfvs = this.zzfvr - this.zzbqq.elapsedRealtime();
            }
            this.zzfux = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfux) {
            if (this.zzfvs > 0 && this.zzgbx.isCancelled()) {
                zzfe(this.zzfvs);
            }
            this.zzfux = false;
        }
    }

    public final synchronized void zzamm() {
        this.zzfux = false;
        zzfe(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzef(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0043 }
            long r1 = (long) r7     // Catch:{ all -> 0x0043 }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x0043 }
            boolean r7 = r6.zzfux     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x0025
            long r2 = r6.zzfvs     // Catch:{ all -> 0x0043 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001f
            long r2 = r6.zzfvs     // Catch:{ all -> 0x0043 }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            long r0 = r6.zzfvs     // Catch:{ all -> 0x0043 }
        L_0x0021:
            r6.zzfvs = r0     // Catch:{ all -> 0x0043 }
            monitor-exit(r6)
            return
        L_0x0025:
            com.google.android.gms.common.util.Clock r7 = r6.zzbqq     // Catch:{ all -> 0x0043 }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r4 = r6.zzfvr     // Catch:{ all -> 0x0043 }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x003e
            long r2 = r6.zzfvr     // Catch:{ all -> 0x0043 }
            com.google.android.gms.common.util.Clock r7 = r6.zzbqq     // Catch:{ all -> 0x0043 }
            long r4 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r2 = r2 - r4
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0041
        L_0x003e:
            r6.zzfe(r0)     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r6)
            return
        L_0x0043:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbve.zzef(int):void");
    }

    private final synchronized void zzfe(long j) {
        if (this.zzgbx != null && !this.zzgbx.isDone()) {
            this.zzgbx.cancel(true);
        }
        this.zzfvr = this.zzbqq.elapsedRealtime() + j;
        this.zzgbx = this.zzfvp.schedule(new zzbvf(this), j, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public final void zzamn() {
        zza(zzbvd.zzgbn);
    }
}
