package com.didi.dqr.oned;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

public final class CodaBarReader extends OneDReader {

    /* renamed from: a */
    static final char[] f18669a = f18673e.toCharArray();

    /* renamed from: b */
    static final int[] f18670b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c */
    private static final float f18671c = 2.0f;

    /* renamed from: d */
    private static final float f18672d = 1.5f;

    /* renamed from: e */
    private static final String f18673e = "0123456789-$:/.+ABCD";

    /* renamed from: f */
    private static final int f18674f = 3;

    /* renamed from: g */
    private static final char[] f18675g = {'A', 'B', 'C', 'D'};

    /* renamed from: h */
    private final StringBuilder f18676h = new StringBuilder(20);

    /* renamed from: i */
    private int[] f18677i = new int[80];

    /* renamed from: j */
    private int f18678j = 0;

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0104 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.dqr.Result decodeRow(int r11, com.didi.dqr.common.BitArray r12, java.util.Map<com.didi.dqr.DecodeHintType, ?> r13) throws com.didi.dqr.NotFoundException {
        /*
            r10 = this;
            int[] r0 = r10.f18677i
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            r10.m13879a((com.didi.dqr.common.BitArray) r12)
            int r12 = r10.m13877a()
            java.lang.StringBuilder r0 = r10.f18676h
            r0.setLength(r1)
            r0 = r12
        L_0x0013:
            int r2 = r10.m13882c(r0)
            r3 = -1
            if (r2 == r3) goto L_0x0104
            java.lang.StringBuilder r4 = r10.f18676h
            char r5 = (char) r2
            r4.append(r5)
            int r0 = r0 + 8
            java.lang.StringBuilder r4 = r10.f18676h
            int r4 = r4.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0038
            char[] r4 = f18675g
            char[] r6 = f18669a
            char r2 = r6[r2]
            boolean r2 = m13880a(r4, r2)
            if (r2 == 0) goto L_0x0038
            goto L_0x003c
        L_0x0038:
            int r2 = r10.f18678j
            if (r0 < r2) goto L_0x0013
        L_0x003c:
            int[] r2 = r10.f18677i
            int r4 = r0 + -1
            r2 = r2[r4]
            r6 = -8
            r7 = 0
        L_0x0044:
            if (r6 >= r3) goto L_0x0050
            int[] r8 = r10.f18677i
            int r9 = r0 + r6
            r8 = r8[r9]
            int r7 = r7 + r8
            int r6 = r6 + 1
            goto L_0x0044
        L_0x0050:
            int r3 = r10.f18678j
            r6 = 2
            if (r0 >= r3) goto L_0x005e
            int r7 = r7 / r6
            if (r2 < r7) goto L_0x0059
            goto L_0x005e
        L_0x0059:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x005e:
            r10.m13878a((int) r12)
            r0 = 0
        L_0x0062:
            java.lang.StringBuilder r2 = r10.f18676h
            int r2 = r2.length()
            if (r0 >= r2) goto L_0x007a
            java.lang.StringBuilder r2 = r10.f18676h
            char[] r3 = f18669a
            char r7 = r2.charAt(r0)
            char r3 = r3[r7]
            r2.setCharAt(r0, r3)
            int r0 = r0 + 1
            goto L_0x0062
        L_0x007a:
            java.lang.StringBuilder r0 = r10.f18676h
            char r0 = r0.charAt(r1)
            char[] r2 = f18675g
            boolean r0 = m13880a(r2, r0)
            if (r0 == 0) goto L_0x00ff
            java.lang.StringBuilder r0 = r10.f18676h
            int r2 = r0.length()
            int r2 = r2 - r5
            char r0 = r0.charAt(r2)
            char[] r2 = f18675g
            boolean r0 = m13880a(r2, r0)
            if (r0 == 0) goto L_0x00fa
            java.lang.StringBuilder r0 = r10.f18676h
            int r0 = r0.length()
            r2 = 3
            if (r0 <= r2) goto L_0x00f5
            if (r13 == 0) goto L_0x00ae
            com.didi.dqr.DecodeHintType r0 = com.didi.dqr.DecodeHintType.RETURN_CODABAR_START_END
            boolean r13 = r13.containsKey(r0)
            if (r13 != 0) goto L_0x00bd
        L_0x00ae:
            java.lang.StringBuilder r13 = r10.f18676h
            int r0 = r13.length()
            int r0 = r0 - r5
            r13.deleteCharAt(r0)
            java.lang.StringBuilder r13 = r10.f18676h
            r13.deleteCharAt(r1)
        L_0x00bd:
            r13 = 0
            r0 = 0
        L_0x00bf:
            if (r13 >= r12) goto L_0x00c9
            int[] r2 = r10.f18677i
            r2 = r2[r13]
            int r0 = r0 + r2
            int r13 = r13 + 1
            goto L_0x00bf
        L_0x00c9:
            float r13 = (float) r0
        L_0x00ca:
            if (r12 >= r4) goto L_0x00d4
            int[] r2 = r10.f18677i
            r2 = r2[r12]
            int r0 = r0 + r2
            int r12 = r12 + 1
            goto L_0x00ca
        L_0x00d4:
            float r12 = (float) r0
            com.didi.dqr.Result r0 = new com.didi.dqr.Result
            java.lang.StringBuilder r2 = r10.f18676h
            java.lang.String r2 = r2.toString()
            r3 = 0
            com.didi.dqr.ResultPoint[] r4 = new com.didi.dqr.ResultPoint[r6]
            com.didi.dqr.ResultPoint r6 = new com.didi.dqr.ResultPoint
            float r11 = (float) r11
            r6.<init>(r13, r11)
            r4[r1] = r6
            com.didi.dqr.ResultPoint r13 = new com.didi.dqr.ResultPoint
            r13.<init>(r12, r11)
            r4[r5] = r13
            com.didi.dqr.BarcodeFormat r11 = com.didi.dqr.BarcodeFormat.CODABAR
            r0.<init>(r2, r3, r4, r11)
            return r0
        L_0x00f5:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00fa:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00ff:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0104:
            com.didi.dqr.NotFoundException r11 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.oned.CodaBarReader.decodeRow(int, com.didi.dqr.common.BitArray, java.util.Map):com.didi.dqr.Result");
    }

    /* renamed from: a */
    private void m13878a(int i) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f18676h.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = f18670b[this.f18676h.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) * 2);
                iArr[i7] = iArr[i7] + this.f18677i[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            fArr2[i9] = ((((float) iArr[i8]) / ((float) iArr2[i8])) + (((float) iArr[i9]) / ((float) iArr2[i9]))) / 2.0f;
            fArr[i8] = fArr2[i9];
            fArr[i9] = ((((float) iArr[i9]) * 2.0f) + 1.5f) / ((float) iArr2[i9]);
        }
        loop3:
        while (true) {
            int i10 = f18670b[this.f18676h.charAt(i2)];
            int i11 = 6;
            while (i11 >= 0) {
                int i12 = (i11 & 1) + ((i10 & 1) * 2);
                float f = (float) this.f18677i[i + i11];
                if (f >= fArr2[i12] && f <= fArr[i12]) {
                    i10 >>= 1;
                    i11--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private void m13879a(BitArray bitArray) throws NotFoundException {
        int i = 0;
        this.f18678j = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset < size) {
            boolean z = true;
            while (nextUnset < size) {
                if (bitArray.get(nextUnset) != z) {
                    i++;
                } else {
                    m13881b(i);
                    z = !z;
                    i = 1;
                }
                nextUnset++;
            }
            m13881b(i);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: b */
    private void m13881b(int i) {
        int[] iArr = this.f18677i;
        int i2 = this.f18678j;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.f18678j = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f18677i = iArr2;
        }
    }

    /* renamed from: a */
    private int m13877a() throws NotFoundException {
        for (int i = 1; i < this.f18678j; i += 2) {
            int c = m13882c(i);
            if (c != -1 && m13880a(f18675g, f18669a[c])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.f18677i[i3];
                }
                if (i == 1 || this.f18677i[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    static boolean m13880a(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    private int m13882c(int i) {
        int i2 = i + 7;
        if (i2 >= this.f18678j) {
            return -1;
        }
        int[] iArr = this.f18677i;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = f18670b;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }
}
