package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmw implements Runnable {
    private final /* synthetic */ zzms zzbdv;
    private final /* synthetic */ IOException zzbfb;

    zzmw(zzms zzms, IOException iOException) {
        this.zzbdv = zzms;
        this.zzbfb = iOException;
    }

    public final void run() {
        this.zzbdv.zzbdx.zzb(this.zzbfb);
    }
}
