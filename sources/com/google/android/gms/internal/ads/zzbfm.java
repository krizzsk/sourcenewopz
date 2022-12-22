package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfm implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzaxo zzetp;
    private final /* synthetic */ zzbfh zzetq;
    private final /* synthetic */ int zzetr;

    zzbfm(zzbfh zzbfh, View view, zzaxo zzaxo, int i) {
        this.zzetq = zzbfh;
        this.val$view = view;
        this.zzetp = zzaxo;
        this.zzetr = i;
    }

    public final void run() {
        this.zzetq.zza(this.val$view, this.zzetp, this.zzetr - 1);
    }
}
