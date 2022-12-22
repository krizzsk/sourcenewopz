package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzemz extends zzelk<Float> implements zzenk<Float>, zzeoz, RandomAccess {
    private static final zzemz zzitl;
    private int size;
    private float[] zzitm;

    zzemz() {
        this(new float[10], 0);
    }

    private zzemz(float[] fArr, int i) {
        this.zzitm = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbhf();
        if (i2 >= i) {
            float[] fArr = this.zzitm;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzemz)) {
            return super.equals(obj);
        }
        zzemz zzemz = (zzemz) obj;
        if (this.size != zzemz.size) {
            return false;
        }
        float[] fArr = zzemz.zzitm;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzitm[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzitm[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzitm[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.size;
    }

    public final void zzh(float f) {
        zzbhf();
        int i = this.size;
        float[] fArr = this.zzitm;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzitm = fArr2;
        }
        float[] fArr3 = this.zzitm;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzbhf();
        zzenc.checkNotNull(collection);
        if (!(collection instanceof zzemz)) {
            return super.addAll(collection);
        }
        zzemz zzemz = (zzemz) collection;
        int i = zzemz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzitm;
            if (i3 > fArr.length) {
                this.zzitm = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzemz.zzitm, 0, this.zzitm, this.size, zzemz.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    private final void zzge(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
    }

    private final String zzgf(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbhf();
        zzge(i);
        float[] fArr = this.zzitm;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzbhf();
        zzge(i);
        float[] fArr = this.zzitm;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        zzbhf();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
        float[] fArr = this.zzitm;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzitm, i, fArr2, i + 1, this.size - i);
            this.zzitm = fArr2;
        }
        this.zzitm[i] = floatValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ zzenk zzgg(int i) {
        if (i >= this.size) {
            return new zzemz(Arrays.copyOf(this.zzitm, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzge(i);
        return Float.valueOf(this.zzitm[i]);
    }

    static {
        zzemz zzemz = new zzemz(new float[0], 0);
        zzitl = zzemz;
        zzemz.zzbhe();
    }
}
