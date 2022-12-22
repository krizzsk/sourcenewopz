package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzazq {
    private long zzedw = -1;
    private long zzedx = -1;
    private final /* synthetic */ zzazr zzedy;

    public zzazq(zzazr zzazr) {
        this.zzedy = zzazr;
    }

    public final long zzxy() {
        return this.zzedx;
    }

    public final void zzxz() {
        this.zzedx = this.zzedy.zzbqq.elapsedRealtime();
    }

    public final void zzya() {
        this.zzedw = this.zzedy.zzbqq.elapsedRealtime();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzedw);
        bundle.putLong("tclose", this.zzedx);
        return bundle;
    }
}
