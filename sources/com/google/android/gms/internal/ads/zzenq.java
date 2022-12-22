package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzenq<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzeno> zziux;

    private zzenq(Map.Entry<K, zzeno> entry) {
        this.zziux = entry;
    }

    public final K getKey() {
        return this.zziux.getKey();
    }

    public final Object getValue() {
        if (this.zziux.getValue() == null) {
            return null;
        }
        return zzeno.zzbki();
    }

    public final zzeno zzbkk() {
        return this.zziux.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzeon) {
            return this.zziux.getValue().zzn((zzeon) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
