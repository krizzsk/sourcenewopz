package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzail implements zzaii {
    private boolean zzbpo = false;
    private boolean zzbpr = false;
    private float zzbps = 0.0f;
    private AtomicBoolean zzdjb = new AtomicBoolean(false);

    public final synchronized void zzac(boolean z) {
        this.zzbpo = z;
        this.zzdjb.set(true);
    }

    public final synchronized void zza(boolean z, float f) {
        this.zzbpr = z;
        this.zzbps = f;
    }

    public final synchronized boolean zzad(boolean z) {
        if (!this.zzdjb.get()) {
            return z;
        }
        return this.zzbpo;
    }

    public final synchronized boolean zzui() {
        return this.zzbpr;
    }

    public final synchronized float zzuj() {
        return this.zzbps;
    }
}
