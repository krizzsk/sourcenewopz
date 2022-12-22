package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzaxe implements Runnable {
    private final zzaxf zzebg;
    private final Bitmap zzebh;

    zzaxe(zzaxf zzaxf, Bitmap bitmap) {
        this.zzebg = zzaxf;
        this.zzebh = bitmap;
    }

    public final void run() {
        this.zzebg.zza(this.zzebh);
    }
}
