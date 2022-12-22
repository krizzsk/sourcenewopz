package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzf extends zzdzx<T> {
    private boolean zziba;
    private final /* synthetic */ Object zzibb;

    zzdzf(Object obj) {
        this.zzibb = obj;
    }

    public final boolean hasNext() {
        return !this.zziba;
    }

    public final T next() {
        if (!this.zziba) {
            this.zziba = true;
            return this.zzibb;
        }
        throw new NoSuchElementException();
    }
}
