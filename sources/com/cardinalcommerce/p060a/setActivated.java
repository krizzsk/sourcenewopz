package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.SignatureSpi;
import com.google.common.base.Ascii;

/* renamed from: com.cardinalcommerce.a.setActivated */
public final class setActivated {

    /* renamed from: a */
    private static char[] f2662a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private final byte[] f2663b;

    public setActivated(byte[] bArr) {
        this(bArr, 160);
    }

    public setActivated(byte[] bArr, int i) {
        this.f2663b = m1948a(bArr, i);
    }

    /* renamed from: a */
    private static byte[] m1948a(byte[] bArr, int i) {
        if (i % 8 == 0) {
            SignatureSpi.ecNR512 ecnr512 = new SignatureSpi.ecNR512(256);
            ecnr512.init(bArr, 0, bArr.length);
            int i2 = i / 8;
            byte[] bArr2 = new byte[i2];
            ecnr512.getInstance(bArr2, 0, i2);
            return bArr2;
        }
        throw new IllegalArgumentException("bitLength must be a multiple of 8");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setActivated) {
            return setForegroundTintBlendMode.Cardinal(((setActivated) obj).f2663b, this.f2663b);
        }
        return false;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.f2663b);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != this.f2663b.length; i++) {
            if (i > 0) {
                stringBuffer.append(":");
            }
            stringBuffer.append(f2662a[(this.f2663b[i] >>> 4) & 15]);
            stringBuffer.append(f2662a[this.f2663b[i] & Ascii.f53593SI]);
        }
        return stringBuffer.toString();
    }
}
