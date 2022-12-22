package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeg implements Runnable {
    private final /* synthetic */ int zzxv;
    private final /* synthetic */ int zzxw;
    private final /* synthetic */ int zzxx;

    zzeg(zzea zzea, int i, int i2, int i3) {
        this.zzxv = i;
        this.zzxw = i2;
        this.zzxx = i3;
    }

    public final void run() {
        try {
            zzea.zzxf.zza(MotionEvent.obtain(0, (long) this.zzxv, 0, (float) this.zzxw, (float) this.zzxx, 0));
        } catch (Exception e) {
            zzea.zzxh.zza(2022, -1, e);
        }
    }
}
