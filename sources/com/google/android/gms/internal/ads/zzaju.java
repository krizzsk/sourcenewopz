package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaju implements AdapterStatus {
    private final String description;
    private final int zzdkc;
    private final AdapterStatus.State zzdkd;

    public zzaju(AdapterStatus.State state, String str, int i) {
        this.zzdkd = state;
        this.description = str;
        this.zzdkc = i;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.zzdkd;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getLatency() {
        return this.zzdkc;
    }
}
