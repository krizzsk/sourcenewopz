package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeqe implements ListIterator<String> {
    private final /* synthetic */ int zzicz;
    private ListIterator<String> zziyf = this.zziyg.zziyh.listIterator(this.zzicz);
    private final /* synthetic */ zzeqf zziyg;

    zzeqe(zzeqf zzeqf, int i) {
        this.zziyg = zzeqf;
        this.zzicz = i;
    }

    public final boolean hasNext() {
        return this.zziyf.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zziyf.hasPrevious();
    }

    public final int nextIndex() {
        return this.zziyf.nextIndex();
    }

    public final int previousIndex() {
        return this.zziyf.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zziyf.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zziyf.next();
    }
}
