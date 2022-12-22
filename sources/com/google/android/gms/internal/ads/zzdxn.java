package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
abstract class zzdxn<T> implements Iterator<T> {
    private int zzhyn = zzdxp.zzhyq;
    @NullableDecl
    private T zzhyo;

    protected zzdxn() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzazz();

    /* access modifiers changed from: protected */
    @NullableDecl
    public final T zzbaa() {
        this.zzhyn = zzdxp.zzhyr;
        return null;
    }

    public final boolean hasNext() {
        if (this.zzhyn != zzdxp.zzhys) {
            int i = zzdxm.zzhym[this.zzhyn - 1];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
            this.zzhyn = zzdxp.zzhys;
            this.zzhyo = zzazz();
            if (this.zzhyn == zzdxp.zzhyr) {
                return false;
            }
            this.zzhyn = zzdxp.zzhyp;
            return true;
        }
        throw new IllegalStateException();
    }

    public final T next() {
        if (hasNext()) {
            this.zzhyn = zzdxp.zzhyq;
            T t = this.zzhyo;
            this.zzhyo = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
