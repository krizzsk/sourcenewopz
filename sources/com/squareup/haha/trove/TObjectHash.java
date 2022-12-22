package com.squareup.haha.trove;

public abstract class TObjectHash<T> extends THash implements TObjectHashingStrategy<T> {
    public static final NULL NULL = new NULL();
    public static final Object REMOVED = new Object();
    protected final TObjectHashingStrategy<T> _hashingStrategy;
    protected transient Object[] _set;

    static class NULL {
        NULL() {
        }
    }

    public TObjectHash() {
        this._hashingStrategy = this;
    }

    public TObjectHash(TObjectHashingStrategy<T> tObjectHashingStrategy) {
        this._hashingStrategy = tObjectHashingStrategy;
    }

    public TObjectHash(int i) {
        super(i);
        this._hashingStrategy = this;
    }

    public TObjectHash(int i, TObjectHashingStrategy<T> tObjectHashingStrategy) {
        super(i);
        this._hashingStrategy = tObjectHashingStrategy;
    }

    public TObjectHash(int i, float f) {
        super(i, f);
        this._hashingStrategy = this;
    }

    public TObjectHash(int i, float f, TObjectHashingStrategy<T> tObjectHashingStrategy) {
        super(i, f);
        this._hashingStrategy = tObjectHashingStrategy;
    }

    public TObjectHash<T> clone() {
        TObjectHash<T> tObjectHash = (TObjectHash) super.clone();
        tObjectHash._set = (Object[]) this._set.clone();
        return tObjectHash;
    }

    /* access modifiers changed from: protected */
    public int capacity() {
        return this._set.length;
    }

    /* access modifiers changed from: protected */
    public void removeAt(int i) {
        this._set[i] = REMOVED;
        super.removeAt(i);
    }

    /* access modifiers changed from: protected */
    public int setUp(int i) {
        int up = super.setUp(i);
        this._set = new Object[up];
        return up;
    }

    public boolean forEach(TObjectProcedure<T> tObjectProcedure) {
        Object[] objArr = this._set;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != null && objArr[i] != REMOVED && !tObjectProcedure.execute(objArr[i])) {
                return false;
            }
            length = i;
        }
    }

    public boolean contains(Object obj) {
        return index(obj) >= 0;
    }

    /* access modifiers changed from: protected */
    public int index(T t) {
        Object[] objArr = this._set;
        int length = objArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(t) & Integer.MAX_VALUE;
        int i = computeHashCode % length;
        Object obj = objArr[i];
        if (obj != null && (obj == REMOVED || !this._hashingStrategy.equals(obj, t))) {
            int i2 = (computeHashCode % (length - 2)) + 1;
            while (true) {
                i -= i2;
                if (i < 0) {
                    i += length;
                }
                obj = objArr[i];
                if (obj == null || (obj != REMOVED && this._hashingStrategy.equals(obj, t))) {
                    break;
                }
            }
        }
        if (obj == null) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int insertionIndex(T r9) {
        /*
            r8 = this;
            java.lang.Object[] r0 = r8._set
            int r1 = r0.length
            com.squareup.haha.trove.TObjectHashingStrategy<T> r2 = r8._hashingStrategy
            int r2 = r2.computeHashCode(r9)
            r3 = 2147483647(0x7fffffff, float:NaN)
            r2 = r2 & r3
            int r3 = r2 % r1
            r4 = r0[r3]
            if (r4 != 0) goto L_0x0014
            return r3
        L_0x0014:
            java.lang.Object r5 = REMOVED
            if (r4 == r5) goto L_0x0024
            com.squareup.haha.trove.TObjectHashingStrategy<T> r5 = r8._hashingStrategy
            boolean r5 = r5.equals(r4, r9)
            if (r5 == 0) goto L_0x0024
        L_0x0020:
            int r9 = -r3
            int r9 = r9 + -1
            return r9
        L_0x0024:
            int r5 = r1 + -2
            int r2 = r2 % r5
            int r2 = r2 + 1
            java.lang.Object r5 = REMOVED
            r6 = -1
            if (r4 != r5) goto L_0x0030
            r4 = r3
            goto L_0x0031
        L_0x0030:
            r4 = -1
        L_0x0031:
            int r3 = r3 - r2
            if (r3 >= 0) goto L_0x0035
            int r3 = r3 + r1
        L_0x0035:
            r5 = r0[r3]
            if (r4 != r6) goto L_0x003e
            java.lang.Object r7 = REMOVED
            if (r5 != r7) goto L_0x003e
            r4 = r3
        L_0x003e:
            if (r5 == 0) goto L_0x004c
            java.lang.Object r7 = REMOVED
            if (r5 == r7) goto L_0x004c
            com.squareup.haha.trove.TObjectHashingStrategy<T> r7 = r8._hashingStrategy
            boolean r7 = r7.equals(r5, r9)
            if (r7 == 0) goto L_0x0031
        L_0x004c:
            java.lang.Object r7 = REMOVED
            if (r5 != r7) goto L_0x0065
        L_0x0050:
            if (r5 == 0) goto L_0x0065
            java.lang.Object r7 = REMOVED
            if (r5 == r7) goto L_0x005e
            com.squareup.haha.trove.TObjectHashingStrategy<T> r7 = r8._hashingStrategy
            boolean r7 = r7.equals(r5, r9)
            if (r7 != 0) goto L_0x0065
        L_0x005e:
            int r3 = r3 - r2
            if (r3 >= 0) goto L_0x0062
            int r3 = r3 + r1
        L_0x0062:
            r5 = r0[r3]
            goto L_0x0050
        L_0x0065:
            if (r5 == 0) goto L_0x006c
            java.lang.Object r9 = REMOVED
            if (r5 == r9) goto L_0x006c
            goto L_0x0020
        L_0x006c:
            if (r4 != r6) goto L_0x006f
            return r3
        L_0x006f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.trove.TObjectHash.insertionIndex(java.lang.Object):int");
    }

    public final int computeHashCode(T t) {
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public final boolean equals(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }

    /* access modifiers changed from: protected */
    public final void throwObjectContractViolation(Object obj, Object obj2) throws IllegalArgumentException {
        String str;
        StringBuilder sb = new StringBuilder("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals() or TObjectHashingStrategy.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =");
        sb.append(obj);
        String str2 = "";
        if (obj == null) {
            str = str2;
        } else {
            str = " (" + obj.getClass() + ")";
        }
        sb.append(str);
        sb.append(", hashCode=");
        sb.append(this._hashingStrategy.computeHashCode(obj));
        sb.append("; object #2 =");
        sb.append(obj2);
        if (obj2 != null) {
            str2 = " (" + obj2.getClass() + ")";
        }
        sb.append(str2);
        sb.append(", hashCode=");
        sb.append(this._hashingStrategy.computeHashCode(obj2));
        throw new IllegalArgumentException(sb.toString());
    }
}
