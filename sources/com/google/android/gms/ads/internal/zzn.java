package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzn implements View.OnTouchListener {
    private final /* synthetic */ zzl zzbqf;

    zzn(zzl zzl) {
        this.zzbqf = zzl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzbqf.zzbqd == null) {
            return false;
        }
        this.zzbqf.zzbqd.zza(motionEvent);
        return false;
    }
}
