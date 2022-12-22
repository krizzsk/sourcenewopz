package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzerq<E> extends AbstractList<E> {
    private static final zzers zzdc = zzers.zzp(zzerq.class);
    List<E> zzjen;
    Iterator<E> zzjeo;

    public zzerq(List<E> list, Iterator<E> it) {
        this.zzjen = list;
        this.zzjeo = it;
    }

    public E get(int i) {
        if (this.zzjen.size() > i) {
            return this.zzjen.get(i);
        }
        if (this.zzjeo.hasNext()) {
            this.zzjen.add(this.zzjeo.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new zzert(this);
    }

    public int size() {
        zzdc.zzip("potentially expensive size() call");
        zzdc.zzip("blowup running");
        while (this.zzjeo.hasNext()) {
            this.zzjen.add(this.zzjeo.next());
        }
        return this.zzjen.size();
    }
}
