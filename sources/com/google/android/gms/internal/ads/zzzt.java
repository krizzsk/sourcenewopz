package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzzt implements InitializationStatus {
    private final zzzs zzclg;

    zzzt(zzzs zzzs) {
        this.zzclg = zzzs;
    }

    public final Map getAdapterStatusMap() {
        zzzs zzzs = this.zzclg;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzzv(zzzs));
        return hashMap;
    }
}
