package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzend extends zzelk<Integer> implements zzeng, zzeoz, RandomAccess {
    private static final zzend zziuf;
    private int size;
    private int[] zziug;

    public static zzend zzbjy() {
        return zziuf;
    }

    zzend() {
        this(new int[10], 0);
    }

    private zzend(int[] iArr, int i) {
        this.zziug = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbhf();
        if (i2 >= i) {
            int[] iArr = this.zziug;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
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
        if (!(obj instanceof zzend)) {
            return super.equals(obj);
        }
        zzend zzend = (zzend) obj;
        if (this.size != zzend.size) {
            return false;
        }
        int[] iArr = zzend.zziug;
        for (int i = 0; i < this.size; i++) {
            if (this.zziug[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zziug[i2];
        }
        return i;
    }

    /* renamed from: zzho */
    public final zzeng zzgg(int i) {
        if (i >= this.size) {
            return new zzend(Arrays.copyOf(this.zziug, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzge(i);
        return this.zziug[i];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zziug[i] == intValue) {
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

    public final void zzhp(int i) {
        zzbhf();
        int i2 = this.size;
        int[] iArr = this.zziug;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zziug = iArr2;
        }
        int[] iArr3 = this.zziug;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbhf();
        zzenc.checkNotNull(collection);
        if (!(collection instanceof zzend)) {
            return super.addAll(collection);
        }
        zzend zzend = (zzend) collection;
        int i = zzend.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zziug;
            if (i3 > iArr.length) {
                this.zziug = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzend.zziug, 0, this.zziug, this.size, zzend.size);
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
        int intValue = ((Integer) obj).intValue();
        zzbhf();
        zzge(i);
        int[] iArr = this.zziug;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzbhf();
        zzge(i);
        int[] iArr = this.zziug;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zzbhf();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
        int[] iArr = this.zziug;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zziug, i, iArr2, i + 1, this.size - i);
            this.zziug = iArr2;
        }
        this.zziug[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzhp(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzend zzend = new zzend(new int[0], 0);
        zziuf = zzend;
        zzend.zzbhe();
    }
}
