package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzzu implements Runnable {
    private final zzzs zzclg;
    private final OnInitializationCompleteListener zzclp;

    zzzu(zzzs zzzs, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzclg = zzzs;
        this.zzclp = onInitializationCompleteListener;
    }

    public final void run() {
        this.zzclg.zza(this.zzclp);
    }
}
