package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeqh implements Iterator<String> {
    private final /* synthetic */ zzeqf zziyg;
    private Iterator<String> zzizc = this.zziyg.zziyh.iterator();

    zzeqh(zzeqf zzeqf) {
        this.zziyg = zzeqf;
    }

    public final boolean hasNext() {
        return this.zzizc.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzizc.next();
    }
}
