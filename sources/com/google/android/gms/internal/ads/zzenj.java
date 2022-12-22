package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzenj<F, T> extends AbstractList<T> {
    private final List<F> zzibd;
    private final zzeni<F, T> zziuh;

    public zzenj(List<F> list, zzeni<F, T> zzeni) {
        this.zzibd = list;
        this.zziuh = zzeni;
    }

    public final T get(int i) {
        return this.zziuh.convert(this.zzibd.get(i));
    }

    public final int size() {
        return this.zzibd.size();
    }
}
