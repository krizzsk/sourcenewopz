package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.cardinalcommerce.a.setScrollCaptureCallback */
public final class setScrollCaptureCallback implements setNestedScrollingEnabled {

    /* renamed from: a */
    private byte[] f2967a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    private byte[] f2968b = new byte[128];

    public setScrollCaptureCallback() {
        m2084a();
    }

    /* renamed from: a */
    private void m2084a() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f2968b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.f2967a;
            if (i < bArr2.length) {
                this.f2968b[bArr2[i]] = (byte) i;
                i++;
            } else {
                byte[] bArr3 = this.f2968b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m2085a(char c) {
        return c == 10 || c == 13 || c == 9 || c == ' ';
    }

    public final int Cardinal(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && m2085a(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            while (i < length && m2085a(str.charAt(i))) {
                i++;
            }
            int i3 = i + 1;
            byte b = this.f2968b[str.charAt(i)];
            while (i3 < length && m2085a(str.charAt(i3))) {
                i3++;
            }
            int i4 = i3 + 1;
            byte b2 = this.f2968b[str.charAt(i3)];
            if ((b | b2) >= 0) {
                outputStream.write((b << 4) | b2);
                i2++;
                i = i4;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        return i2;
    }

    public final int configure(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = bArr[i3] & 255;
            outputStream.write(this.f2967a[b >>> 4]);
            outputStream.write(this.f2967a[b & Ascii.f53593SI]);
        }
        return i2 << 1;
    }
}
