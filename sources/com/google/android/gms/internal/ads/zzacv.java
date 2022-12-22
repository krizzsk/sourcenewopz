package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzacv {
    private MotionEvent zzddh = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzddi = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zzddh.getEventTime()) {
            this.zzddh = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzddi.getEventTime()) {
            this.zzddi = MotionEvent.obtain(motionEvent);
        }
    }

    public final MotionEvent zzte() {
        return this.zzddh;
    }

    public final MotionEvent zztf() {
        return this.zzddi;
    }
}
