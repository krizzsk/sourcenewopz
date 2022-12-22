package com.squareup.haha.trove;

import com.squareup.haha.guava.base.Joiner;

public class TLongObjectHashMap<V> extends THash implements TLongHashingStrategy {
    protected final TLongHashingStrategy _hashingStrategy = this;
    private transient long[] _set;
    private transient V[] _values;

    public final int computeHashCode(long j) {
        return (int) (j ^ (j >> 32));
    }

    /* access modifiers changed from: protected */
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = (Object[]) new Object[up];
        this._set = new long[up];
        return up;
    }

    /* access modifiers changed from: protected */
    public int capacity() {
        return this._values.length;
    }

    public final V put(long j, V v) {
        V v2;
        int insertionIndex = insertionIndex(j);
        boolean z = true;
        boolean z2 = false;
        if (insertionIndex < 0) {
            insertionIndex = (-insertionIndex) - 1;
            v2 = unwrapNull(this._values[insertionIndex]);
            z = false;
        } else {
            z2 = isFree(this._values, insertionIndex);
            v2 = null;
        }
        this._set[insertionIndex] = j;
        V[] vArr = this._values;
        if (v == null) {
            v = TObjectHash.NULL;
        }
        vArr[insertionIndex] = v;
        if (z) {
            postInsertHook(z2);
        }
        return v2;
    }

    /* access modifiers changed from: protected */
    public void rehash(int i) {
        long[] jArr = this._set;
        int length = jArr.length;
        V[] vArr = this._values;
        this._set = new long[i];
        this._values = (Object[]) new Object[i];
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                if (isFull(vArr, i2)) {
                    long j = jArr[i2];
                    int insertionIndex = insertionIndex(j);
                    this._set[insertionIndex] = j;
                    this._values[insertionIndex] = vArr[i2];
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    public final V get(long j) {
        int index = index(j);
        if (index < 0) {
            return null;
        }
        return unwrapNull(this._values[index]);
    }

    private static <V> V unwrapNull(V v) {
        if (v == TObjectHash.NULL) {
            return null;
        }
        return v;
    }

    public void clear() {
        super.clear();
        long[] jArr = this._set;
        V[] vArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                jArr[i] = 0;
                vArr[i] = null;
                length = i;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int index(long j) {
        long[] jArr = this._set;
        V[] vArr = this._values;
        int length = jArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(j) & Integer.MAX_VALUE;
        int i = computeHashCode % length;
        if (!isFree(vArr, i) && (isRemoved(vArr, i) || jArr[i] != j)) {
            int i2 = (computeHashCode % (length - 2)) + 1;
            while (true) {
                i -= i2;
                if (i < 0) {
                    i += length;
                }
                if (isFree(vArr, i) || (!isRemoved(vArr, i) && jArr[i] == j)) {
                    break;
                }
            }
        }
        if (isFree(vArr, i)) {
            return -1;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int insertionIndex(long r11) {
        /*
            r10 = this;
            V[] r0 = r10._values
            long[] r1 = r10._set
            int r2 = r1.length
            com.squareup.haha.trove.TLongHashingStrategy r3 = r10._hashingStrategy
            int r3 = r3.computeHashCode(r11)
            r4 = 2147483647(0x7fffffff, float:NaN)
            r3 = r3 & r4
            int r4 = r3 % r2
            boolean r5 = isFree(r0, r4)
            if (r5 == 0) goto L_0x0018
            return r4
        L_0x0018:
            boolean r5 = isFull(r0, r4)
            if (r5 == 0) goto L_0x0028
            r5 = r1[r4]
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0028
        L_0x0024:
            int r11 = -r4
            int r11 = r11 + -1
            return r11
        L_0x0028:
            int r5 = r2 + -2
            int r3 = r3 % r5
            int r3 = r3 + 1
            boolean r5 = isRemoved(r0, r4)
            r6 = -1
            if (r5 == 0) goto L_0x0036
            r5 = r4
            goto L_0x0037
        L_0x0036:
            r5 = -1
        L_0x0037:
            int r4 = r4 - r3
            if (r4 >= 0) goto L_0x003b
            int r4 = r4 + r2
        L_0x003b:
            if (r5 != r6) goto L_0x0044
            boolean r7 = isRemoved(r0, r4)
            if (r7 == 0) goto L_0x0044
            r5 = r4
        L_0x0044:
            boolean r7 = isFull(r0, r4)
            if (r7 == 0) goto L_0x0050
            r7 = r1[r4]
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x0037
        L_0x0050:
            boolean r7 = isRemoved(r0, r4)
            if (r7 == 0) goto L_0x006d
        L_0x0056:
            boolean r7 = isFree(r0, r4)
            if (r7 != 0) goto L_0x006d
            boolean r7 = isRemoved(r0, r4)
            if (r7 != 0) goto L_0x0068
            r7 = r1[r4]
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x006d
        L_0x0068:
            int r4 = r4 - r3
            if (r4 >= 0) goto L_0x0056
            int r4 = r4 + r2
            goto L_0x0056
        L_0x006d:
            boolean r11 = isFull(r0, r4)
            if (r11 == 0) goto L_0x0074
            goto L_0x0024
        L_0x0074:
            if (r5 != r6) goto L_0x0077
            return r4
        L_0x0077:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.trove.TLongObjectHashMap.insertionIndex(long):int");
    }

    private static boolean isFull(Object[] objArr, int i) {
        Object obj = objArr[i];
        return (obj == null || obj == TObjectHash.REMOVED) ? false : true;
    }

    private static boolean isRemoved(Object[] objArr, int i) {
        return objArr[i] == TObjectHash.REMOVED;
    }

    private static boolean isFree(Object[] objArr, int i) {
        return objArr[i] == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TLongObjectHashMap)) {
            return false;
        }
        TLongObjectHashMap tLongObjectHashMap = (TLongObjectHashMap) obj;
        if (tLongObjectHashMap.size() != size()) {
            return false;
        }
        return forEachEntry(new EqProcedure(tLongObjectHashMap));
    }

    public int hashCode() {
        HashProcedure hashProcedure = new HashProcedure();
        forEachEntry(hashProcedure);
        return hashProcedure.f56032h;
    }

    final class HashProcedure implements TLongObjectProcedure<V> {

        /* renamed from: h */
        int f56032h;

        HashProcedure() {
        }

        public final boolean execute(long j, V v) {
            this.f56032h += TLongObjectHashMap.this._hashingStrategy.computeHashCode(j) ^ Joiner.hash(v);
            return true;
        }
    }

    static final class EqProcedure<V> implements TLongObjectProcedure<V> {
        private final TLongObjectHashMap<V> _otherMap;

        EqProcedure(TLongObjectHashMap<V> tLongObjectHashMap) {
            this._otherMap = tLongObjectHashMap;
        }

        public final boolean execute(long j, V v) {
            if (this._otherMap.index(j) >= 0) {
                V v2 = this._otherMap.get(j);
                if (v == v2 || (v != null && v.equals(v2))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void removeAt(int i) {
        this._values[i] = TObjectHash.REMOVED;
        super.removeAt(i);
    }

    public final Object[] getValues() {
        Object[] objArr = new Object[size()];
        V[] vArr = this._values;
        int length = vArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return objArr;
            }
            if (isFull(vArr, i2)) {
                objArr[i] = unwrapNull(vArr[i2]);
                i++;
            }
            length = i2;
        }
    }

    public final boolean forEachValue(TObjectProcedure<V> tObjectProcedure) {
        V[] vArr = this._values;
        int length = vArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (isFull(vArr, i) && !tObjectProcedure.execute(unwrapNull(vArr[i]))) {
                return false;
            }
            length = i;
        }
    }

    private boolean forEachEntry(TLongObjectProcedure<V> tLongObjectProcedure) {
        long[] jArr = this._set;
        V[] vArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (isFull(vArr, i) && !tLongObjectProcedure.execute(jArr[i], unwrapNull(vArr[i]))) {
                return false;
            }
            length = i;
        }
    }

    public /* bridge */ /* synthetic */ Object clone() {
        TLongObjectHashMap tLongObjectHashMap = (TLongObjectHashMap) super.clone();
        tLongObjectHashMap._values = (Object[]) this._values.clone();
        return tLongObjectHashMap;
    }
}
