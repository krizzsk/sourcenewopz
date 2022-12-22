package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzm implements Runnable {
    private final zzj zzduc;
    private final Drawable zzdud;

    zzm(zzj zzj, Drawable drawable) {
        this.zzduc = zzj;
        this.zzdud = drawable;
    }

    public final void run() {
        zzj zzj = this.zzduc;
        zzj.zzdtu.zzaax.getWindow().setBackgroundDrawable(this.zzdud);
    }
}
