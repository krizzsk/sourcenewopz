package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzert implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzerq zzjep;

    zzert(zzerq zzerq) {
        this.zzjep = zzerq;
    }

    public final boolean hasNext() {
        return this.pos < this.zzjep.zzjen.size() || this.zzjep.zzjeo.hasNext();
    }

    public final E next() {
        while (this.pos >= this.zzjep.zzjen.size()) {
            this.zzjep.zzjen.add(this.zzjep.zzjeo.next());
        }
        List<E> list = this.zzjep.zzjen;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
