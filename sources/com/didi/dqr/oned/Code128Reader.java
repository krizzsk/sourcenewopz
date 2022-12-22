package com.didi.dqr.oned;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

public final class Code128Reader extends OneDReader {

    /* renamed from: a */
    static final int[][] f18683a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* renamed from: b */
    private static final float f18684b = 0.25f;

    /* renamed from: c */
    private static final float f18685c = 0.7f;

    /* renamed from: d */
    private static final int f18686d = 98;

    /* renamed from: e */
    private static final int f18687e = 99;

    /* renamed from: f */
    private static final int f18688f = 100;

    /* renamed from: g */
    private static final int f18689g = 101;

    /* renamed from: h */
    private static final int f18690h = 102;

    /* renamed from: i */
    private static final int f18691i = 97;

    /* renamed from: j */
    private static final int f18692j = 96;

    /* renamed from: k */
    private static final int f18693k = 101;

    /* renamed from: l */
    private static final int f18694l = 100;

    /* renamed from: m */
    private static final int f18695m = 103;

    /* renamed from: n */
    private static final int f18696n = 104;

    /* renamed from: o */
    private static final int f18697o = 105;

    /* renamed from: p */
    private static final int f18698p = 106;

    /* renamed from: a */
    private static int[] m13884a(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    float f = f18684b;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float patternMatchVariance = patternMatchVariance(iArr, f18683a[i4], 0.7f);
                        if (patternMatchVariance < f) {
                            i3 = i4;
                            f = patternMatchVariance;
                        }
                    }
                    if (i3 < 0 || !bitArray.isRange2(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        i += iArr[0] + iArr[1];
                        int i5 = i2 - 1;
                        System.arraycopy(iArr, 2, iArr, 0, i5);
                        iArr[i5] = 0;
                        iArr[i2] = 0;
                        i2--;
                    } else {
                        return new int[]{i, nextSet, i3};
                    }
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m13883a(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = f18684b;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = f18683a;
            if (i3 >= iArr2.length) {
                break;
            }
            float patternMatchVariance = patternMatchVariance(iArr, iArr2[i3], 0.7f);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x018c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x018f, code lost:
        if (r18 == false) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0191, code lost:
        if (r14 != 'e') goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0193, code lost:
        r14 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0196, code lost:
        r14 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0198, code lost:
        r18 = r5;
        r15 = 6;
        r23 = r12;
        r12 = r8;
        r8 = r21;
        r21 = r19;
        r19 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ec, code lost:
        r14 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0103, code lost:
        r5 = false;
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0124, code lost:
        r5 = r3;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0130, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0139, code lost:
        r5 = r3;
        r3 = false;
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x013d, code lost:
        r5 = r3;
        r3 = false;
        r14 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0144, code lost:
        r14 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0147, code lost:
        r5 = r3;
        r3 = false;
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x014b, code lost:
        r23 = r5;
        r5 = r3;
        r3 = r23;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.dqr.Result decodeRow(int r25, com.didi.dqr.common.BitArray r26, java.util.Map<com.didi.dqr.DecodeHintType, ?> r27) throws com.didi.dqr.NotFoundException, com.didi.dqr.FormatException, com.didi.dqr.ChecksumException {
        /*
            r24 = this;
            r0 = r26
            r1 = r27
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.didi.dqr.DecodeHintType r4 = com.didi.dqr.DecodeHintType.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            int[] r4 = m13884a(r26)
            r5 = 2
            r6 = r4[r5]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r6
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            switch(r6) {
                case 103: goto L_0x0037;
                case 104: goto L_0x0034;
                case 105: goto L_0x0031;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.didi.dqr.FormatException r0 = com.didi.dqr.FormatException.getFormatInstance()
            throw r0
        L_0x0031:
            r12 = 99
            goto L_0x0039
        L_0x0034:
            r12 = 100
            goto L_0x0039
        L_0x0037:
            r12 = 101(0x65, float:1.42E-43)
        L_0x0039:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r8)
            r8 = r4[r3]
            r14 = r4[r2]
            r15 = 6
            int[] r2 = new int[r15]
            r9 = 0
            r16 = 0
            r17 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = r12
            r12 = r8
            r8 = r14
            r14 = r23
        L_0x0058:
            if (r16 != 0) goto L_0x01a7
            int r12 = m13883a(r0, r2, r8)
            byte r5 = (byte) r12
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)
            r7.add(r5)
            r5 = 106(0x6a, float:1.49E-43)
            if (r12 == r5) goto L_0x006c
            r17 = 1
        L_0x006c:
            if (r12 == r5) goto L_0x0074
            int r20 = r20 + 1
            int r21 = r20 * r12
            int r6 = r6 + r21
        L_0x0074:
            r21 = r8
            r11 = 0
        L_0x0077:
            if (r11 >= r15) goto L_0x0080
            r22 = r2[r11]
            int r21 = r21 + r22
            int r11 = r11 + 1
            goto L_0x0077
        L_0x0080:
            switch(r12) {
                case 103: goto L_0x008e;
                case 104: goto L_0x008e;
                case 105: goto L_0x008e;
                default: goto L_0x0083;
            }
        L_0x0083:
            r11 = 96
            java.lang.String r15 = "]C1"
            switch(r14) {
                case 99: goto L_0x0153;
                case 100: goto L_0x00f0;
                case 101: goto L_0x0093;
                default: goto L_0x008a;
            }
        L_0x008a:
            r10 = 100
            goto L_0x018c
        L_0x008e:
            com.didi.dqr.FormatException r0 = com.didi.dqr.FormatException.getFormatInstance()
            throw r0
        L_0x0093:
            r10 = 64
            if (r12 >= r10) goto L_0x00aa
            if (r9 != r3) goto L_0x00a1
            int r5 = r12 + 32
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0103
        L_0x00a1:
            int r5 = r12 + 32
            int r5 = r5 + 128
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0103
        L_0x00aa:
            if (r12 >= r11) goto L_0x00bc
            if (r9 != r3) goto L_0x00b5
            int r5 = r12 + -64
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0103
        L_0x00b5:
            int r5 = r12 + 64
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0103
        L_0x00bc:
            if (r12 == r5) goto L_0x00c0
            r17 = 0
        L_0x00c0:
            if (r12 == r5) goto L_0x0147
            switch(r12) {
                case 98: goto L_0x00ea;
                case 99: goto L_0x013d;
                case 100: goto L_0x00e7;
                case 101: goto L_0x00d9;
                case 102: goto L_0x00c7;
                default: goto L_0x00c5;
            }
        L_0x00c5:
            goto L_0x0124
        L_0x00c7:
            if (r1 == 0) goto L_0x0124
            int r5 = r13.length()
            if (r5 != 0) goto L_0x00d3
            r13.append(r15)
            goto L_0x0124
        L_0x00d3:
            r5 = 29
            r13.append(r5)
            goto L_0x0124
        L_0x00d9:
            if (r3 != 0) goto L_0x00e0
            if (r9 == 0) goto L_0x00e0
            r3 = 0
            r5 = 1
            goto L_0x0130
        L_0x00e0:
            if (r3 == 0) goto L_0x0139
            if (r9 == 0) goto L_0x0139
            r3 = 0
            r5 = 0
            goto L_0x0130
        L_0x00e7:
            r5 = r3
            r3 = 0
            goto L_0x00ec
        L_0x00ea:
            r5 = r3
            r3 = 1
        L_0x00ec:
            r14 = 100
            goto L_0x014b
        L_0x00f0:
            if (r12 >= r11) goto L_0x0109
            if (r9 != r3) goto L_0x00fb
            int r5 = r12 + 32
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0103
        L_0x00fb:
            int r5 = r12 + 32
            int r5 = r5 + 128
            char r5 = (char) r5
            r13.append(r5)
        L_0x0103:
            r5 = 0
            r9 = 0
            r10 = 100
            goto L_0x018d
        L_0x0109:
            if (r12 == r5) goto L_0x010d
            r17 = 0
        L_0x010d:
            if (r12 == r5) goto L_0x0147
            switch(r12) {
                case 98: goto L_0x0142;
                case 99: goto L_0x013d;
                case 100: goto L_0x012a;
                case 101: goto L_0x0127;
                case 102: goto L_0x0113;
                default: goto L_0x0112;
            }
        L_0x0112:
            goto L_0x0124
        L_0x0113:
            if (r1 == 0) goto L_0x0124
            int r5 = r13.length()
            if (r5 != 0) goto L_0x011f
            r13.append(r15)
            goto L_0x0124
        L_0x011f:
            r5 = 29
            r13.append(r5)
        L_0x0124:
            r5 = r3
            r3 = 0
            goto L_0x014b
        L_0x0127:
            r5 = r3
            r3 = 0
            goto L_0x0144
        L_0x012a:
            if (r3 != 0) goto L_0x0132
            if (r9 == 0) goto L_0x0132
            r3 = 0
            r5 = 1
        L_0x0130:
            r9 = 0
            goto L_0x014b
        L_0x0132:
            if (r3 == 0) goto L_0x0139
            if (r9 == 0) goto L_0x0139
            r3 = 0
            r5 = 0
            goto L_0x0130
        L_0x0139:
            r5 = r3
            r3 = 0
            r9 = 1
            goto L_0x014b
        L_0x013d:
            r5 = r3
            r3 = 0
            r14 = 99
            goto L_0x014b
        L_0x0142:
            r5 = r3
            r3 = 1
        L_0x0144:
            r14 = 101(0x65, float:1.42E-43)
            goto L_0x014b
        L_0x0147:
            r5 = r3
            r3 = 0
            r16 = 1
        L_0x014b:
            r10 = 100
            r23 = r5
            r5 = r3
            r3 = r23
            goto L_0x018d
        L_0x0153:
            r10 = 100
            if (r12 >= r10) goto L_0x0164
            r5 = 10
            if (r12 >= r5) goto L_0x0160
            r5 = 48
            r13.append(r5)
        L_0x0160:
            r13.append(r12)
            goto L_0x018c
        L_0x0164:
            if (r12 == r5) goto L_0x0168
            r17 = 0
        L_0x0168:
            if (r12 == r5) goto L_0x0188
            switch(r12) {
                case 100: goto L_0x0184;
                case 101: goto L_0x0180;
                case 102: goto L_0x016e;
                default: goto L_0x016d;
            }
        L_0x016d:
            goto L_0x018c
        L_0x016e:
            if (r1 == 0) goto L_0x018c
            int r5 = r13.length()
            if (r5 != 0) goto L_0x017a
            r13.append(r15)
            goto L_0x018c
        L_0x017a:
            r5 = 29
            r13.append(r5)
            goto L_0x018c
        L_0x0180:
            r5 = 0
            r14 = 101(0x65, float:1.42E-43)
            goto L_0x018d
        L_0x0184:
            r5 = 0
            r14 = 100
            goto L_0x018d
        L_0x0188:
            r5 = 0
            r16 = 1
            goto L_0x018d
        L_0x018c:
            r5 = 0
        L_0x018d:
            r11 = 101(0x65, float:1.42E-43)
            if (r18 == 0) goto L_0x0198
            if (r14 != r11) goto L_0x0196
            r14 = 100
            goto L_0x0198
        L_0x0196:
            r14 = 101(0x65, float:1.42E-43)
        L_0x0198:
            r18 = r5
            r5 = 2
            r15 = 6
            r23 = r12
            r12 = r8
            r8 = r21
            r21 = r19
            r19 = r23
            goto L_0x0058
        L_0x01a7:
            int r1 = r8 - r12
            int r2 = r0.getNextUnset(r8)
            int r3 = r26.getSize()
            int r5 = r2 - r12
            r8 = 2
            int r5 = r5 / r8
            int r5 = r5 + r2
            int r3 = java.lang.Math.min(r3, r5)
            r5 = 0
            boolean r0 = r0.isRange2(r2, r3, r5)
            if (r0 == 0) goto L_0x0237
            r3 = r21
            int r20 = r20 * r3
            int r6 = r6 - r20
            int r6 = r6 % 103
            if (r6 != r3) goto L_0x0232
            int r0 = r13.length()
            if (r0 == 0) goto L_0x022d
            if (r0 <= 0) goto L_0x01e4
            if (r17 == 0) goto L_0x01e4
            r2 = 99
            if (r14 != r2) goto L_0x01df
            int r2 = r0 + -2
            r13.delete(r2, r0)
            goto L_0x01e4
        L_0x01df:
            int r2 = r0 + -1
            r13.delete(r2, r0)
        L_0x01e4:
            r0 = 1
            r2 = r4[r0]
            r0 = 0
            r3 = r4[r0]
            int r2 = r2 + r3
            float r0 = (float) r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r3 = (float) r12
            float r1 = (float) r1
            float r1 = r1 / r2
            float r3 = r3 + r1
            int r1 = r7.size()
            byte[] r2 = new byte[r1]
            r5 = 0
        L_0x01fa:
            if (r5 >= r1) goto L_0x020b
            java.lang.Object r4 = r7.get(r5)
            java.lang.Byte r4 = (java.lang.Byte) r4
            byte r4 = r4.byteValue()
            r2[r5] = r4
            int r5 = r5 + 1
            goto L_0x01fa
        L_0x020b:
            com.didi.dqr.Result r1 = new com.didi.dqr.Result
            java.lang.String r4 = r13.toString()
            r5 = 2
            com.didi.dqr.ResultPoint[] r5 = new com.didi.dqr.ResultPoint[r5]
            com.didi.dqr.ResultPoint r6 = new com.didi.dqr.ResultPoint
            r7 = r25
            float r7 = (float) r7
            r6.<init>(r0, r7)
            r0 = 0
            r5[r0] = r6
            com.didi.dqr.ResultPoint r0 = new com.didi.dqr.ResultPoint
            r0.<init>(r3, r7)
            r3 = 1
            r5[r3] = r0
            com.didi.dqr.BarcodeFormat r0 = com.didi.dqr.BarcodeFormat.CODE_128
            r1.<init>(r4, r2, r5, r0)
            return r1
        L_0x022d:
            com.didi.dqr.NotFoundException r0 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x0232:
            com.didi.dqr.ChecksumException r0 = com.didi.dqr.ChecksumException.getChecksumInstance()
            throw r0
        L_0x0237:
            com.didi.dqr.NotFoundException r0 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.oned.Code128Reader.decodeRow(int, com.didi.dqr.common.BitArray, java.util.Map):com.didi.dqr.Result");
    }
}
