package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzec implements Runnable {
    private final /* synthetic */ Context zzxq;

    zzec(zzea zzea, Context context) {
        this.zzxq = context;
    }

    public final void run() {
        try {
            zzea.zzxf.zzb(this.zzxq);
        } catch (Exception e) {
            zzea.zzxh.zza(2019, -1, e);
        }
    }
}
