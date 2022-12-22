package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzelo extends zzelk<Boolean> implements zzenk<Boolean>, zzeoz, RandomAccess {
    private static final zzelo zzioz;
    private int size;
    private boolean[] zzipa;

    zzelo() {
        this(new boolean[10], 0);
    }

    private zzelo(boolean[] zArr, int i) {
        this.zzipa = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbhf();
        if (i2 >= i) {
            boolean[] zArr = this.zzipa;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzelo)) {
            return super.equals(obj);
        }
        zzelo zzelo = (zzelo) obj;
        if (this.size != zzelo.size) {
            return false;
        }
        boolean[] zArr = zzelo.zzipa;
        for (int i = 0; i < this.size; i++) {
            if (this.zzipa[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzenc.zzby(this.zzipa[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzipa[i] == booleanValue) {
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

    public final void addBoolean(boolean z) {
        zzbhf();
        int i = this.size;
        boolean[] zArr = this.zzipa;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzipa = zArr2;
        }
        boolean[] zArr3 = this.zzipa;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbhf();
        zzenc.checkNotNull(collection);
        if (!(collection instanceof zzelo)) {
            return super.addAll(collection);
        }
        zzelo zzelo = (zzelo) collection;
        int i = zzelo.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzipa;
            if (i3 > zArr.length) {
                this.zzipa = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzelo.zzipa, 0, this.zzipa, this.size, zzelo.size);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbhf();
        zzge(i);
        boolean[] zArr = this.zzipa;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzbhf();
        zzge(i);
        boolean[] zArr = this.zzipa;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbhf();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
        boolean[] zArr = this.zzipa;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzipa, i, zArr2, i + 1, this.size - i);
            this.zzipa = zArr2;
        }
        this.zzipa[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }

    public final /* synthetic */ zzenk zzgg(int i) {
        if (i >= this.size) {
            return new zzelo(Arrays.copyOf(this.zzipa, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzge(i);
        return Boolean.valueOf(this.zzipa[i]);
    }

    static {
        zzelo zzelo = new zzelo(new boolean[0], 0);
        zzioz = zzelo;
        zzelo.zzbhe();
    }
}
