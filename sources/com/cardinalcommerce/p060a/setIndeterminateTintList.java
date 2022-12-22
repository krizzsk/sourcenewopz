package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* renamed from: com.cardinalcommerce.a.setIndeterminateTintList */
public final class setIndeterminateTintList {

    /* renamed from: a */
    private static /* synthetic */ boolean f2836a = (!setIndeterminateTintList.class.desiredAssertionStatus());

    setIndeterminateTintList() {
    }

    /* renamed from: a */
    private static byte m2028a(int i) {
        if (f2836a || (i >= 0 && i <= 63)) {
            long j = (long) i;
            int i2 = (int) ((j - 26) >>> 63);
            int i3 = ((int) ((j - 52) >>> 63)) & ((int) ((25 - j) >>> 63));
            int i4 = i ^ 62;
            int i5 = i4 - 1;
            int i6 = i ^ 63;
            int i7 = ((~i6) & (i6 - 1)) >>> 63;
            int i8 = i + 65;
            int i9 = (i - 26) + 97;
            int i10 = (i - 52) + 48;
            return (byte) ((i10 ^ (((((int) ((51 - j) >>> 63)) & ((int) ((j - 62) >>> 63))) - 1) & i10)) | (((i2 - 1) & i8) ^ i8) | (((i3 - 1) & i9) ^ i9) | ((((((~i4) & i5) >>> 63) - 1) & 45) ^ 45) | (((i7 - 1) & 95) ^ 95));
        }
        throw new AssertionError();
    }

    public static String getInstance(byte[] bArr) {
        int i;
        int i2 = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return "";
        }
        int i3 = length / 3;
        int i4 = i3 * 3;
        if (length == 0) {
            i = 0;
        } else {
            i = i3 << 2;
            int i5 = length % 3;
            if (i5 != 0) {
                i = i + i5 + 1;
            }
        }
        byte[] bArr2 = new byte[i];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            byte b = ((bArr[i6] & 255) << 16) | ((bArr[i8] & 255) << 8);
            int i10 = i9 + 1;
            byte b2 = b | (bArr[i9] & 255);
            int i11 = i7 + 1;
            bArr2[i7] = m2028a((b2 >>> Ascii.DC2) & 63);
            int i12 = i11 + 1;
            bArr2[i11] = m2028a((b2 >>> Ascii.f53586FF) & 63);
            int i13 = i12 + 1;
            bArr2[i12] = m2028a((b2 >>> 6) & 63);
            i7 = i13 + 1;
            bArr2[i13] = m2028a(b2 & Utf8.REPLACEMENT_BYTE);
            i6 = i10;
        }
        int i14 = length - i4;
        if (i14 > 0) {
            int i15 = (bArr[i4] & 255) << 10;
            if (i14 == 2) {
                i2 = (bArr[length - 1] & 255) << 2;
            }
            int i16 = i15 | i2;
            if (i14 == 2) {
                bArr2[i - 3] = m2028a(i16 >> 12);
                bArr2[i - 2] = m2028a((i16 >>> 6) & 63);
                bArr2[i - 1] = m2028a(i16 & 63);
            } else {
                bArr2[i - 2] = m2028a(i16 >> 12);
                bArr2[i - 1] = m2028a((i16 >>> 6) & 63);
            }
        }
        return new String(bArr2, setMinWidth.getInstance);
    }

    public static byte[] getInstance(String str) {
        int i;
        String str2 = str;
        if (str2 == null || str.isEmpty()) {
            return new byte[0];
        }
        byte[] bytes = str2.getBytes(setMinWidth.getInstance);
        int length = bytes.length;
        long j = (((long) length) * 6) >> 3;
        int i2 = (int) j;
        if (((long) i2) == j) {
            byte[] bArr = new byte[i2];
            int i3 = 0;
            int i4 = 0;
            while (i3 < bytes.length) {
                int i5 = 0;
                int i6 = 0;
                while (i5 < 4 && i3 < length) {
                    int i7 = i3 + 1;
                    byte b = bytes[i3];
                    long j2 = (long) b;
                    int i8 = i4;
                    int i9 = ((int) ((64 - j2) >>> 63)) & ((int) ((j2 - 91) >>> 63));
                    int i10 = length;
                    int i11 = i5;
                    int i12 = ((int) ((96 - j2) >>> 63)) & ((int) ((j2 - 123) >>> 63));
                    int i13 = ((int) ((j2 - 58) >>> 63)) & ((int) ((47 - j2) >>> 63));
                    byte b2 = b ^ 45;
                    byte b3 = b ^ 43;
                    int i14 = (((~b2) & (b2 - 1)) >>> 63) | (((~b3) & (b3 - 1)) >>> 63);
                    byte b4 = b ^ 95;
                    byte b5 = b ^ 47;
                    int i15 = (((~b4) & (b4 - 1)) >>> 63) | (((~b5) & (b5 - 1)) >>> 63);
                    int i16 = b - 65;
                    int i17 = (b - 97) + 26;
                    int i18 = (b - 48) + 52;
                    int i19 = (i17 ^ ((i12 - 1) & i17)) | (((i9 - 1) & i16) ^ i16) | (i18 ^ ((i13 - 1) & i18)) | (((i14 - 1) & 62) ^ 62) | (((i15 - 1) & 63) ^ 63) | ((((((i9 | i12) | i13) | i14) | i15) - 1) ^ 0);
                    if (f2836a || (i19 >= -1 && i19 <= 63)) {
                        if (i19 >= 0) {
                            i6 |= i19 << (18 - (i11 * 6));
                            i5 = i11 + 1;
                        } else {
                            i5 = i11;
                        }
                        i3 = i7;
                        i4 = i8;
                        length = i10;
                    } else {
                        throw new AssertionError();
                    }
                }
                int i20 = length;
                int i21 = i4;
                int i22 = i5;
                if (i22 >= 2) {
                    int i23 = i21 + 1;
                    bArr[i21] = (byte) (i6 >> 16);
                    if (i22 >= 3) {
                        int i24 = i23 + 1;
                        bArr[i23] = (byte) (i6 >> 8);
                        if (i22 >= 4) {
                            i = i24 + 1;
                            bArr[i24] = (byte) i6;
                        } else {
                            i = i24;
                        }
                    } else {
                        i = i23;
                    }
                } else {
                    i = i21;
                }
                i4 = i;
                length = i20;
            }
            return Arrays.copyOf(bArr, i4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append(" cannot be cast to int without changing its value.");
        throw new IllegalArgumentException(sb.toString());
    }
}
