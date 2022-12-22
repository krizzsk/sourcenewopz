package com.didi.dqr.pdf417.detector;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {

    /* renamed from: a */
    private static final int[] f18954a = {0, 4, 1, 5};

    /* renamed from: b */
    private static final int[] f18955b = {6, 2, 7, 3};

    /* renamed from: c */
    private static final float f18956c = 0.42f;

    /* renamed from: d */
    private static final float f18957d = 0.8f;

    /* renamed from: e */
    private static final int[] f18958e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: f */
    private static final int[] f18959f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: g */
    private static final int f18960g = 3;

    /* renamed from: h */
    private static final int f18961h = 5;

    /* renamed from: i */
    private static final int f18962i = 25;

    /* renamed from: j */
    private static final int f18963j = 5;

    /* renamed from: k */
    private static final int f18964k = 10;

    private Detector() {
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> a = m14162a(z, blackMatrix);
        if (a.isEmpty()) {
            blackMatrix = blackMatrix.clone();
            blackMatrix.rotate180();
            a = m14162a(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r4.hasNext() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r5 = (com.didi.dqr.ResultPoint[]) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r5[1] == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r3 = (int) java.lang.Math.max((float) r3, r5[1].getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r5[3] == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r5 != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r4 = r0.iterator();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.didi.dqr.ResultPoint[]> m14162a(boolean r8, com.didi.dqr.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L_0x0008:
            r4 = 0
            r5 = 0
        L_0x000a:
            int r6 = r9.getHeight()
            if (r3 >= r6) goto L_0x007e
            com.didi.dqr.ResultPoint[] r4 = m14165a((com.didi.dqr.common.BitMatrix) r9, (int) r3, (int) r4)
            r6 = r4[r2]
            if (r6 != 0) goto L_0x0053
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L_0x0053
            if (r5 != 0) goto L_0x0020
            goto L_0x007e
        L_0x0020:
            java.util.Iterator r4 = r0.iterator()
        L_0x0024:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0050
            java.lang.Object r5 = r4.next()
            com.didi.dqr.ResultPoint[] r5 = (com.didi.dqr.ResultPoint[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L_0x0040
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.getY()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L_0x0040:
            r7 = r5[r6]
            if (r7 == 0) goto L_0x0024
            r5 = r5[r6]
            float r5 = r5.getY()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L_0x0024
        L_0x0050:
            int r3 = r3 + 5
            goto L_0x0008
        L_0x0053:
            r0.add(r4)
            if (r8 != 0) goto L_0x0059
            goto L_0x007e
        L_0x0059:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L_0x006c
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
            goto L_0x007a
        L_0x006c:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
        L_0x007a:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto L_0x000a
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.detector.Detector.m14162a(boolean, com.didi.dqr.common.BitMatrix):java.util.List");
    }

    /* renamed from: a */
    private static ResultPoint[] m14165a(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        m14163a(resultPointArr, m14166a(bitMatrix, height, width, i, i2, f18958e), f18954a);
        if (resultPointArr[4] != null) {
            i2 = (int) resultPointArr[4].getX();
            i = (int) resultPointArr[4].getY();
        }
        m14163a(resultPointArr, m14166a(bitMatrix, height, width, i, i2, f18959f), f18955b);
        return resultPointArr;
    }

    /* renamed from: a */
    private static void m14163a(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    /* renamed from: a */
    private static ResultPoint[] m14166a(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        int i7 = i;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i7) {
                z = false;
                break;
            }
            int[] a = m14164a(bitMatrix, i4, i8, i2, iArr, iArr2);
            if (a != null) {
                int i9 = i8;
                int[] iArr3 = a;
                int i10 = i9;
                while (true) {
                    if (i10 <= 0) {
                        i6 = i10;
                        break;
                    }
                    int i11 = i10 - 1;
                    int[] a2 = m14164a(bitMatrix, i4, i11, i2, iArr, iArr2);
                    if (a2 == null) {
                        i6 = i11 + 1;
                        break;
                    }
                    iArr3 = a2;
                    i10 = i11;
                }
                float f = (float) i6;
                resultPointArr[0] = new ResultPoint((float) iArr3[0], f);
                resultPointArr[1] = new ResultPoint((float) iArr3[1], f);
                i8 = i6;
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i12 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i13 = i12;
            int i14 = 0;
            while (true) {
                if (i13 >= i7) {
                    i5 = i14;
                    break;
                }
                i5 = i14;
                int[] a3 = m14164a(bitMatrix, iArr4[0], i13, i2, iArr, iArr2);
                if (a3 != null && Math.abs(iArr4[0] - a3[0]) < 5 && Math.abs(iArr4[1] - a3[1]) < 5) {
                    iArr4 = a3;
                    i14 = 0;
                } else if (i5 > 25) {
                    break;
                } else {
                    i14 = i5 + 1;
                }
                i13++;
            }
            i12 = i13 - (i5 + 1);
            float f2 = (float) i12;
            resultPointArr[2] = new ResultPoint((float) iArr4[0], f2);
            resultPointArr[3] = new ResultPoint((float) iArr4[1], f2);
        }
        if (i12 - i8 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    /* renamed from: a */
    private static int[] m14164a(BitMatrix bitMatrix, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (bitMatrix.get(i, i2) != z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else if (m14161a(iArr2, iArr) < f18956c) {
                    return new int[]{i6, i};
                } else {
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || m14161a(iArr2, iArr) >= f18956c) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    /* renamed from: a */
    private static float m14161a(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f = (float) i;
        float f2 = f / ((float) i2);
        float f3 = 0.8f * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f5 = ((float) iArr2[i4]) * f2;
            float f6 = (float) i5;
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }
}
