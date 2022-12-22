package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzent<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzivb;

    public zzent(Iterator<Map.Entry<K, Object>> it) {
        this.zzivb = it;
    }

    public final boolean hasNext() {
        return this.zzivb.hasNext();
    }

    public final void remove() {
        this.zzivb.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzivb.next();
        return next.getValue() instanceof zzeno ? new zzenq(next) : next;
    }
}
