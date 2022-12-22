package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
abstract class zzdzy<F, T> extends zzdzv<F, T> implements ListIterator<T> {
    zzdzy(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    public final boolean hasPrevious() {
        return ((ListIterator) this.zzibs).hasPrevious();
    }

    public final T previous() {
        return zzae(((ListIterator) this.zzibs).previous());
    }

    public final int nextIndex() {
        return ((ListIterator) this.zzibs).nextIndex();
    }

    public final int previousIndex() {
        return ((ListIterator) this.zzibs).previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
