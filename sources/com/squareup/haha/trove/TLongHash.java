package com.squareup.haha.trove;

public abstract class TLongHash extends TPrimitiveHash implements TLongHashingStrategy {
    protected TLongHashingStrategy _hashingStrategy = this;
    protected transient long[] _set;

    public final int computeHashCode(long j) {
        return (int) (j ^ (j >> 32));
    }

    public Object clone() {
        TLongHash tLongHash = (TLongHash) super.clone();
        tLongHash._set = (long[]) this._set.clone();
        return tLongHash;
    }

    /* access modifiers changed from: protected */
    public int setUp(int i) {
        int up = super.setUp(i);
        this._set = new long[up];
        return up;
    }

    public final boolean forEach(TLongProcedure tLongProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tLongProcedure.execute(jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    /* access modifiers changed from: protected */
    public void removeAt(int i) {
        this._set[i] = 0;
        super.removeAt(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int insertionIndex(long r12) {
        /*
            r11 = this;
            byte[] r0 = r11._states
            long[] r1 = r11._set
            int r2 = r0.length
            com.squareup.haha.trove.TLongHashingStrategy r3 = r11._hashingStrategy
            int r3 = r3.computeHashCode(r12)
            r4 = 2147483647(0x7fffffff, float:NaN)
            r3 = r3 & r4
            int r4 = r3 % r2
            byte r5 = r0[r4]
            if (r5 != 0) goto L_0x0016
            return r4
        L_0x0016:
            byte r5 = r0[r4]
            r6 = 1
            if (r5 != r6) goto L_0x0024
            r7 = r1[r4]
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x0024
        L_0x0021:
            int r12 = -r4
        L_0x0022:
            int r12 = r12 - r6
            return r12
        L_0x0024:
            int r5 = r2 + -2
            int r3 = r3 % r5
            int r3 = r3 + r6
        L_0x0028:
            int r4 = r4 - r3
            if (r4 >= 0) goto L_0x002c
            int r4 = r4 + r2
        L_0x002c:
            byte r5 = r0[r4]
            if (r5 != r6) goto L_0x0036
            r7 = r1[r4]
            int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x0028
        L_0x0036:
            byte r5 = r0[r4]
            r7 = 2
            if (r5 != r7) goto L_0x0056
            r5 = r4
        L_0x003c:
            byte r8 = r0[r5]
            if (r8 == 0) goto L_0x004f
            byte r8 = r0[r5]
            if (r8 == r7) goto L_0x004a
            r8 = r1[r5]
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x004f
        L_0x004a:
            int r5 = r5 - r3
            if (r5 >= 0) goto L_0x003c
            int r5 = r5 + r2
            goto L_0x003c
        L_0x004f:
            byte r12 = r0[r5]
            if (r12 != r6) goto L_0x0055
            int r12 = -r5
            goto L_0x0022
        L_0x0055:
            return r4
        L_0x0056:
            byte r12 = r0[r4]
            if (r12 != r6) goto L_0x005b
            goto L_0x0021
        L_0x005b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.trove.TLongHash.insertionIndex(long):int");
    }

    public final boolean contains(long j) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = bArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(j) & Integer.MAX_VALUE;
        int i = computeHashCode % length;
        if (bArr[i] != 0 && (bArr[i] == 2 || jArr[i] != j)) {
            int i2 = (computeHashCode % (length - 2)) + 1;
            while (true) {
                i -= i2;
                if (i < 0) {
                    i += length;
                }
                if (bArr[i] == 0 || (bArr[i] != 2 && jArr[i] == j)) {
                    break;
                }
            }
        }
        if (bArr[i] == 0) {
            i = -1;
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }
}
