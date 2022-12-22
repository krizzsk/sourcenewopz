package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepp implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzepn zzixv;
    private Iterator<Map.Entry<K, V>> zzixw;

    private zzepp(zzepn zzepn) {
        this.zzixv = zzepn;
        this.pos = this.zzixv.zzixq.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzixv.zzixq.size()) || zzblu().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzblu() {
        if (this.zzixw == null) {
            this.zzixw = this.zzixv.zzixt.entrySet().iterator();
        }
        return this.zzixw;
    }

    public final /* synthetic */ Object next() {
        if (zzblu().hasNext()) {
            return (Map.Entry) zzblu().next();
        }
        List zzb = this.zzixv.zzixq;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzepp(zzepn zzepn, zzepm zzepm) {
        this(zzepn);
    }
}
