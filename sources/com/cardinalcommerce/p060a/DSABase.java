package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.DSABase */
public final class DSABase {

    /* renamed from: a */
    private final byte[] f2352a;

    /* renamed from: b */
    private int f2353b = 0;

    public DSABase(byte[] bArr) {
        this.f2352a = bArr;
    }

    public DSABase(byte[] bArr, byte[] bArr2) {
        int i = 0;
        this.f2352a = bArr2;
        while (i != bArr.length) {
            if (bArr[i] == bArr2[i]) {
                i++;
            } else {
                throw new IllegalArgumentException("magic-number incorrect");
            }
        }
        this.f2353b += bArr.length;
    }

    public final int Cardinal() {
        int i = this.f2353b;
        int i2 = i + 4;
        byte[] bArr = this.f2352a;
        if (i2 <= bArr.length) {
            int i3 = i + 1;
            this.f2353b = i3;
            int i4 = (bArr[i] & 255) << Ascii.CAN;
            int i5 = i3 + 1;
            this.f2353b = i5;
            byte b = i4 | ((bArr[i3] & 255) << 16);
            int i6 = i5 + 1;
            this.f2353b = i6;
            byte b2 = b | ((bArr[i5] & 255) << 8);
            this.f2353b = i6 + 1;
            return b2 | (bArr[i6] & 255);
        }
        throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
    }

    public final boolean cca_continue() {
        return this.f2353b < this.f2352a.length;
    }

    public final byte[] configure() {
        int Cardinal = Cardinal();
        if (Cardinal == 0) {
            return new byte[0];
        }
        int i = this.f2353b;
        int i2 = i + Cardinal;
        byte[] bArr = this.f2352a;
        if (i2 <= bArr.length) {
            int i3 = Cardinal + i;
            this.f2353b = i3;
            return setForegroundTintBlendMode.cca_continue(bArr, i, i3);
        }
        throw new IllegalArgumentException("not enough data for string");
    }

    public final byte[] getInstance() {
        int Cardinal = Cardinal();
        if (Cardinal == 0) {
            return new byte[0];
        }
        int i = this.f2353b;
        int i2 = i + Cardinal;
        byte[] bArr = this.f2352a;
        if (i2 <= bArr.length) {
            int i3 = (Cardinal - (bArr[(i + Cardinal) - 1] & 255)) + i;
            this.f2353b = i3;
            return setForegroundTintBlendMode.cca_continue(bArr, i, i3);
        }
        throw new IllegalArgumentException("not enough data for string");
    }

    public final BigInteger init() {
        int Cardinal = Cardinal();
        int i = this.f2353b;
        int i2 = i + Cardinal;
        byte[] bArr = this.f2352a;
        if (i2 <= bArr.length) {
            byte[] bArr2 = new byte[Cardinal];
            System.arraycopy(bArr, i, bArr2, 0, Cardinal);
            this.f2353b += Cardinal;
            return new BigInteger(1, bArr2);
        }
        throw new IllegalArgumentException("not enough data for big num");
    }
}
