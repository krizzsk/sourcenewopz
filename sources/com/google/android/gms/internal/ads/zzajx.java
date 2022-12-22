package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzajx implements InitializationStatus {
    private final Map<String, AdapterStatus> zzdkf;

    public zzajx(Map<String, AdapterStatus> map) {
        this.zzdkf = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zzdkf;
    }
}
