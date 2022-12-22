package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfl implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzaxo zzetp;
    private final /* synthetic */ zzbfh zzetq;

    zzbfl(zzbfh zzbfh, zzaxo zzaxo) {
        this.zzetq = zzbfh;
        this.zzetp = zzaxo;
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzetq.zza(view, this.zzetp, 10);
    }
}
