package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzed implements Runnable {
    private final /* synthetic */ MotionEvent zzxt;

    zzed(zzea zzea, MotionEvent motionEvent) {
        this.zzxt = motionEvent;
    }

    public final void run() {
        try {
            zzea.zzxf.zza(this.zzxt);
        } catch (Exception e) {
            zzea.zzxh.zza(2022, -1, e);
        }
    }
}
