package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqp implements Runnable {
    private final /* synthetic */ zzqj zzbnk;
    private final /* synthetic */ Surface zzbnn;

    zzqp(zzqj zzqj, Surface surface) {
        this.zzbnk = zzqj;
        this.zzbnn = surface;
    }

    public final void run() {
        this.zzbnk.zzbnj.zzb(this.zzbnn);
    }
}
