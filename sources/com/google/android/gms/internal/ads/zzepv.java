package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepv implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzepn zzixv;
    private Iterator<Map.Entry<K, V>> zzixw;
    private boolean zziya;

    private zzepv(zzepn zzepn) {
        this.zzixv = zzepn;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzixv.zzixq.size() || (!this.zzixv.zzixr.isEmpty() && zzblu().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zziya) {
            this.zziya = false;
            this.zzixv.zzbls();
            if (this.pos < this.zzixv.zzixq.size()) {
                zzepn zzepn = this.zzixv;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzepn.zzid(i);
                return;
            }
            zzblu().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzblu() {
        if (this.zzixw == null) {
            this.zzixw = this.zzixv.zzixr.entrySet().iterator();
        }
        return this.zzixw;
    }

    public final /* synthetic */ Object next() {
        this.zziya = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzixv.zzixq.size()) {
            return (Map.Entry) this.zzixv.zzixq.get(this.pos);
        }
        return (Map.Entry) zzblu().next();
    }

    /* synthetic */ zzepv(zzepn zzepn, zzepm zzepm) {
        this(zzepn);
    }
}
