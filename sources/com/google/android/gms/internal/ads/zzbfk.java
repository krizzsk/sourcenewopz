package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbfk implements Runnable {
    private final zzbfh zzeto;

    zzbfk(zzbfh zzbfh) {
        this.zzeto = zzbfh;
    }

    public final void run() {
        zzbfh zzbfh = this.zzeto;
        zzbfh.zzesx.zzaeo();
        zze zzaeb = zzbfh.zzesx.zzaeb();
        if (zzaeb != null) {
            zzaeb.zzwi();
        }
    }
}
