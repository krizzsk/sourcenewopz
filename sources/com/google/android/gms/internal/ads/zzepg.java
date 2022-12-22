package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepg implements Iterator<zzelx> {
    private final ArrayDeque<zzepf> zzixd;
    private zzelx zzixe;

    private zzepg(zzelq zzelq) {
        if (zzelq instanceof zzepf) {
            zzepf zzepf = (zzepf) zzelq;
            ArrayDeque<zzepf> arrayDeque = new ArrayDeque<>(zzepf.zzbhl());
            this.zzixd = arrayDeque;
            arrayDeque.push(zzepf);
            this.zzixe = zzal(zzepf.zziwz);
            return;
        }
        this.zzixd = null;
        this.zzixe = (zzelx) zzelq;
    }

    private final zzelx zzal(zzelq zzelq) {
        while (zzelq instanceof zzepf) {
            zzepf zzepf = (zzepf) zzelq;
            this.zzixd.push(zzepf);
            zzelq = zzepf.zziwz;
        }
        return (zzelx) zzelq;
    }

    public final boolean hasNext() {
        return this.zzixe != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        zzelx zzelx;
        zzelx zzelx2 = this.zzixe;
        if (zzelx2 != null) {
            while (true) {
                ArrayDeque<zzepf> arrayDeque = this.zzixd;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    zzelx = zzal(this.zzixd.pop().zzixa);
                    if (!zzelx.isEmpty()) {
                        break;
                    }
                } else {
                    zzelx = null;
                }
            }
            zzelx = null;
            this.zzixe = zzelx;
            return zzelx2;
        }
        throw new NoSuchElementException();
    }

    /* synthetic */ zzepg(zzelq zzelq, zzepe zzepe) {
        this(zzelq);
    }
}
