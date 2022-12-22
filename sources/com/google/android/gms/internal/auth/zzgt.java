package com.google.android.gms.internal.auth;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzgt implements Iterator<String> {
    final Iterator<String> zza = this.zzb.zza.iterator();
    final /* synthetic */ zzgu zzb;

    zzgt(zzgu zzgu) {
        this.zzb = zzgu;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
