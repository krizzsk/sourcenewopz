package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzh<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final List<F> zzibd;
    final zzdxw<? super F, ? extends T> zzibe;

    zzdzh(List<F> list, zzdxw<? super F, ? extends T> zzdxw) {
        this.zzibd = (List) zzdyi.checkNotNull(list);
        this.zzibe = (zzdxw) zzdyi.checkNotNull(zzdxw);
    }

    public final void clear() {
        this.zzibd.clear();
    }

    public final T get(int i) {
        return this.zzibe.apply(this.zzibd.get(i));
    }

    public final Iterator<T> iterator() {
        return listIterator();
    }

    public final ListIterator<T> listIterator(int i) {
        return new zzdzk(this, this.zzibd.listIterator(i));
    }

    public final boolean isEmpty() {
        return this.zzibd.isEmpty();
    }

    public final T remove(int i) {
        return this.zzibe.apply(this.zzibd.remove(i));
    }

    public final int size() {
        return this.zzibd.size();
    }
}
