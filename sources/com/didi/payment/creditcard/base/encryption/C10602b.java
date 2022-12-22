package com.didi.payment.creditcard.base.encryption;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import okio.Utf8;

/* renamed from: com.didi.payment.creditcard.base.encryption.b */
/* compiled from: Base64 */
class C10602b {

    /* renamed from: a */
    static final int f30276a = 76;

    /* renamed from: b */
    static final byte[] f30277b = "\r\n".getBytes();

    /* renamed from: c */
    static final int f30278c = 255;

    /* renamed from: d */
    static final int f30279d = 64;

    /* renamed from: e */
    static final int f30280e = 8;

    /* renamed from: f */
    static final int f30281f = 16;

    /* renamed from: g */
    static final int f30282g = 24;

    /* renamed from: h */
    static final int f30283h = 4;

    /* renamed from: i */
    static final int f30284i = -128;

    /* renamed from: j */
    static final byte f30285j = 61;

    /* renamed from: k */
    private static byte[] f30286k = new byte[255];

    /* renamed from: l */
    private static byte[] f30287l = new byte[64];

    /* renamed from: a */
    private static boolean m21195a(char c) {
        return c == ' ' || c == 13 || c == 10 || c == 9;
    }

    /* renamed from: c */
    private static boolean m21201c(char c) {
        return c == '=';
    }

    C10602b() {
    }

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 255; i4++) {
            f30286k[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f30286k[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f30286k[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f30286k[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f30286k;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i8 = 0; i8 <= 25; i8++) {
            f30287l[i8] = (byte) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f30287l[i] = (byte) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f30287l[i2] = (byte) (i3 + 48);
            i2++;
            i3++;
        }
        byte[] bArr2 = f30287l;
        bArr2[62] = 43;
        bArr2[63] = 47;
    }

    /* renamed from: a */
    private static boolean m21194a(byte b) {
        return b == 61 || f30286k[b] != -1;
    }

    /* renamed from: a */
    public static boolean m21196a(byte[] bArr) {
        if (r0 == 0) {
            return true;
        }
        for (byte a : m21206f(bArr)) {
            if (!m21194a(a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static byte[] m21200b(byte[] bArr) {
        return m21197a(bArr, false);
    }

    /* renamed from: c */
    public static byte[] m21203c(byte[] bArr) {
        return m21197a(bArr, true);
    }

    /* renamed from: d */
    public static byte[] m21204d(byte[] bArr) {
        return m21205e(bArr);
    }

    /* renamed from: a */
    public static byte[] m21197a(byte[] bArr, boolean z) {
        int i;
        byte[] bArr2 = bArr;
        int length = bArr2.length * 8;
        int i2 = length % 24;
        int i3 = length / 24;
        int i4 = i2 != 0 ? (i3 + 1) * 4 : i3 * 4;
        if (z) {
            i = f30277b.length == 0 ? 0 : (int) Math.ceil((double) (((float) i4) / 76.0f));
            i4 += f30277b.length * i;
        } else {
            i = 0;
        }
        byte[] bArr3 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 76;
        while (i5 < i3) {
            int i9 = i5 * 3;
            byte b = bArr2[i9];
            byte b2 = bArr2[i9 + 1];
            byte b3 = bArr2[i9 + 2];
            byte b4 = (byte) (b2 & Ascii.f53593SI);
            byte b5 = (byte) (b & 3);
            byte b6 = b & Byte.MIN_VALUE;
            int i10 = b >> 2;
            if (b6 != 0) {
                i10 ^= 192;
            }
            byte b7 = (byte) i10;
            byte b8 = b2 & Byte.MIN_VALUE;
            int i11 = b2 >> 4;
            if (b8 != 0) {
                i11 ^= 240;
            }
            byte b9 = (byte) i11;
            int i12 = b3 >> 6;
            if ((b3 & Byte.MIN_VALUE) != 0) {
                i12 ^= 252;
            }
            byte[] bArr4 = f30287l;
            bArr3[i6] = bArr4[b7];
            bArr3[i6 + 1] = bArr4[(b5 << 4) | b9];
            bArr3[i6 + 2] = bArr4[(b4 << 2) | ((byte) i12)];
            bArr3[i6 + 3] = bArr4[b3 & Utf8.REPLACEMENT_BYTE];
            i6 += 4;
            if (z && i6 == i8) {
                byte[] bArr5 = f30277b;
                System.arraycopy(bArr5, 0, bArr3, i6, bArr5.length);
                i7++;
                byte[] bArr6 = f30277b;
                i8 = (bArr6.length * i7) + ((i7 + 1) * 76);
                i6 += bArr6.length;
            }
            i5++;
        }
        int i13 = i5 * 3;
        if (i2 == 8) {
            byte b10 = bArr2[i13];
            byte b11 = (byte) (b10 & 3);
            byte b12 = b10 & Byte.MIN_VALUE;
            int i14 = b10 >> 2;
            if (b12 != 0) {
                i14 ^= 192;
            }
            byte[] bArr7 = f30287l;
            bArr3[i6] = bArr7[(byte) i14];
            bArr3[i6 + 1] = bArr7[b11 << 4];
            bArr3[i6 + 2] = f30285j;
            bArr3[i6 + 3] = f30285j;
        } else if (i2 == 16) {
            byte b13 = bArr2[i13];
            byte b14 = bArr2[i13 + 1];
            byte b15 = (byte) (b14 & Ascii.f53593SI);
            byte b16 = (byte) (b13 & 3);
            byte b17 = b13 & Byte.MIN_VALUE;
            int i15 = b13 >> 2;
            if (b17 != 0) {
                i15 ^= 192;
            }
            byte b18 = (byte) i15;
            byte b19 = b14 & Byte.MIN_VALUE;
            int i16 = b14 >> 4;
            if (b19 != 0) {
                i16 ^= 240;
            }
            byte[] bArr8 = f30287l;
            bArr3[i6] = bArr8[b18];
            bArr3[i6 + 1] = bArr8[((byte) i16) | (b16 << 4)];
            bArr3[i6 + 2] = bArr8[b15 << 2];
            bArr3[i6 + 3] = f30285j;
        }
        if (z && i7 < i) {
            byte[] bArr9 = f30277b;
            System.arraycopy(bArr9, 0, bArr3, i4 - bArr9.length, bArr9.length);
        }
        return bArr3;
    }

    /* renamed from: e */
    public static byte[] m21205e(byte[] bArr) {
        byte[] g = m21207g(bArr);
        if (g.length == 0) {
            return new byte[0];
        }
        int length = g.length / 4;
        int length2 = g.length;
        while (g[length2 - 1] == 61) {
            length2--;
            if (length2 == 0) {
                return new byte[0];
            }
        }
        byte[] bArr2 = new byte[(length2 - length)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 4;
            byte b = g[i3 + 2];
            byte b2 = g[i3 + 3];
            byte[] bArr3 = f30286k;
            byte b3 = bArr3[g[i3]];
            byte b4 = bArr3[g[i3 + 1]];
            if (b != 61 && b2 != 61) {
                byte b5 = bArr3[b];
                byte b6 = bArr3[b2];
                bArr2[i] = (byte) ((b3 << 2) | (b4 >> 4));
                bArr2[i + 1] = (byte) (((b4 & Ascii.f53593SI) << 4) | ((b5 >> 2) & 15));
                bArr2[i + 2] = (byte) ((b5 << 6) | b6);
            } else if (b == 61) {
                bArr2[i] = (byte) ((b4 >> 4) | (b3 << 2));
            } else if (b2 == 61) {
                byte b7 = f30286k[b];
                bArr2[i] = (byte) ((b3 << 2) | (b4 >> 4));
                bArr2[i + 1] = (byte) (((b4 & Ascii.f53593SI) << 4) | ((b7 >> 2) & 15));
            }
            i += 3;
        }
        return bArr2;
    }

    /* renamed from: f */
    static byte[] m21206f(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            if (!(b == 9 || b == 10 || b == 13 || b == 32)) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    /* renamed from: g */
    static byte[] m21207g(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (m21194a(bArr[i2])) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    /* renamed from: h */
    public static byte[] m21208h(byte[] bArr) {
        return m21197a(bArr, false);
    }

    /* renamed from: a */
    public static String m21193a(String str) throws UnsupportedEncodingException {
        String str2 = new String(m21208h(str.getBytes(StandardCharsets.UTF_8)));
        String upperCase = C10606f.m21246b(str).toUpperCase();
        return new String(m21208h((upperCase + str2).getBytes(StandardCharsets.UTF_8)));
    }

    /* renamed from: b */
    public static String m21198b(String str) throws UnsupportedEncodingException {
        if (str.length() < 40) {
            return "";
        }
        try {
            String str2 = new String(m21204d(str.getBytes(StandardCharsets.UTF_8)));
            return new String(m21204d(str2.substring(40, str2.length()).getBytes(StandardCharsets.UTF_8)));
        } catch (ArrayIndexOutOfBoundsException unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static byte[] m21202c(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a = m21192a(charArray);
        if (a % 4 != 0) {
            return null;
        }
        int i = a / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(i * 3)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i - 1) {
            int i5 = i3 + 1;
            char c = charArray[i3];
            if (m21199b(c)) {
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (m21199b(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (m21199b(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (m21199b(c4)) {
                            byte[] bArr2 = f30286k;
                            byte b = bArr2[c];
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((b << 2) | (b2 >> 4));
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((b2 & Ascii.f53593SI) << 4) | ((b3 >> 2) & 15));
                            i4 = i10 + 1;
                            bArr[i10] = (byte) ((b3 << 6) | b4);
                            i2++;
                            i3 = i8;
                        }
                    }
                }
            }
            return null;
        }
        int i11 = i3 + 1;
        char c5 = charArray[i3];
        if (!m21199b(c5)) {
            return null;
        }
        int i12 = i11 + 1;
        char c6 = charArray[i11];
        if (!m21199b(c6)) {
            return null;
        }
        byte[] bArr3 = f30286k;
        byte b5 = bArr3[c5];
        byte b6 = bArr3[c6];
        int i13 = i12 + 1;
        char c7 = charArray[i12];
        char c8 = charArray[i13];
        if (m21199b(c7) && m21199b(c8)) {
            byte[] bArr4 = f30286k;
            byte b7 = bArr4[c7];
            byte b8 = bArr4[c8];
            int i14 = i4 + 1;
            bArr[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr[i14] = (byte) (((b6 & Ascii.f53593SI) << 4) | ((b7 >> 2) & 15));
            bArr[i14 + 1] = (byte) (b8 | (b7 << 6));
            return bArr;
        } else if (!m21201c(c7) || !m21201c(c8)) {
            if (m21201c(c7) || !m21201c(c8)) {
                return null;
            }
            byte b9 = f30286k[c7];
            if ((b9 & 3) != 0) {
                return null;
            }
            int i15 = i2 * 3;
            byte[] bArr5 = new byte[(i15 + 2)];
            System.arraycopy(bArr, 0, bArr5, 0, i15);
            bArr5[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr5[i4 + 1] = (byte) (((b9 >> 2) & 15) | ((b6 & Ascii.f53593SI) << 4));
            return bArr5;
        } else if ((b6 & Ascii.f53593SI) != 0) {
            return null;
        } else {
            int i16 = i2 * 3;
            byte[] bArr6 = new byte[(i16 + 1)];
            System.arraycopy(bArr, 0, bArr6, 0, i16);
            bArr6[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            return bArr6;
        }
    }

    /* renamed from: b */
    private static boolean m21199b(char c) {
        return c < 255 && f30286k[c] != -1;
    }

    /* renamed from: a */
    private static int m21192a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!m21195a(cArr[i2])) {
                cArr[i] = cArr[i2];
                i++;
            }
        }
        return i;
    }
}
