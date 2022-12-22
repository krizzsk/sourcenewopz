package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpz implements zzp {
    private final zzbty zzfzc;
    private AtomicBoolean zzfzd = new AtomicBoolean(false);

    public zzbpz(zzbty zzbty) {
        this.zzfzc = zzbty;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        this.zzfzd.set(true);
        this.zzfzc.onAdClosed();
    }

    public final void zzvz() {
        this.zzfzc.onAdOpened();
    }

    public final boolean isClosed() {
        return this.zzfzd.get();
    }
}
