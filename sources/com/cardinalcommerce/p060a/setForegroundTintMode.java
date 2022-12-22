package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;

/* renamed from: com.cardinalcommerce.a.setForegroundTintMode */
public final class setForegroundTintMode {
    public int Cardinal;
    public setBackgroundTintList getInstance;
    public int[] init;

    public setForegroundTintMode(setBackgroundTintList setbackgroundtintlist, int i) {
        this.getInstance = setbackgroundtintlist;
        this.Cardinal = i;
        int[] iArr = new int[(i + 1)];
        this.init = iArr;
        iArr[i] = 1;
    }

    /* renamed from: a */
    private void m1989a() {
        int length = this.init.length;
        do {
            this.Cardinal = length - 1;
            length = this.Cardinal;
            if (length < 0 || this.init[length] != 0) {
            }
            this.Cardinal = length - 1;
            length = this.Cardinal;
            return;
        } while (this.init[length] != 0);
    }

    /* renamed from: b */
    static int m1991b(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    public final setForegroundTintMode Cardinal(int i) {
        if (this.getInstance.Cardinal(i)) {
            return new setForegroundTintMode(this.getInstance, mo18523a(this.init, i));
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public final void Cardinal(setForegroundTintMode setforegroundtintmode) {
        this.init = m1990a(this.init, setforegroundtintmode.init);
        m1989a();
    }

    public final void configure(int i) {
        if (this.getInstance.Cardinal(i)) {
            this.init = mo18523a(this.init, i);
            m1989a();
            return;
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof setForegroundTintMode)) {
            setForegroundTintMode setforegroundtintmode = (setForegroundTintMode) obj;
            return this.getInstance.equals(setforegroundtintmode.getInstance) && this.Cardinal == setforegroundtintmode.Cardinal && m1992b(this.init, setforegroundtintmode.init);
        }
    }

    public final int hashCode() {
        int hashCode = this.getInstance.hashCode();
        int i = 0;
        while (true) {
            int[] iArr = this.init;
            if (i >= iArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + iArr[i];
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" Polynomial over ");
        sb.append(this.getInstance.toString());
        sb.append(": \n");
        String obj = sb.toString();
        for (int i = 0; i < this.init.length; i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(this.getInstance.cca_continue(this.init[i]));
            sb2.append("Y^");
            sb2.append(i);
            sb2.append("+");
            obj = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append(";");
        return sb3.toString();
    }

    public setForegroundTintMode(setBackgroundTintList setbackgroundtintlist, int[] iArr) {
        int[] iArr2;
        this.getInstance = setbackgroundtintlist;
        int b = m1991b(iArr);
        if (b == -1) {
            iArr2 = new int[1];
        } else {
            int i = b + 1;
            if (iArr.length == i) {
                iArr2 = new int[iArr.length];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            } else {
                int[] iArr3 = new int[i];
                System.arraycopy(iArr, 0, iArr3, 0, i);
                iArr2 = iArr3;
            }
        }
        this.init = iArr2;
        m1989a();
    }

    public setForegroundTintMode(setBackgroundTintList setbackgroundtintlist, byte[] bArr) {
        this.getInstance = setbackgroundtintlist;
        int i = 8;
        int i2 = 1;
        while (setbackgroundtintlist.configure > i) {
            i2++;
            i += 8;
        }
        if (bArr.length % i2 == 0) {
            this.init = new int[(bArr.length / i2)];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr = this.init;
                if (i3 < iArr.length) {
                    int i5 = 0;
                    while (i5 < i) {
                        int[] iArr2 = this.init;
                        iArr2[i3] = ((bArr[i4] & 255) << i5) ^ iArr2[i3];
                        i5 += 8;
                        i4++;
                    }
                    if (this.getInstance.Cardinal(this.init[i3])) {
                        i3++;
                    } else {
                        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                    }
                } else if (iArr.length == 1 || iArr[iArr.length - 1] != 0) {
                    m1989a();
                    return;
                } else {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
            }
        } else {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
    }

    public setForegroundTintMode(setForegroundTintMode setforegroundtintmode) {
        this.getInstance = setforegroundtintmode.getInstance;
        this.Cardinal = setforegroundtintmode.Cardinal;
        int[] iArr = setforegroundtintmode.init;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.init = iArr2;
    }

    /* renamed from: a */
    static int m1988a(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        if (length == -1) {
            return 0;
        }
        return iArr[length];
    }

    public final byte[] cca_continue() {
        int i = 8;
        int i2 = 1;
        while (this.getInstance.configure > i) {
            i2++;
            i += 8;
        }
        byte[] bArr = new byte[(this.init.length * i2)];
        int i3 = 0;
        for (int i4 = 0; i4 < this.init.length; i4++) {
            int i5 = 0;
            while (i5 < i) {
                bArr[i3] = (byte) (this.init[i4] >>> i5);
                i5 += 8;
                i3++;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    static int[] m1990a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = iArr3[length] ^ iArr[length];
        }
        return iArr3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int[] mo18523a(int[] iArr, int i) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        if (length == -1 || i == 0) {
            return new int[1];
        }
        if (i == 1) {
            int[] iArr2 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        int[] iArr3 = new int[(length + 1)];
        while (length >= 0) {
            iArr3[length] = DSASigner.dsaSha3_384.getInstance(iArr[length], i, this.getInstance.getInstance);
            length--;
        }
        return iArr3;
    }

    /* renamed from: b */
    static int[] m1993b(int[] iArr, int i) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        if (length == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[(length + i + 1)];
        System.arraycopy(iArr, 0, iArr2, i, length + 1);
        return iArr2;
    }

    /* renamed from: b */
    private static boolean m1992b(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        int length2 = iArr2.length - 1;
        while (length2 >= 0 && iArr2[length2] == 0) {
            length2--;
        }
        if (length != length2) {
            return false;
        }
        for (int i = 0; i <= length; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
