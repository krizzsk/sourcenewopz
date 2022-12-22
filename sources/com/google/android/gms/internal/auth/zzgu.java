package com.google.android.gms.internal.auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzgu extends AbstractList<String> implements zzfa, RandomAccess {
    /* access modifiers changed from: private */
    public final zzfa zza;

    public zzgu(zzfa zzfa) {
        this.zza = zzfa;
    }

    public final /* synthetic */ Object get(int i) {
        return ((zzez) this.zza).get(i);
    }

    public final Iterator<String> iterator() {
        return new zzgt(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzgs(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzfa zze() {
        return this;
    }

    public final List<?> zzg() {
        return this.zza.zzg();
    }
}
