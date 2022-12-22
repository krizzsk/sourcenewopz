package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeob extends zzelk<Long> implements zzenl, zzeoz, RandomAccess {
    private static final zzeob zzivk;
    private int size;
    private long[] zzivl;

    public static zzeob zzbkq() {
        return zzivk;
    }

    zzeob() {
        this(new long[10], 0);
    }

    private zzeob(long[] jArr, int i) {
        this.zzivl = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbhf();
        if (i2 >= i) {
            long[] jArr = this.zzivl;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
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
        if (!(obj instanceof zzeob)) {
            return super.equals(obj);
        }
        zzeob zzeob = (zzeob) obj;
        if (this.size != zzeob.size) {
            return false;
        }
        long[] jArr = zzeob.zzivl;
        for (int i = 0; i < this.size; i++) {
            if (this.zzivl[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzenc.zzfr(this.zzivl[i2]);
        }
        return i;
    }

    /* renamed from: zzhq */
    public final zzenl zzgg(int i) {
        if (i >= this.size) {
            return new zzeob(Arrays.copyOf(this.zzivl, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final long getLong(int i) {
        zzge(i);
        return this.zzivl[i];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzivl[i] == longValue) {
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

    public final void zzfs(long j) {
        zzbhf();
        int i = this.size;
        long[] jArr = this.zzivl;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzivl = jArr2;
        }
        long[] jArr3 = this.zzivl;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzbhf();
        zzenc.checkNotNull(collection);
        if (!(collection instanceof zzeob)) {
            return super.addAll(collection);
        }
        zzeob zzeob = (zzeob) collection;
        int i = zzeob.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzivl;
            if (i3 > jArr.length) {
                this.zzivl = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzeob.zzivl, 0, this.zzivl, this.size, zzeob.size);
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
        long longValue = ((Long) obj).longValue();
        zzbhf();
        zzge(i);
        long[] jArr = this.zzivl;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzbhf();
        zzge(i);
        long[] jArr = this.zzivl;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzbhf();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
        long[] jArr = this.zzivl;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzivl, i, jArr2, i + 1, this.size - i);
            this.zzivl = jArr2;
        }
        this.zzivl[i] = longValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzfs(((Long) obj).longValue());
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzeob zzeob = new zzeob(new long[0], 0);
        zzivk = zzeob;
        zzeob.zzbhe();
    }
}
