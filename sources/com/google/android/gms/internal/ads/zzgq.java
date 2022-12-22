package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgq<T> {
    private final Map<String, AtomicReference<T>> zzacd = new HashMap();

    public final AtomicReference<T> zzas(String str) {
        synchronized (this) {
            if (!this.zzacd.containsKey(str)) {
                this.zzacd.put(str, new AtomicReference());
            }
        }
        return this.zzacd.get(str);
    }
}
