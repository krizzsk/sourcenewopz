package com.didi.sdk.util;

import com.google.common.base.Ascii;
import okio.Utf8;
import org.apache.commons.p071io.IOUtils;

public final class Base64 {

    /* renamed from: a */
    private static final int f37555a = 255;

    /* renamed from: b */
    private static final int f37556b = 64;

    /* renamed from: c */
    private static final int f37557c = 24;

    /* renamed from: d */
    private static final int f37558d = 8;

    /* renamed from: e */
    private static final int f37559e = 16;

    /* renamed from: f */
    private static final int f37560f = 6;

    /* renamed from: g */
    private static final int f37561g = 4;

    /* renamed from: h */
    private static final int f37562h = -128;

    /* renamed from: i */
    private static final char f37563i = '=';

    /* renamed from: j */
    private static final boolean f37564j = false;

    /* renamed from: k */
    private static final byte[] f37565k = new byte[255];

    /* renamed from: l */
    private static final char[] f37566l = new char[64];

    protected static boolean isPad(char c) {
        return c == '=';
    }

    protected static boolean isWhiteSpace(char c) {
        return c == ' ' || c == 13 || c == 10 || c == 9;
    }

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 255; i4++) {
            f37565k[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f37565k[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f37565k[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f37565k[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f37565k;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i8 = 0; i8 <= 25; i8++) {
            f37566l[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f37566l[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f37566l[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f37566l;
        cArr[62] = '+';
        cArr[63] = IOUtils.DIR_SEPARATOR_UNIX;
    }

    protected static boolean isData(char c) {
        return f37565k[c] != -1;
    }

    protected static boolean isBase64(char c) {
        return isWhiteSpace(c) || isPad(c) || isData(c);
    }

    public static String encode(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        int length = bArr2.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        int i3 = i != 0 ? i2 + 1 : i2;
        int i4 = 19;
        int i5 = ((i3 - 1) / 19) + 1;
        char[] cArr = new char[((i3 * 4) + i5)];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i5 - 1) {
            int i10 = 0;
            while (i10 < i4) {
                int i11 = i8 + 1;
                byte b = bArr2[i8];
                int i12 = i11 + 1;
                byte b2 = bArr2[i11];
                int i13 = i12 + 1;
                byte b3 = bArr2[i12];
                byte b4 = (byte) (b2 & Ascii.f53593SI);
                byte b5 = (byte) (b & 3);
                byte b6 = b & Byte.MIN_VALUE;
                int i14 = b >> 2;
                if (b6 != 0) {
                    i14 ^= 192;
                }
                byte b7 = (byte) i14;
                byte b8 = b2 & Byte.MIN_VALUE;
                int i15 = b2 >> 4;
                if (b8 != 0) {
                    i15 ^= 240;
                }
                byte b9 = (byte) i15;
                int i16 = b3 >> 6;
                if ((b3 & Byte.MIN_VALUE) != 0) {
                    i16 ^= 252;
                }
                int i17 = i7 + 1;
                char[] cArr2 = f37566l;
                cArr[i7] = cArr2[b7];
                int i18 = i17 + 1;
                cArr[i17] = cArr2[(b5 << 4) | b9];
                int i19 = i18 + 1;
                cArr[i18] = cArr2[((byte) i16) | (b4 << 2)];
                i7 = i19 + 1;
                cArr[i19] = cArr2[b3 & Utf8.REPLACEMENT_BYTE];
                i9++;
                i10++;
                i8 = i13;
                i4 = 19;
            }
            cArr[i7] = 10;
            i6++;
            i7++;
            i4 = 19;
        }
        while (i9 < i2) {
            int i20 = i8 + 1;
            byte b10 = bArr2[i8];
            int i21 = i20 + 1;
            byte b11 = bArr2[i20];
            i8 = i21 + 1;
            byte b12 = bArr2[i21];
            byte b13 = (byte) (b11 & Ascii.f53593SI);
            byte b14 = (byte) (b10 & 3);
            byte b15 = b10 & Byte.MIN_VALUE;
            int i22 = b10 >> 2;
            if (b15 != 0) {
                i22 ^= 192;
            }
            byte b16 = (byte) i22;
            byte b17 = b11 & Byte.MIN_VALUE;
            int i23 = b11 >> 4;
            if (b17 != 0) {
                i23 ^= 240;
            }
            byte b18 = (byte) i23;
            int i24 = (b12 & Byte.MIN_VALUE) == 0 ? b12 >> 6 : (b12 >> 6) ^ 252;
            int i25 = i7 + 1;
            char[] cArr3 = f37566l;
            cArr[i7] = cArr3[b16];
            int i26 = i25 + 1;
            cArr[i25] = cArr3[b18 | (b14 << 4)];
            int i27 = i26 + 1;
            cArr[i26] = cArr3[(b13 << 2) | ((byte) i24)];
            i7 = i27 + 1;
            cArr[i27] = cArr3[b12 & Utf8.REPLACEMENT_BYTE];
            i9++;
        }
        if (i == 8) {
            byte b19 = bArr2[i8];
            byte b20 = (byte) (b19 & 3);
            byte b21 = b19 & Byte.MIN_VALUE;
            int i28 = b19 >> 2;
            if (b21 != 0) {
                i28 ^= 192;
            }
            int i29 = i7 + 1;
            char[] cArr4 = f37566l;
            cArr[i7] = cArr4[(byte) i28];
            int i30 = i29 + 1;
            cArr[i29] = cArr4[b20 << 4];
            int i31 = i30 + 1;
            cArr[i30] = f37563i;
            i7 = i31 + 1;
            cArr[i31] = f37563i;
        } else if (i == 16) {
            byte b22 = bArr2[i8];
            byte b23 = bArr2[i8 + 1];
            byte b24 = (byte) (b23 & Ascii.f53593SI);
            byte b25 = (byte) (b22 & 3);
            byte b26 = b22 & Byte.MIN_VALUE;
            int i32 = b22 >> 2;
            if (b26 != 0) {
                i32 ^= 192;
            }
            byte b27 = (byte) i32;
            byte b28 = b23 & Byte.MIN_VALUE;
            int i33 = b23 >> 4;
            if (b28 != 0) {
                i33 ^= 240;
            }
            int i34 = i7 + 1;
            char[] cArr5 = f37566l;
            cArr[i7] = cArr5[b27];
            int i35 = i34 + 1;
            cArr[i34] = cArr5[((byte) i33) | (b25 << 4)];
            int i36 = i35 + 1;
            cArr[i35] = cArr5[b24 << 2];
            i7 = i36 + 1;
            cArr[i36] = f37563i;
        }
        cArr[i7] = 10;
        return new String(cArr);
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int removeWhiteSpace = removeWhiteSpace(charArray);
        if (removeWhiteSpace % 4 != 0) {
            return null;
        }
        int i = removeWhiteSpace / 4;
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
            if (isData(c)) {
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (isData(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (isData(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (isData(c4)) {
                            byte[] bArr2 = f37565k;
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
        if (!isData(c5)) {
            return null;
        }
        int i12 = i11 + 1;
        char c6 = charArray[i11];
        if (!isData(c6)) {
            return null;
        }
        byte[] bArr3 = f37565k;
        byte b5 = bArr3[c5];
        byte b6 = bArr3[c6];
        int i13 = i12 + 1;
        char c7 = charArray[i12];
        char c8 = charArray[i13];
        if (isData(c7) && isData(c8)) {
            byte[] bArr4 = f37565k;
            byte b7 = bArr4[c7];
            byte b8 = bArr4[c8];
            int i14 = i4 + 1;
            bArr[i4] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr[i14] = (byte) (((b6 & Ascii.f53593SI) << 4) | ((b7 >> 2) & 15));
            bArr[i14 + 1] = (byte) (b8 | (b7 << 6));
            return bArr;
        } else if (!isPad(c7) || !isPad(c8)) {
            if (isPad(c7) || !isPad(c8)) {
                return null;
            }
            byte b9 = f37565k[c7];
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

    protected static int removeWhiteSpace(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!isWhiteSpace(cArr[i2])) {
                cArr[i] = cArr[i2];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] strArr) {
        System.out.println(encode("中华人民共和国".getBytes()));
    }
}
