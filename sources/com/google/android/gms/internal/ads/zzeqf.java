package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzeqf extends AbstractList<String> implements zzenu, RandomAccess {
    /* access modifiers changed from: private */
    public final zzenu zziyh;

    public zzeqf(zzenu zzenu) {
        this.zziyh = zzenu;
    }

    public final zzenu zzbkm() {
        return this;
    }

    public final Object zzhr(int i) {
        return this.zziyh.zzhr(i);
    }

    public final int size() {
        return this.zziyh.size();
    }

    public final void zzak(zzelq zzelq) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzeqe(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzeqh(this);
    }

    public final List<?> zzbkl() {
        return this.zziyh.zzbkl();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zziyh.get(i);
    }
}
