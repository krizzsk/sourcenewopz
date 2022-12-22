package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzox {
    private final Map<String, String> zzbjp = new HashMap();
    private Map<String, String> zzbjq;

    public final synchronized Map<String, String> zziw() {
        if (this.zzbjq == null) {
            this.zzbjq = Collections.unmodifiableMap(new HashMap(this.zzbjp));
        }
        return this.zzbjq;
    }
}
