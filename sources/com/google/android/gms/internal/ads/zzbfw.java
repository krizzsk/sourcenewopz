package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbfw implements Runnable {
    private final IObjectWrapper zzeup;

    zzbfw(IObjectWrapper iObjectWrapper) {
        this.zzeup = iObjectWrapper;
    }

    public final void run() {
        zzr.zzlk().zzad(this.zzeup);
    }
}
