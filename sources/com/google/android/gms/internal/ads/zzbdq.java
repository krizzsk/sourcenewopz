package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbdq implements Runnable {
    private final Map zzeds;
    private final zzbcs zzerd;

    zzbdq(zzbcs zzbcs, Map map) {
        this.zzerd = zzbcs;
        this.zzeds = map;
    }

    public final void run() {
        this.zzerd.zza("onGcacheInfoEvent", (Map<String, ?>) this.zzeds);
    }
}
