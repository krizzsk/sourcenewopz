package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcz {
    private AtomicBoolean zzhdv = new AtomicBoolean(false);

    public final void zzbp(boolean z) {
        this.zzhdv.set(true);
    }

    public final boolean zzatx() {
        return this.zzhdv.get();
    }
}
