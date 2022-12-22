package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzq<K, V> extends zzdzd<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    /* access modifiers changed from: private */
    public final transient Object[] zzibj;
    private final transient zzdze<K, V> zzibn;
    private final transient int zzibo = 0;

    zzdzq(zzdze<K, V> zzdze, Object[] objArr, int i, int i2) {
        this.zzibn = zzdze;
        this.zzibj = objArr;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbak() {
        return true;
    }

    public final zzdzx<Map.Entry<K, V>> zzbaf() {
        return (zzdzx) zzbaj().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzbaj().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final zzdza<Map.Entry<K, V>> zzban() {
        return new zzdzp(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zzibn.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
