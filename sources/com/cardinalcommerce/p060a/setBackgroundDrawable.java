package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.lang.reflect.Array;

/* renamed from: com.cardinalcommerce.a.setBackgroundDrawable */
public final class setBackgroundDrawable extends setBackgroundTintBlendMode {

    /* renamed from: a */
    private int[][] f2696a;

    /* renamed from: b */
    private int f2697b;

    public setBackgroundDrawable(int i, int[][] iArr) {
        if (iArr[0].length == ((i + 31) >> 5)) {
            this.cca_continue = i;
            this.Cardinal = iArr.length;
            this.f2697b = iArr[0].length;
            int i2 = i & 31;
            int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
            for (int i4 = 0; i4 < this.Cardinal; i4++) {
                int[] iArr2 = iArr[i4];
                int i5 = this.f2697b - 1;
                iArr2[i5] = iArr2[i5] & i3;
            }
            this.f2696a = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public setBackgroundDrawable(byte[] bArr) {
        if (bArr.length >= 9) {
            this.Cardinal = DSASigner.dsaSha3_384.Cardinal(bArr, 0);
            this.cca_continue = DSASigner.dsaSha3_384.Cardinal(bArr, 4);
            int i = ((this.cca_continue + 7) >>> 3) * this.Cardinal;
            if (this.Cardinal > 0) {
                int i2 = 8;
                if (i == bArr.length - 8) {
                    this.f2697b = (this.cca_continue + 31) >>> 5;
                    int i3 = this.Cardinal;
                    int[] iArr = new int[2];
                    iArr[1] = this.f2697b;
                    iArr[0] = i3;
                    this.f2696a = (int[][]) Array.newInstance(int.class, iArr);
                    int i4 = this.cca_continue >> 5;
                    int i5 = this.cca_continue & 31;
                    for (int i6 = 0; i6 < this.Cardinal; i6++) {
                        int i7 = 0;
                        while (i7 < i4) {
                            this.f2696a[i6][i7] = DSASigner.dsaSha3_384.Cardinal(bArr, i2);
                            i7++;
                            i2 += 4;
                        }
                        int i8 = 0;
                        while (i8 < i5) {
                            int[] iArr2 = this.f2696a[i6];
                            iArr2[i4] = ((bArr[i2] & 255) << i8) ^ iArr2[i4];
                            i8 += 8;
                            i2++;
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof setBackgroundDrawable)) {
            return false;
        }
        setBackgroundDrawable setbackgrounddrawable = (setBackgroundDrawable) obj;
        if (this.Cardinal != setbackgrounddrawable.Cardinal || this.cca_continue != setbackgrounddrawable.cca_continue || this.f2697b != setbackgrounddrawable.f2697b) {
            return false;
        }
        for (int i = 0; i < this.Cardinal; i++) {
            if (!DSASigner.dsaSha3_384.getInstance(this.f2696a[i], setbackgrounddrawable.f2696a[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = (((this.Cardinal * 31) + this.cca_continue) * 31) + this.f2697b;
        for (int i2 = 0; i2 < this.Cardinal; i2++) {
            i = (i * 31) + setForegroundTintBlendMode.cca_continue(this.f2696a[i2]);
        }
        return i;
    }

    public final byte[] init() {
        int i = 8;
        byte[] bArr = new byte[((((this.cca_continue + 7) >>> 3) * this.Cardinal) + 8)];
        DSASigner.dsaSha3_384.cca_continue(this.Cardinal, bArr, 0);
        DSASigner.dsaSha3_384.cca_continue(this.cca_continue, bArr, 4);
        int i2 = this.cca_continue >>> 5;
        int i3 = this.cca_continue & 31;
        for (int i4 = 0; i4 < this.Cardinal; i4++) {
            int i5 = 0;
            while (i5 < i2) {
                DSASigner.dsaSha3_384.cca_continue(this.f2696a[i4][i5], bArr, i);
                i5++;
                i += 4;
            }
            int i6 = 0;
            while (i6 < i3) {
                bArr[i] = (byte) (this.f2696a[i4][i2] >>> i6);
                i6 += 8;
                i++;
            }
        }
        return bArr;
    }

    public final String toString() {
        int i = this.cca_continue & 31;
        int i2 = this.f2697b;
        if (i != 0) {
            i2--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.Cardinal; i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i3);
            sb.append(": ");
            stringBuffer.append(sb.toString());
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.f2696a[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.f2696a[i3][this.f2697b - 1];
            for (int i8 = 0; i8 < i; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }

    public setBackgroundDrawable(setBackgroundDrawable setbackgrounddrawable) {
        this.cca_continue = setbackgrounddrawable.Cardinal();
        this.Cardinal = setbackgrounddrawable.getInstance();
        this.f2697b = setbackgrounddrawable.f2697b;
        this.f2696a = new int[setbackgrounddrawable.f2696a.length][];
        int i = 0;
        while (true) {
            int[][] iArr = this.f2696a;
            if (i < iArr.length) {
                int[] iArr2 = setbackgrounddrawable.f2696a[i];
                int[] iArr3 = new int[iArr2.length];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
                iArr[i] = iArr3;
                i++;
            } else {
                return;
            }
        }
    }
}
