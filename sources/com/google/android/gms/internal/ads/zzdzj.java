package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzj<F, T> extends AbstractSequentialList<T> implements Serializable {
    private final List<F> zzibd;
    final zzdxw<? super F, ? extends T> zzibe;

    zzdzj(List<F> list, zzdxw<? super F, ? extends T> zzdxw) {
        this.zzibd = (List) zzdyi.checkNotNull(list);
        this.zzibe = (zzdxw) zzdyi.checkNotNull(zzdxw);
    }

    public final void clear() {
        this.zzibd.clear();
    }

    public final int size() {
        return this.zzibd.size();
    }

    public final ListIterator<T> listIterator(int i) {
        return new zzdzm(this, this.zzibd.listIterator(i));
    }
}
