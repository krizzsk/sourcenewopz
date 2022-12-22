package com.didi.dqr.common;

public final class BitSource {

    /* renamed from: a */
    private final byte[] f18524a;

    /* renamed from: b */
    private int f18525b;

    /* renamed from: c */
    private int f18526c;

    public BitSource(byte[] bArr) {
        this.f18524a = bArr;
    }

    public int getBitOffset() {
        return this.f18526c;
    }

    public int getByteOffset() {
        return this.f18525b;
    }

    public int readBits(int i) {
        if (i < 1 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.f18526c;
        byte b = 0;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            byte[] bArr = this.f18524a;
            int i6 = this.f18525b;
            int i7 = (((255 >> (8 - i4)) << i5) & bArr[i6]) >> i5;
            i -= i4;
            int i8 = this.f18526c + i4;
            this.f18526c = i8;
            if (i8 == 8) {
                this.f18526c = 0;
                this.f18525b = i6 + 1;
            }
            b = i7;
        }
        if (i <= 0) {
            return b;
        }
        while (i >= 8) {
            int i9 = b << 8;
            byte[] bArr2 = this.f18524a;
            int i10 = this.f18525b;
            b = (bArr2[i10] & 255) | i9;
            this.f18525b = i10 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return b;
        }
        int i11 = 8 - i;
        int i12 = (b << i) | ((((255 >> i11) << i11) & this.f18524a[this.f18525b]) >> i11);
        this.f18526c += i;
        return i12;
    }

    public int available() {
        return ((this.f18524a.length - this.f18525b) * 8) - this.f18526c;
    }
}
