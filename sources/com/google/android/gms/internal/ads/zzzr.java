package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzzr implements Runnable {
    private final zzzs zzclg;
    private final Context zzclh;

    zzzr(zzzs zzzs, Context context) {
        this.zzclg = zzzs;
        this.zzclh = context;
    }

    public final void run() {
        this.zzclg.getRewardedVideoAdInstance(this.zzclh);
    }
}
