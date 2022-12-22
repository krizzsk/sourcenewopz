package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzh implements Runnable {
    private final Context zzclh;
    private final String zzdmx;
    private final zzi zzefu;

    zzh(zzi zzi, Context context, String str) {
        this.zzefu = zzi;
        this.zzclh = context;
        this.zzdmx = str;
    }

    public final void run() {
        this.zzefu.zzo(this.zzclh, this.zzdmx);
    }
}
