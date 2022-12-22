package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzrt implements Runnable {
    private final /* synthetic */ zzrq zzbuh;
    private final /* synthetic */ View zzbui;

    zzrt(zzrq zzrq, View view) {
        this.zzbuh = zzrq;
        this.zzbui = view;
    }

    public final void run() {
        this.zzbuh.zzj(this.zzbui);
    }
}
