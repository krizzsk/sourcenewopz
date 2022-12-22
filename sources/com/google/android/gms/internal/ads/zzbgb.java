package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbgb implements Runnable {
    private final Map zzeds;
    private final zzbgc zzewe;

    zzbgb(zzbgc zzbgc, Map map) {
        this.zzewe = zzbgc;
        this.zzeds = map;
    }

    public final void run() {
        this.zzewe.zzl(this.zzeds);
    }
}
