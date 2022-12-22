package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbfj implements Runnable {
    private final String zzdmo;

    zzbfj(String str) {
        this.zzdmo = str;
    }

    public final void run() {
        zzr.zzkz().zzyf().zzcr(this.zzdmo.substring(1));
    }
}
