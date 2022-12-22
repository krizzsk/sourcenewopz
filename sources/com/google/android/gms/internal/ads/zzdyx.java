package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzdyx<E> {
    zzdyx() {
    }

    public abstract zzdyx<E> zzaa(E e);

    public zzdyx<E> zzg(Iterable<? extends E> iterable) {
        for (Object zzaa : iterable) {
            zzaa(zzaa);
        }
        return this;
    }

    public zzdyx<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }
}
