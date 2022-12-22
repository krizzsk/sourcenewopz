package com.didichuxing.sdk.alphaface.core.liveness;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import okio.Utf8;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class Base64Utils {

    /* renamed from: a */
    private static char[] f48681a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};

    /* renamed from: b */
    private static byte[] f48682b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Ascii.f53586FF, Ascii.f53584CR, Ascii.f53594SO, Ascii.f53593SI, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.f53585EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.f53587FS, Ascii.f53588GS, Ascii.f53592RS, Ascii.f53596US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String encode(byte[] bArr) {
        if (bArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i2 = i + 1;
                byte b = bArr[i] & 255;
                if (i2 == length) {
                    stringBuffer.append(f48681a[b >>> 2]);
                    stringBuffer.append(f48681a[(b & 3) << 4]);
                    stringBuffer.append("==");
                    break;
                }
                int i3 = i2 + 1;
                byte b2 = bArr[i2] & 255;
                if (i3 == length) {
                    stringBuffer.append(f48681a[b >>> 2]);
                    stringBuffer.append(f48681a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                    stringBuffer.append(f48681a[(b2 & Ascii.f53593SI) << 2]);
                    stringBuffer.append("=");
                    break;
                }
                int i4 = i3 + 1;
                byte b3 = bArr[i3] & 255;
                stringBuffer.append(f48681a[b >>> 2]);
                stringBuffer.append(f48681a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                stringBuffer.append(f48681a[((b2 & Ascii.f53593SI) << 2) | ((b3 & 192) >>> 6)]);
                stringBuffer.append(f48681a[b3 & Utf8.REPLACEMENT_BYTE]);
                i = i4;
            }
            return stringBuffer.toString();
        }
        throw new NullPointerException("data is null");
    }

    public static String encode(byte[] bArr, int i, int i2) {
        if (bArr == null || i < 0 || i2 > bArr.length - i || i2 < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i4 = i3 + 1;
            byte b = bArr[i3 + i] & 255;
            if (i4 == i2) {
                stringBuffer.append(f48681a[b >>> 2]);
                stringBuffer.append(f48681a[(b & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i5 = i4 + 1;
            byte b2 = bArr[i4 + i] & 255;
            if (i5 == i2) {
                stringBuffer.append(f48681a[b >>> 2]);
                stringBuffer.append(f48681a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                stringBuffer.append(f48681a[(b2 & Ascii.f53593SI) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i6 = i5 + 1;
            byte b3 = bArr[i5 + i] & 255;
            stringBuffer.append(f48681a[b >>> 2]);
            stringBuffer.append(f48681a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
            stringBuffer.append(f48681a[((b2 & Ascii.f53593SI) << 2) | ((b3 & 192) >>> 6)]);
            stringBuffer.append(f48681a[b3 & Utf8.REPLACEMENT_BYTE]);
            i3 = i6;
        }
        return stringBuffer.toString();
    }

    public static byte[] decode(String str) {
        try {
            return m34949a(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b A[LOOP:0: B:1:0x000d->B:33:0x008b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0097 A[EDGE_INSN: B:36:0x0097->B:34:0x0097 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0097 A[EDGE_INSN: B:39:0x0097->B:34:0x0097 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0097 A[EDGE_INSN: B:40:0x0097->B:34:0x0097 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0097 A[EDGE_INSN: B:42:0x0097->B:34:0x0097 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025 A[LOOP:2: B:8:0x0025->B:11:0x0032, LOOP_START, PHI: r5 
      PHI: (r5v1 int) = (r5v0 int), (r5v9 int) binds: [B:7:0x0021, B:11:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m34949a(java.lang.String r9) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "UTF-8"
            byte[] r9 = r9.getBytes(r1)
            int r1 = r9.length
            r2 = 0
        L_0x000d:
            java.lang.String r3 = "iso8859-1"
            if (r2 >= r1) goto L_0x0097
        L_0x0011:
            byte[] r4 = f48682b
            int r5 = r2 + 1
            byte r2 = r9[r2]
            byte r2 = r4[r2]
            r4 = -1
            if (r5 >= r1) goto L_0x0021
            if (r2 == r4) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r2 = r5
            goto L_0x0011
        L_0x0021:
            if (r2 != r4) goto L_0x0025
            goto L_0x0097
        L_0x0025:
            byte[] r6 = f48682b
            int r7 = r5 + 1
            byte r5 = r9[r5]
            byte r5 = r6[r5]
            if (r7 >= r1) goto L_0x0034
            if (r5 == r4) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r5 = r7
            goto L_0x0025
        L_0x0034:
            if (r5 != r4) goto L_0x0037
            goto L_0x0097
        L_0x0037:
            int r2 = r2 << 2
            r6 = r5 & 48
            int r6 = r6 >>> 4
            r2 = r2 | r6
            char r2 = (char) r2
            r0.append(r2)
        L_0x0042:
            int r2 = r7 + 1
            byte r6 = r9[r7]
            r7 = 61
            if (r6 != r7) goto L_0x0053
            java.lang.String r9 = r0.toString()
            byte[] r9 = r9.getBytes(r3)
            return r9
        L_0x0053:
            byte[] r8 = f48682b
            byte r6 = r8[r6]
            if (r2 >= r1) goto L_0x005e
            if (r6 == r4) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r7 = r2
            goto L_0x0042
        L_0x005e:
            if (r6 != r4) goto L_0x0061
            goto L_0x0097
        L_0x0061:
            r5 = r5 & 15
            int r5 = r5 << 4
            r8 = r6 & 60
            int r8 = r8 >>> 2
            r5 = r5 | r8
            char r5 = (char) r5
            r0.append(r5)
        L_0x006e:
            int r5 = r2 + 1
            byte r2 = r9[r2]
            if (r2 != r7) goto L_0x007d
            java.lang.String r9 = r0.toString()
            byte[] r9 = r9.getBytes(r3)
            return r9
        L_0x007d:
            byte[] r8 = f48682b
            byte r2 = r8[r2]
            if (r5 >= r1) goto L_0x0088
            if (r2 == r4) goto L_0x0086
            goto L_0x0088
        L_0x0086:
            r2 = r5
            goto L_0x006e
        L_0x0088:
            if (r2 != r4) goto L_0x008b
            goto L_0x0097
        L_0x008b:
            r3 = r6 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            char r2 = (char) r2
            r0.append(r2)
            r2 = r5
            goto L_0x000d
        L_0x0097:
            java.lang.String r9 = r0.toString()
            byte[] r9 = r9.getBytes(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.core.liveness.Base64Utils.m34949a(java.lang.String):byte[]");
    }
}
