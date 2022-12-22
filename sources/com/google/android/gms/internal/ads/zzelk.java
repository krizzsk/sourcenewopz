package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
abstract class zzelk<E> extends AbstractList<E> implements zzenk<E> {
    private boolean zzior = true;

    zzelk() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzbhf();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzbhf();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzbhf();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzbhf();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzbhf();
        super.clear();
    }

    public boolean zzbhd() {
        return this.zzior;
    }

    public final void zzbhe() {
        this.zzior = false;
    }

    public E remove(int i) {
        zzbhf();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzbhf();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        zzbhf();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzbhf();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzbhf();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzbhf() {
        if (!this.zzior) {
            throw new UnsupportedOperationException();
        }
    }
}
