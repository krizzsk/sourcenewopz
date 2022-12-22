package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbp {
    private final Object lock = new Object();
    private long zzeiu;
    private long zzeiv = Long.MIN_VALUE;

    public zzbp(long j) {
        this.zzeiu = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = zzr.zzlc().elapsedRealtime();
            if (this.zzeiv + this.zzeiu > elapsedRealtime) {
                return false;
            }
            this.zzeiv = elapsedRealtime;
            return true;
        }
    }

    public final void zzfc(long j) {
        synchronized (this.lock) {
            this.zzeiu = j;
        }
    }
}
