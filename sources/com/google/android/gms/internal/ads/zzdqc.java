package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdqc<T> {
    private final zzebs zzgka;
    private final Deque<zzebt<T>> zzhop = new LinkedBlockingDeque();
    private final Callable<T> zzhoq;

    public zzdqc(Callable<T> callable, zzebs zzebs) {
        this.zzhoq = callable;
        this.zzgka = zzebs;
    }

    public final synchronized void ensureSize(int i) {
        int size = i - this.zzhop.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzhop.add(this.zzgka.zze(this.zzhoq));
        }
    }

    public final synchronized zzebt<T> zzawl() {
        ensureSize(1);
        return this.zzhop.poll();
    }

    public final synchronized void zzd(zzebt<T> zzebt) {
        this.zzhop.addFirst(zzebt);
    }
}
