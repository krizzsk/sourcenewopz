package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
abstract class zzdzv<F, T> implements Iterator<T> {
    final Iterator<? extends F> zzibs;

    zzdzv(Iterator<? extends F> it) {
        this.zzibs = (Iterator) zzdyi.checkNotNull(it);
    }

    /* access modifiers changed from: package-private */
    public abstract T zzae(F f);

    public final boolean hasNext() {
        return this.zzibs.hasNext();
    }

    public final T next() {
        return zzae(this.zzibs.next());
    }

    public final void remove() {
        this.zzibs.remove();
    }
}
