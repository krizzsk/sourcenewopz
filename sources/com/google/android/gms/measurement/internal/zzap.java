package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzap implements Iterator<String> {
    final Iterator<String> zza = this.zzb.zza.keySet().iterator();
    final /* synthetic */ zzaq zzb;

    zzap(zzaq zzaq) {
        this.zzb = zzaq;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return this.zza.next();
    }
}
