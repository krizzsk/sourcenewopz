package com.squareup.haha.trove;

import com.squareup.haha.guava.base.Joiner;

public class TIntObjectHashMap<V> extends THash implements TIntHashingStrategy {
    protected final TIntHashingStrategy _hashingStrategy = this;
    private transient int[] _set;
    private transient V[] _values;

    public final int computeHashCode(int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = (Object[]) new Object[up];
        this._set = new int[up];
        return up;
    }

    /* access modifiers changed from: protected */
    public int capacity() {
        return this._values.length;
    }

    public final V put(int i, V v) {
        V v2;
        int insertionIndex = insertionIndex(i);
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
        this._set[insertionIndex] = i;
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
        int[] iArr = this._set;
        int length = iArr.length;
        V[] vArr = this._values;
        this._set = new int[i];
        this._values = (Object[]) new Object[i];
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                if (isFull(vArr, i2)) {
                    int i3 = iArr[i2];
                    int insertionIndex = insertionIndex(i3);
                    this._set[insertionIndex] = i3;
                    this._values[insertionIndex] = vArr[i2];
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    public final V get(int i) {
        int index = index(i);
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
        int[] iArr = this._set;
        V[] vArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                iArr[i] = 0;
                vArr[i] = null;
                length = i;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int index(int i) {
        int[] iArr = this._set;
        V[] vArr = this._values;
        int length = iArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(i) & Integer.MAX_VALUE;
        int i2 = computeHashCode % length;
        if (!isFree(vArr, i2) && (isRemoved(vArr, i2) || iArr[i2] != i)) {
            int i3 = (computeHashCode % (length - 2)) + 1;
            while (true) {
                i2 -= i3;
                if (i2 < 0) {
                    i2 += length;
                }
                if (isFree(vArr, i2) || (!isRemoved(vArr, i2) && iArr[i2] == i)) {
                    break;
                }
            }
        }
        if (isFree(vArr, i2)) {
            return -1;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int insertionIndex(int r9) {
        /*
            r8 = this;
            V[] r0 = r8._values
            int[] r1 = r8._set
            int r2 = r1.length
            com.squareup.haha.trove.TIntHashingStrategy r3 = r8._hashingStrategy
            int r3 = r3.computeHashCode(r9)
            r4 = 2147483647(0x7fffffff, float:NaN)
            r3 = r3 & r4
            int r4 = r3 % r2
            boolean r5 = isFree(r0, r4)
            if (r5 == 0) goto L_0x0018
            return r4
        L_0x0018:
            boolean r5 = isFull(r0, r4)
            if (r5 == 0) goto L_0x0026
            r5 = r1[r4]
            if (r5 != r9) goto L_0x0026
        L_0x0022:
            int r9 = -r4
            int r9 = r9 + -1
            return r9
        L_0x0026:
            int r5 = r2 + -2
            int r3 = r3 % r5
            int r3 = r3 + 1
            boolean r5 = isRemoved(r0, r4)
            r6 = -1
            if (r5 == 0) goto L_0x0034
            r5 = r4
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            int r4 = r4 - r3
            if (r4 >= 0) goto L_0x0039
            int r4 = r4 + r2
        L_0x0039:
            if (r5 != r6) goto L_0x0042
            boolean r7 = isRemoved(r0, r4)
            if (r7 == 0) goto L_0x0042
            r5 = r4
        L_0x0042:
            boolean r7 = isFull(r0, r4)
            if (r7 == 0) goto L_0x004c
            r7 = r1[r4]
            if (r7 != r9) goto L_0x0035
        L_0x004c:
            boolean r7 = isRemoved(r0, r4)
            if (r7 == 0) goto L_0x0067
        L_0x0052:
            boolean r7 = isFree(r0, r4)
            if (r7 != 0) goto L_0x0067
            boolean r7 = isRemoved(r0, r4)
            if (r7 != 0) goto L_0x0062
            r7 = r1[r4]
            if (r7 == r9) goto L_0x0067
        L_0x0062:
            int r4 = r4 - r3
            if (r4 >= 0) goto L_0x0052
            int r4 = r4 + r2
            goto L_0x0052
        L_0x0067:
            boolean r9 = isFull(r0, r4)
            if (r9 == 0) goto L_0x006e
            goto L_0x0022
        L_0x006e:
            if (r5 != r6) goto L_0x0071
            return r4
        L_0x0071:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.trove.TIntObjectHashMap.insertionIndex(int):int");
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
        if (!(obj instanceof TIntObjectHashMap)) {
            return false;
        }
        TIntObjectHashMap tIntObjectHashMap = (TIntObjectHashMap) obj;
        if (tIntObjectHashMap.size() != size()) {
            return false;
        }
        return forEachEntry(new EqProcedure(tIntObjectHashMap));
    }

    public int hashCode() {
        HashProcedure hashProcedure = new HashProcedure();
        forEachEntry(hashProcedure);
        return hashProcedure.f56030h;
    }

    final class HashProcedure implements TIntObjectProcedure<V> {

        /* renamed from: h */
        int f56030h;

        HashProcedure() {
        }

        public final boolean execute(int i, V v) {
            this.f56030h += TIntObjectHashMap.this._hashingStrategy.computeHashCode(i) ^ Joiner.hash(v);
            return true;
        }
    }

    static final class EqProcedure<V> implements TIntObjectProcedure<V> {
        private final TIntObjectHashMap<V> _otherMap;

        EqProcedure(TIntObjectHashMap<V> tIntObjectHashMap) {
            this._otherMap = tIntObjectHashMap;
        }

        public final boolean execute(int i, V v) {
            if (this._otherMap.index(i) >= 0) {
                V v2 = this._otherMap.get(i);
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

    public final int[] keys() {
        int[] iArr = new int[size()];
        int[] iArr2 = this._set;
        V[] vArr = this._values;
        int length = iArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return iArr;
            }
            if (isFull(vArr, i2)) {
                iArr[i] = iArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    private boolean forEachEntry(TIntObjectProcedure<V> tIntObjectProcedure) {
        int[] iArr = this._set;
        V[] vArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (isFull(vArr, i) && !tIntObjectProcedure.execute(iArr[i], unwrapNull(vArr[i]))) {
                return false;
            }
            length = i;
        }
    }

    public /* bridge */ /* synthetic */ Object clone() {
        TIntObjectHashMap tIntObjectHashMap = (TIntObjectHashMap) super.clone();
        tIntObjectHashMap._values = (Object[]) this._values.clone();
        return tIntObjectHashMap;
    }
}
