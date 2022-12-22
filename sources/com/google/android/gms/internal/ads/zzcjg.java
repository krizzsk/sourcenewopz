package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcjg implements View.OnTouchListener {
    private final zzcjc zzgmm;

    zzcjg(zzcjc zzcjc) {
        this.zzgmm = zzcjc;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.zzgmm.zza(view, motionEvent);
    }
}
