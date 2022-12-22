package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
class zzdyy<E> extends zzdyx<E> {
    int size = 0;
    Object[] zziaq;
    boolean zziar;

    zzdyy(int i) {
        zzdyu.zzh(i, "initialCapacity");
        this.zziaq = new Object[i];
    }

    private final void zzey(int i) {
        Object[] objArr = this.zziaq;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.zziaq = Arrays.copyOf(objArr, i2);
                this.zziar = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.zziar) {
            this.zziaq = (Object[]) objArr.clone();
            this.zziar = false;
        }
    }

    /* renamed from: zzab */
    public zzdyy<E> zzaa(E e) {
        zzdyi.checkNotNull(e);
        zzey(this.size + 1);
        Object[] objArr = this.zziaq;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return this;
    }

    public zzdyx<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzey(this.size + collection.size());
            if (collection instanceof zzdyv) {
                this.size = ((zzdyv) collection).zza(this.zziaq, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
