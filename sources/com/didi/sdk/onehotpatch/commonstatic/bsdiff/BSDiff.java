package com.didi.sdk.onehotpatch.commonstatic.bsdiff;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BSDiff {
    private static final byte[] MAGIC_BYTES = {77, 105, 99, 114, 111, 77, 115, 103};

    private static void split(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        if (i6 < 16) {
            int i8 = i5;
            while (true) {
                int i9 = i5 + i6;
                if (i8 < i9) {
                    int i10 = iArr4[iArr3[i8] + i7];
                    int i11 = 1;
                    int i12 = 1;
                    while (true) {
                        int i13 = i8 + i11;
                        if (i13 >= i9) {
                            break;
                        }
                        if (iArr4[iArr3[i13] + i7] < i10) {
                            i10 = iArr4[iArr3[i13] + i7];
                            i12 = 0;
                        }
                        if (iArr4[iArr3[i13] + i7] == i10) {
                            int i14 = i8 + i12;
                            int i15 = iArr3[i14];
                            iArr3[i14] = iArr3[i13];
                            iArr3[i13] = i15;
                            i12++;
                        }
                        i11++;
                    }
                    for (int i16 = 0; i16 < i12; i16++) {
                        iArr4[iArr3[i8 + i16]] = (i8 + i12) - 1;
                    }
                    if (i12 == 1) {
                        iArr3[i8] = -1;
                    }
                    i8 += i12;
                } else {
                    return;
                }
            }
        } else {
            int i17 = iArr4[iArr3[(i6 / 2) + i5] + i7];
            int i18 = i5;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                i4 = i5 + i6;
                if (i18 >= i4) {
                    break;
                }
                if (iArr4[iArr3[i18] + i7] < i17) {
                    i19++;
                }
                if (iArr4[iArr3[i18] + i7] == i17) {
                    i20++;
                }
                i18++;
            }
            int i21 = i19 + i5;
            int i22 = i20 + i21;
            int i23 = i5;
            int i24 = 0;
            int i25 = 0;
            while (i23 < i21) {
                if (iArr4[iArr3[i23] + i7] < i17) {
                    i23++;
                } else if (iArr4[iArr3[i23] + i7] == i17) {
                    int i26 = iArr3[i23];
                    int i27 = i21 + i24;
                    iArr3[i23] = iArr3[i27];
                    iArr3[i27] = i26;
                    i24++;
                } else {
                    int i28 = iArr3[i23];
                    int i29 = i22 + i25;
                    iArr3[i23] = iArr3[i29];
                    iArr3[i29] = i28;
                    i25++;
                }
            }
            while (true) {
                int i30 = i21 + i24;
                if (i30 >= i22) {
                    break;
                } else if (iArr4[iArr3[i30] + i7] == i17) {
                    i24++;
                } else {
                    int i31 = iArr3[i30];
                    int i32 = i22 + i25;
                    iArr3[i30] = iArr3[i32];
                    iArr3[i32] = i31;
                    i25++;
                }
            }
            if (i21 > i5) {
                split(iArr3, iArr4, i5, i21 - i5, i7);
            }
            for (int i33 = 0; i33 < i22 - i21; i33++) {
                iArr4[iArr3[i21 + i33]] = i22 - 1;
            }
            if (i21 == i22 - 1) {
                iArr3[i21] = -1;
            }
            if (i4 > i22) {
                split(iArr3, iArr4, i22, i4 - i22, i7);
            }
        }
    }

    private static void qsufsort(int[] iArr, int[] iArr2, byte[] bArr, int i) {
        int i2;
        int i3;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < i; i4++) {
            byte b = 255 & bArr[i4];
            iArr3[b] = iArr3[b] + 1;
        }
        for (int i5 = 1; i5 < 256; i5++) {
            iArr3[i5] = iArr3[i5] + iArr3[i5 - 1];
        }
        for (int i6 = 255; i6 > 0; i6--) {
            iArr3[i6] = iArr3[i6 - 1];
        }
        iArr3[0] = 0;
        for (int i7 = 0; i7 < i; i7++) {
            byte b2 = bArr[i7] & 255;
            int i8 = iArr3[b2] + 1;
            iArr3[b2] = i8;
            iArr[i8] = i7;
        }
        iArr[0] = i;
        for (int i9 = 0; i9 < i; i9++) {
            iArr2[i9] = iArr3[bArr[i9] & 255];
        }
        iArr2[i] = 0;
        for (int i10 = 1; i10 < 256; i10++) {
            if (iArr3[i10] == iArr3[i10 - 1] + 1) {
                iArr[iArr3[i10]] = -1;
            }
        }
        iArr[0] = -1;
        int i11 = 1;
        while (true) {
            i2 = i + 1;
            if (iArr[0] == (-i2)) {
                break;
            }
            int i12 = 0;
            while (true) {
                i3 = 0;
                while (i12 < i2) {
                    if (iArr[i12] < 0) {
                        i3 -= iArr[i12];
                        i12 -= iArr[i12];
                    } else {
                        if (i3 != 0) {
                            iArr[i12 - i3] = -i3;
                        }
                        int i13 = (iArr2[iArr[i12]] + 1) - i12;
                        split(iArr, iArr2, i12, i13, i11);
                        i12 += i13;
                    }
                }
                break;
            }
            if (i3 != 0) {
                iArr[i12 - i3] = -i3;
            }
            i11 += i11;
        }
        for (int i14 = 0; i14 < i2; i14++) {
            iArr[iArr2[i14]] = i14;
        }
    }

    private static int search(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, IntByRef intByRef) {
        IntByRef intByRef2 = intByRef;
        int i6 = i5 - i4;
        if (i6 < 2) {
            int matchlen = matchlen(bArr, i, iArr[i4], bArr2, i2, i3);
            int matchlen2 = matchlen(bArr, i, iArr[i5], bArr2, i2, i3);
            if (matchlen > matchlen2) {
                int unused = intByRef2.value = iArr[i4];
                return matchlen;
            }
            int unused2 = intByRef2.value = iArr[i5];
            return matchlen2;
        }
        int i7 = i4 + (i6 / 2);
        if (memcmp(bArr, i, iArr[i7], bArr2, i2, i3) < 0) {
            return search(iArr, bArr, i, bArr2, i2, i3, i7, i5, intByRef);
        }
        return search(iArr, bArr, i, bArr2, i2, i3, i4, i7, intByRef);
    }

    private static int matchlen(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int min = Math.min(i - i2, i3 - i4);
        for (int i5 = 0; i5 < min; i5++) {
            if (bArr[i2 + i5] != bArr2[i4 + i5]) {
                return i5;
            }
        }
        return min;
    }

    private static int memcmp(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i - i2;
        int i6 = i3 - i4;
        if (i5 > i6) {
            i5 = i6;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 + i2;
            int i9 = i7 + i4;
            if (bArr[i8] != bArr2[i9]) {
                return bArr[i8] < bArr2[i9] ? -1 : 1;
            }
        }
        return 0;
    }

    public static void bsdiff(File file, File file2, File file3) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            fileOutputStream.write(bsdiff((InputStream) bufferedInputStream, (int) file.length(), (InputStream) bufferedInputStream2, (int) file2.length()));
        } finally {
            fileOutputStream.close();
        }
    }

    public static byte[] bsdiff(InputStream inputStream, int i, InputStream inputStream2, int i2) throws IOException {
        byte[] bArr = new byte[i];
        BSUtil.readFromStream(inputStream, bArr, 0, i);
        inputStream.close();
        byte[] bArr2 = new byte[i2];
        BSUtil.readFromStream(inputStream2, bArr2, 0, i2);
        inputStream2.close();
        return bsdiff(bArr, i, bArr2, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bsdiff(byte[] r31, int r32, byte[] r33, int r34) throws java.io.IOException {
        /*
            r9 = r31
            r10 = r32
            r11 = r34
            int r0 = r10 + 1
            int[] r12 = new int[r0]
            int[] r0 = new int[r0]
            qsufsort(r12, r0, r9, r10)
            byte[] r13 = new byte[r11]
            byte[] r14 = new byte[r11]
            java.io.ByteArrayOutputStream r15 = new java.io.ByteArrayOutputStream
            r15.<init>()
            java.io.DataOutputStream r8 = new java.io.DataOutputStream
            r8.<init>(r15)
            byte[] r0 = MAGIC_BYTES
            r8.write(r0)
            r0 = -1
            r8.writeLong(r0)
            r8.writeLong(r0)
            long r6 = (long) r11
            r8.writeLong(r6)
            r8.flush()
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream
            r5.<init>(r8)
            java.io.DataOutputStream r4 = new java.io.DataOutputStream
            r4.<init>(r5)
            com.didi.sdk.onehotpatch.commonstatic.bsdiff.BSDiff$IntByRef r3 = new com.didi.sdk.onehotpatch.commonstatic.bsdiff.BSDiff$IntByRef
            r0 = 0
            r3.<init>()
            r2 = 0
            r0 = 0
            r1 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x004e:
            if (r0 >= r11) goto L_0x01ee
            int r0 = r0 + r17
            r21 = r17
            r22 = 0
            r17 = r0
        L_0x0058:
            if (r0 >= r11) goto L_0x00c4
            r21 = 0
            r23 = r0
            r0 = r12
            r24 = r1
            r1 = r31
            r2 = r32
            r25 = r3
            r3 = r33
            r26 = r4
            r4 = r34
            r27 = r5
            r5 = r23
            r28 = r6
            r6 = r21
            r7 = r32
            r30 = r8
            r8 = r25
            int r0 = search(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r17
            r2 = r22
            r3 = r23
        L_0x0085:
            int r4 = r3 + r0
            if (r1 >= r4) goto L_0x0098
            int r4 = r1 + r18
            if (r4 >= r10) goto L_0x0095
            byte r4 = r9[r4]
            byte r5 = r33[r1]
            if (r4 != r5) goto L_0x0095
            int r2 = r2 + 1
        L_0x0095:
            int r1 = r1 + 1
            goto L_0x0085
        L_0x0098:
            if (r0 != r2) goto L_0x009c
            if (r0 != 0) goto L_0x00d5
        L_0x009c:
            int r4 = r2 + 8
            if (r0 <= r4) goto L_0x00a1
            goto L_0x00d5
        L_0x00a1:
            int r4 = r3 + r18
            if (r4 >= r10) goto L_0x00ad
            byte r4 = r9[r4]
            byte r5 = r33[r3]
            if (r4 != r5) goto L_0x00ad
            int r2 = r2 + -1
        L_0x00ad:
            r22 = r2
            int r2 = r3 + 1
            r21 = r0
            r17 = r1
            r0 = r2
            r1 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r8 = r30
            r2 = 0
            goto L_0x0058
        L_0x00c4:
            r24 = r1
            r25 = r3
            r26 = r4
            r27 = r5
            r28 = r6
            r30 = r8
            r3 = r0
            r0 = r21
            r2 = r22
        L_0x00d5:
            if (r0 != r2) goto L_0x00ec
            if (r3 != r11) goto L_0x00da
            goto L_0x00ec
        L_0x00da:
            r17 = r0
            r0 = r3
            r1 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r8 = r30
        L_0x00e9:
            r2 = 0
            goto L_0x004e
        L_0x00ec:
            r1 = 0
            r2 = 0
            r4 = 0
            r5 = 0
        L_0x00f0:
            int r6 = r19 + r2
            if (r6 >= r3) goto L_0x010d
            int r7 = r20 + r2
            if (r7 >= r10) goto L_0x010d
            byte r7 = r9[r7]
            byte r6 = r33[r6]
            if (r7 != r6) goto L_0x0100
            int r1 = r1 + 1
        L_0x0100:
            int r2 = r2 + 1
            int r6 = r1 * 2
            int r6 = r6 - r2
            int r7 = r4 * 2
            int r7 = r7 - r5
            if (r6 <= r7) goto L_0x00f0
            r4 = r1
            r5 = r2
            goto L_0x00f0
        L_0x010d:
            if (r3 >= r11) goto L_0x0139
            r1 = 1
            r2 = 0
            r4 = 0
            r6 = 0
        L_0x0113:
            int r7 = r19 + r1
            if (r3 < r7) goto L_0x013a
            int r7 = r25.value
            if (r7 < r1) goto L_0x013a
            int r7 = r25.value
            int r7 = r7 - r1
            byte r7 = r9[r7]
            int r8 = r3 - r1
            byte r8 = r33[r8]
            if (r7 != r8) goto L_0x012c
            int r4 = r4 + 1
        L_0x012c:
            int r7 = r4 * 2
            int r7 = r7 - r1
            int r8 = r6 * 2
            int r8 = r8 - r2
            if (r7 <= r8) goto L_0x0136
            r2 = r1
            r6 = r4
        L_0x0136:
            int r1 = r1 + 1
            goto L_0x0113
        L_0x0139:
            r2 = 0
        L_0x013a:
            int r1 = r19 + r5
            int r4 = r3 - r2
            if (r1 <= r4) goto L_0x0185
            int r6 = r1 - r4
            r18 = r0
            r0 = 0
            r7 = 0
            r8 = 0
            r17 = 0
        L_0x0149:
            if (r7 >= r6) goto L_0x0180
            int r21 = r1 - r6
            int r21 = r21 + r7
            r22 = r1
            byte r1 = r33[r21]
            int r21 = r20 + r5
            int r21 = r21 - r6
            int r21 = r21 + r7
            byte r10 = r9[r21]
            if (r1 != r10) goto L_0x015f
            int r17 = r17 + 1
        L_0x015f:
            int r1 = r4 + r7
            byte r1 = r33[r1]
            int r10 = r25.value
            int r10 = r10 - r2
            int r10 = r10 + r7
            byte r10 = r9[r10]
            if (r1 != r10) goto L_0x016f
            int r17 = r17 + -1
        L_0x016f:
            r1 = r17
            if (r1 <= r0) goto L_0x0177
            int r0 = r7 + 1
            r8 = r0
            r0 = r1
        L_0x0177:
            int r7 = r7 + 1
            r10 = r32
            r17 = r1
            r1 = r22
            goto L_0x0149
        L_0x0180:
            int r0 = r8 - r6
            int r5 = r5 + r0
            int r2 = r2 - r8
            goto L_0x0187
        L_0x0185:
            r18 = r0
        L_0x0187:
            r0 = 0
        L_0x0188:
            if (r0 >= r5) goto L_0x019d
            r1 = r24
            int r4 = r1 + r0
            int r6 = r19 + r0
            byte r6 = r33[r6]
            int r7 = r20 + r0
            byte r7 = r9[r7]
            int r6 = r6 - r7
            byte r6 = (byte) r6
            r13[r4] = r6
            int r0 = r0 + 1
            goto L_0x0188
        L_0x019d:
            r1 = r24
            r0 = 0
        L_0x01a0:
            int r4 = r3 - r2
            int r6 = r19 + r5
            int r7 = r4 - r6
            if (r0 >= r7) goto L_0x01b6
            r8 = r16
            int r16 = r8 + r0
            int r6 = r6 + r0
            byte r4 = r33[r6]
            r14[r16] = r4
            int r0 = r0 + 1
            r16 = r8
            goto L_0x01a0
        L_0x01b6:
            r8 = r16
            int r1 = r1 + r5
            int r16 = r8 + r7
            r0 = r26
            r0.writeInt(r5)
            r0.writeInt(r7)
            int r6 = r25.value
            int r6 = r6 - r2
            int r20 = r20 + r5
            int r6 = r6 - r20
            r0.writeInt(r6)
            int r5 = r25.value
            int r20 = r5 - r2
            int r2 = r25.value
            int r2 = r2 - r3
            r10 = r32
            r19 = r4
            r17 = r18
            r5 = r27
            r6 = r28
            r8 = r30
            r4 = r0
            r18 = r2
            r0 = r3
            r3 = r25
            goto L_0x00e9
        L_0x01ee:
            r0 = r4
            r27 = r5
            r28 = r6
            r30 = r8
            r8 = r16
            r0.flush()
            r27.finish()
            int r0 = r30.size()
            r2 = 32
            int r0 = r0 - r2
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream
            r4 = r30
            r3.<init>(r4)
            r5 = 0
            r3.write(r13, r5, r1)
            r3.finish()
            r3.flush()
            int r1 = r4.size()
            int r1 = r1 - r0
            int r1 = r1 - r2
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream
            r3.<init>(r4)
            r3.write(r14, r5, r8)
            r3.finish()
            r3.flush()
            r4.close()
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>(r2)
            java.io.DataOutputStream r2 = new java.io.DataOutputStream
            r2.<init>(r3)
            byte[] r4 = MAGIC_BYTES
            r2.write(r4)
            long r6 = (long) r0
            r2.writeLong(r6)
            long r0 = (long) r1
            r2.writeLong(r0)
            r0 = r28
            r2.writeLong(r0)
            r2.close()
            byte[] r0 = r15.toByteArray()
            byte[] r1 = r3.toByteArray()
            int r2 = r1.length
            java.lang.System.arraycopy(r1, r5, r0, r5, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.bsdiff.BSDiff.bsdiff(byte[], int, byte[], int):byte[]");
    }

    private static class IntByRef {
        /* access modifiers changed from: private */
        public int value;

        private IntByRef() {
        }
    }
}
