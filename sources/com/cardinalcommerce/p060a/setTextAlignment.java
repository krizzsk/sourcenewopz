package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.cardinalcommerce.a.setTextAlignment */
public final class setTextAlignment implements setNestedScrollingEnabled {

    /* renamed from: a */
    private byte[] f2999a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    private byte f3000b = 61;

    /* renamed from: c */
    private byte[] f3001c = new byte[128];

    public setTextAlignment() {
        m2093a();
    }

    /* renamed from: a */
    private static int m2092a(String str, int i, int i2) {
        while (i < i2 && m2094a(str.charAt(i))) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private void m2093a() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f3001c;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.f2999a;
            if (i < bArr2.length) {
                this.f3001c[bArr2[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m2094a(char c) {
        return c == 10 || c == 13 || c == 9 || c == ' ';
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int configure(byte[] r10, int r11, int r12, java.io.OutputStream r13) throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r12 % 3
            int r12 = r12 - r0
            r1 = r11
        L_0x0004:
            int r2 = r11 + r12
            r3 = 4
            r4 = 2
            if (r1 >= r2) goto L_0x004c
            byte r2 = r10[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r5 = r1 + 1
            byte r5 = r10[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r1 + 2
            byte r6 = r10[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r7 = r9.f2999a
            int r8 = r2 >>> 2
            r8 = r8 & 63
            byte r7 = r7[r8]
            r13.write(r7)
            byte[] r7 = r9.f2999a
            int r2 = r2 << r3
            int r3 = r5 >>> 4
            r2 = r2 | r3
            r2 = r2 & 63
            byte r2 = r7[r2]
            r13.write(r2)
            byte[] r2 = r9.f2999a
            int r3 = r5 << 2
            int r4 = r6 >>> 6
            r3 = r3 | r4
            r3 = r3 & 63
            byte r2 = r2[r3]
            r13.write(r2)
            byte[] r2 = r9.f2999a
            r3 = r6 & 63
            byte r2 = r2[r3]
            r13.write(r2)
            int r1 = r1 + 3
            goto L_0x0004
        L_0x004c:
            r11 = 1
            if (r0 == r11) goto L_0x007b
            if (r0 == r4) goto L_0x0052
            goto L_0x009e
        L_0x0052:
            byte r1 = r10[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r2 = r2 + r11
            byte r10 = r10[r2]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r11 = r1 >>> 2
            r11 = r11 & 63
            int r1 = r1 << r3
            int r2 = r10 >>> 4
            r1 = r1 | r2
            r1 = r1 & 63
            int r10 = r10 << r4
            r10 = r10 & 63
            byte[] r2 = r9.f2999a
            byte r11 = r2[r11]
            r13.write(r11)
            byte[] r11 = r9.f2999a
            byte r11 = r11[r1]
            r13.write(r11)
            byte[] r11 = r9.f2999a
            byte r10 = r11[r10]
            goto L_0x0096
        L_0x007b:
            byte r10 = r10[r2]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r11 = r10 >>> 2
            r11 = r11 & 63
            int r10 = r10 << r3
            r10 = r10 & 63
            byte[] r1 = r9.f2999a
            byte r11 = r1[r11]
            r13.write(r11)
            byte[] r11 = r9.f2999a
            byte r10 = r11[r10]
            r13.write(r10)
            byte r10 = r9.f3000b
        L_0x0096:
            r13.write(r10)
            byte r10 = r9.f3000b
            r13.write(r10)
        L_0x009e:
            int r12 = r12 / 3
            int r10 = r12 << 2
            if (r0 != 0) goto L_0x00a5
            r3 = 0
        L_0x00a5:
            int r10 = r10 + r3
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextAlignment.configure(byte[], int, int, java.io.OutputStream):int");
    }

    public final int Cardinal(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && m2094a(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        if (length == 0) {
            return 0;
        }
        int i2 = length;
        int i3 = 0;
        while (i2 > 0 && i3 != 4) {
            if (!m2094a(str.charAt(i2 - 1))) {
                i3++;
            }
            i2--;
        }
        int i4 = 0;
        while (i4 < i2 && m2094a(str.charAt(i4))) {
            i4++;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            byte b = this.f3001c[str.charAt(i4)];
            while (i5 < i2 && m2094a(str.charAt(i5))) {
                i5++;
            }
            int i6 = i5 + 1;
            byte b2 = this.f3001c[str.charAt(i5)];
            while (i6 < i2 && m2094a(str.charAt(i6))) {
                i6++;
            }
            int i7 = i6 + 1;
            byte b3 = this.f3001c[str.charAt(i6)];
            while (i7 < i2 && m2094a(str.charAt(i7))) {
                i7++;
            }
            int i8 = i7 + 1;
            byte b4 = this.f3001c[str.charAt(i7)];
            if ((b | b2 | b3 | b4) >= 0) {
                outputStream.write((b << 2) | (b2 >> 4));
                outputStream.write((b2 << 4) | (b3 >> 2));
                outputStream.write((b3 << 6) | b4);
                i += 3;
                i4 = m2092a(str, i8, i2);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        int a = m2092a(str, i4, length);
        int a2 = m2092a(str, a + 1, length);
        int a3 = m2092a(str, a2 + 1, length);
        int a4 = m2092a(str, a3 + 1, length);
        char charAt = str.charAt(a);
        char charAt2 = str.charAt(a2);
        char charAt3 = str.charAt(a3);
        char charAt4 = str.charAt(a4);
        byte b5 = this.f3000b;
        int i9 = 2;
        if (charAt3 == b5) {
            if (charAt4 == b5) {
                byte[] bArr = this.f3001c;
                byte b6 = bArr[charAt];
                byte b7 = bArr[charAt2];
                if ((b6 | b7) >= 0) {
                    outputStream.write((b7 >> 4) | (b6 << 2));
                    i9 = 1;
                } else {
                    throw new IOException("invalid characters encountered at end of base64 data");
                }
            } else {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
        } else if (charAt4 == b5) {
            byte[] bArr2 = this.f3001c;
            byte b8 = bArr2[charAt];
            byte b9 = bArr2[charAt2];
            byte b10 = bArr2[charAt3];
            if ((b8 | b9 | b10) >= 0) {
                outputStream.write((b8 << 2) | (b9 >> 4));
                outputStream.write((b10 >> 2) | (b9 << 4));
            } else {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
        } else {
            byte[] bArr3 = this.f3001c;
            byte b11 = bArr3[charAt];
            byte b12 = bArr3[charAt2];
            byte b13 = bArr3[charAt3];
            byte b14 = bArr3[charAt4];
            if ((b11 | b12 | b13 | b14) >= 0) {
                outputStream.write((b11 << 2) | (b12 >> 4));
                outputStream.write((b12 << 4) | (b13 >> 2));
                outputStream.write(b14 | (b13 << 6));
                i9 = 3;
            } else {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
        }
        return i + i9;
    }
}
