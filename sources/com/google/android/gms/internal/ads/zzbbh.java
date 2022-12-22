package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbbh<T> {
    private final zzbbe<T> zzekq = new zzbbe<>();
    /* access modifiers changed from: private */
    public final AtomicInteger zzekr = new AtomicInteger(0);

    public zzbbh() {
        zzebh.zza(this.zzekq, new zzbbk(this), zzbat.zzekj);
    }

    @Deprecated
    public final void zza(zzbbi<T> zzbbi, zzbbg zzbbg) {
        zzebh.zza(this.zzekq, new zzbbj(this, zzbbi, zzbbg), zzbat.zzekj);
    }

    @Deprecated
    public final void zzl(T t) {
        this.zzekq.set(t);
    }

    @Deprecated
    public final void reject() {
        this.zzekq.setException(new Exception());
    }

    @Deprecated
    public final int getStatus() {
        return this.zzekr.get();
    }
}
