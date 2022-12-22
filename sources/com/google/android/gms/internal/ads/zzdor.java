package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdor {
    private final Object lock = new Object();
    private final Clock zzbqq;
    private volatile long zzefc = 0;
    private volatile int zzhlx = zzdou.zzhnc;

    public zzdor(Clock clock) {
        this.zzbqq = clock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzt(int r5, int r6) {
        /*
            r4 = this;
            r4.zzavv()
            com.google.android.gms.common.util.Clock r0 = r4.zzbqq
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.lock
            monitor-enter(r2)
            int r3 = r4.zzhlx     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.zzhlx = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.zzhlx     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.zzdou.zzhne     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.zzefc = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdor.zzt(int, int):void");
    }

    private final void zzavv() {
        long currentTimeMillis = this.zzbqq.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhlx == zzdou.zzhne) {
                if (this.zzefc + ((Long) zzww.zzra().zzd(zzabq.zzcyg)).longValue() <= currentTimeMillis) {
                    this.zzhlx = zzdou.zzhnc;
                }
            }
        }
    }

    public final void zzbq(boolean z) {
        if (z) {
            zzt(zzdou.zzhnc, zzdou.zzhnd);
        } else {
            zzt(zzdou.zzhnd, zzdou.zzhnc);
        }
    }

    public final boolean zzavw() {
        boolean z;
        synchronized (this.lock) {
            zzavv();
            z = this.zzhlx == zzdou.zzhnd;
        }
        return z;
    }

    public final boolean zzavx() {
        boolean z;
        synchronized (this.lock) {
            zzavv();
            z = this.zzhlx == zzdou.zzhne;
        }
        return z;
    }

    public final void zzyh() {
        zzt(zzdou.zzhnd, zzdou.zzhne);
    }
}
