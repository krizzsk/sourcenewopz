package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
class zzepu extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzepn zzixv;

    private zzepu(zzepn zzepn) {
        this.zzixv = zzepn;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzepv(this.zzixv, (zzepm) null);
    }

    public int size() {
        return this.zzixv.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzixv.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzixv.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzixv.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzixv.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzepu(zzepn zzepn, zzepm zzepm) {
        this(zzepn);
    }
}
