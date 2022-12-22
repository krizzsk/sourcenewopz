package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpg<AdT> implements zzbph<AdT> {
    private final Map<String, zzcsz<AdT>> zzfyr;

    zzbpg(Map<String, zzcsz<AdT>> map) {
        this.zzfyr = map;
    }

    public final zzcsz<AdT> zze(int i, String str) {
        return this.zzfyr.get(str);
    }
}
