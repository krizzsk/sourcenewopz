package com.didi.dqr.qrcode.detector;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqrutil.DqrConfigHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder implements FinderPatternFinderInter {
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;

    /* renamed from: a */
    private static final int f19052a = 2;

    /* renamed from: b */
    private final BitMatrix f19053b;

    /* renamed from: c */
    private List<FinderPattern> f19054c = new ArrayList();

    /* renamed from: d */
    private boolean f19055d;

    /* renamed from: e */
    private final int[] f19056e = new int[5];

    /* renamed from: f */
    private int f19057f;

    /* renamed from: g */
    private int f19058g;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this.f19053b = bitMatrix;
    }

    /* access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.f19053b;
    }

    /* access modifiers changed from: protected */
    public final List<FinderPattern> getPossibleCenters() {
        return this.f19054c;
    }

    public FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.f19053b.getHeight();
        int width = this.f19053b.getWidth();
        int i = (height * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean z3 = false;
        while (i2 < height && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.f19053b.get(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 4) {
                    if (!foundPatternCross(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (handlePossibleCenter(iArr, i2, i3, z2)) {
                        if (this.f19055d) {
                            z3 = m14257c();
                        } else {
                            int b = m14255b();
                            if (b > iArr[2]) {
                                i2 += (b - iArr[2]) - 2;
                                i3 = width - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i = 2;
                        i4 = 0;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i4 = 3;
                } else {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width, z2)) {
                i = iArr[0];
                if (this.f19055d) {
                    z3 = m14257c();
                }
            }
            i2 += i;
        }
        if (this.f19054c.size() < 3 && DqrConfigHelper.useContourFinder()) {
            ContourFinder contourFinder = new ContourFinder();
            this.f19054c = contourFinder.getBestCenter(this.f19054c, this.f19053b);
            this.f19057f = contourFinder.contourDilateCount;
            this.f19058g = contourFinder.realContourDilateCount;
        }
        if (this.f19054c.size() < 3) {
            return new FinderPatternInfo((FinderPattern[]) this.f19054c.toArray(new FinderPattern[this.f19054c.size()]), false);
        }
        FinderPattern[] findBestPoint = FindBestPatternUtil.findBestPoint(this.f19054c, DqrConfigHelper.findBestPatternType());
        if (findBestPoint.length < 3) {
            return new FinderPatternInfo(findBestPoint, false);
        }
        ResultPoint.orderBestPatterns(findBestPoint);
        return new FinderPatternInfo(findBestPoint);
    }

    /* renamed from: a */
    private static float m14251a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private int[] m14253a() {
        int[] iArr = this.f19056e;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a2 A[LOOP:4: B:41:0x00a2->B:49:0x00b7, LOOP_START, PHI: r10 
      PHI: (r10v2 int) = (r10v1 int), (r10v5 int) binds: [B:40:0x009e, B:49:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ca A[LOOP:5: B:55:0x00ca->B:63:0x00df, LOOP_START, PHI: r10 
      PHI: (r10v3 int) = (r10v2 int), (r10v4 int) binds: [B:54:0x00c7, B:63:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m14252a(int r17, int r18, int r19, int r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            int[] r4 = r16.m14253a()
            r5 = 0
            r6 = 0
        L_0x000e:
            r7 = 2
            r8 = 1
            if (r1 < r6) goto L_0x0028
            if (r2 < r6) goto L_0x0028
            com.didi.dqr.common.BitMatrix r9 = r0.f19053b
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 == 0) goto L_0x0028
            r9 = r4[r7]
            int r9 = r9 + r8
            r4[r7] = r9
            int r6 = r6 + 1
            goto L_0x000e
        L_0x0028:
            if (r1 < r6) goto L_0x010b
            if (r2 >= r6) goto L_0x002e
            goto L_0x010b
        L_0x002e:
            if (r1 < r6) goto L_0x004a
            if (r2 < r6) goto L_0x004a
            com.didi.dqr.common.BitMatrix r9 = r0.f19053b
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 != 0) goto L_0x004a
            r9 = r4[r8]
            if (r9 > r3) goto L_0x004a
            r9 = r4[r8]
            int r9 = r9 + r8
            r4[r8] = r9
            int r6 = r6 + 1
            goto L_0x002e
        L_0x004a:
            if (r1 < r6) goto L_0x010b
            if (r2 < r6) goto L_0x010b
            r9 = r4[r8]
            if (r9 <= r3) goto L_0x0054
            goto L_0x010b
        L_0x0054:
            if (r1 < r6) goto L_0x0070
            if (r2 < r6) goto L_0x0070
            com.didi.dqr.common.BitMatrix r9 = r0.f19053b
            int r10 = r2 - r6
            int r11 = r1 - r6
            boolean r9 = r9.get(r10, r11)
            if (r9 == 0) goto L_0x0070
            r9 = r4[r5]
            if (r9 > r3) goto L_0x0070
            r9 = r4[r5]
            int r9 = r9 + r8
            r4[r5] = r9
            int r6 = r6 + 1
            goto L_0x0054
        L_0x0070:
            r6 = r4[r5]
            if (r6 <= r3) goto L_0x0075
            return r5
        L_0x0075:
            com.didi.dqr.common.BitMatrix r6 = r0.f19053b
            int r6 = r6.getHeight()
            com.didi.dqr.common.BitMatrix r9 = r0.f19053b
            int r9 = r9.getWidth()
            r10 = 1
        L_0x0082:
            int r11 = r1 + r10
            if (r11 >= r6) goto L_0x009a
            int r12 = r2 + r10
            if (r12 >= r9) goto L_0x009a
            com.didi.dqr.common.BitMatrix r13 = r0.f19053b
            boolean r12 = r13.get(r12, r11)
            if (r12 == 0) goto L_0x009a
            r11 = r4[r7]
            int r11 = r11 + r8
            r4[r7] = r11
            int r10 = r10 + 1
            goto L_0x0082
        L_0x009a:
            if (r11 >= r6) goto L_0x010b
            int r11 = r2 + r10
            if (r11 < r9) goto L_0x00a2
            goto L_0x010b
        L_0x00a2:
            int r11 = r1 + r10
            r12 = 3
            if (r11 >= r6) goto L_0x00bf
            int r13 = r2 + r10
            if (r13 >= r9) goto L_0x00bf
            com.didi.dqr.common.BitMatrix r14 = r0.f19053b
            boolean r13 = r14.get(r13, r11)
            if (r13 != 0) goto L_0x00bf
            r13 = r4[r12]
            if (r13 >= r3) goto L_0x00bf
            r11 = r4[r12]
            int r11 = r11 + r8
            r4[r12] = r11
            int r10 = r10 + 1
            goto L_0x00a2
        L_0x00bf:
            if (r11 >= r6) goto L_0x010b
            int r11 = r2 + r10
            if (r11 >= r9) goto L_0x010b
            r11 = r4[r12]
            if (r11 < r3) goto L_0x00ca
            goto L_0x010b
        L_0x00ca:
            int r11 = r1 + r10
            r13 = 4
            if (r11 >= r6) goto L_0x00e7
            int r14 = r2 + r10
            if (r14 >= r9) goto L_0x00e7
            com.didi.dqr.common.BitMatrix r15 = r0.f19053b
            boolean r11 = r15.get(r14, r11)
            if (r11 == 0) goto L_0x00e7
            r11 = r4[r13]
            if (r11 >= r3) goto L_0x00e7
            r11 = r4[r13]
            int r11 = r11 + r8
            r4[r13] = r11
            int r10 = r10 + 1
            goto L_0x00ca
        L_0x00e7:
            r1 = r4[r13]
            if (r1 < r3) goto L_0x00ec
            return r5
        L_0x00ec:
            r1 = r4[r5]
            r2 = r4[r8]
            int r1 = r1 + r2
            r2 = r4[r7]
            int r1 = r1 + r2
            r2 = r4[r12]
            int r1 = r1 + r2
            r2 = r4[r13]
            int r1 = r1 + r2
            int r1 = r1 - r20
            int r1 = java.lang.Math.abs(r1)
            int r2 = r20 * 2
            if (r1 >= r2) goto L_0x010b
            boolean r1 = foundPatternCross(r4)
            if (r1 == 0) goto L_0x010b
            r5 = 1
        L_0x010b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.qrcode.detector.FinderPatternFinder.m14252a(int, int, int, int):boolean");
    }

    /* renamed from: b */
    private float m14254b(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f19053b;
        int height = bitMatrix.getHeight();
        int[] a = m14253a();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i2, i5) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < height && bitMatrix.get(i2, i6)) {
            a[2] = a[2] + 1;
            i6++;
        }
        if (i6 == height) {
            return Float.NaN;
        }
        while (i6 < height && !bitMatrix.get(i2, i6) && a[3] < i3) {
            a[3] = a[3] + 1;
            i6++;
        }
        if (i6 == height || a[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < height && bitMatrix.get(i2, i6) && a[4] < i3) {
            a[4] = a[4] + 1;
            i6++;
        }
        if (a[4] < i3 && ((float) Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4)) < DqrConfigHelper.patternTolerant() * ((float) i4) && foundPatternCross(a)) {
            return m14251a(a, i6);
        }
        return Float.NaN;
    }

    /* renamed from: c */
    private float m14256c(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f19053b;
        int width = bitMatrix.getWidth();
        int[] a = m14253a();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i5, i2) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < width && bitMatrix.get(i6, i2)) {
            a[2] = a[2] + 1;
            i6++;
        }
        if (i6 == width) {
            return Float.NaN;
        }
        while (i6 < width && !bitMatrix.get(i6, i2) && a[3] < i3) {
            a[3] = a[3] + 1;
            i6++;
        }
        if (i6 == width || a[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < width && bitMatrix.get(i6, i2) && a[4] < i3) {
            a[4] = a[4] + 1;
            i6++;
        }
        if (a[4] < i3 && ((float) Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4)) < DqrConfigHelper.patternTolerant() * ((float) i4) && foundPatternCross(a)) {
            return m14251a(a, i6);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a = (int) m14251a(iArr, i2);
        float b = m14254b(i, a, iArr[2], i3);
        if (!Float.isNaN(b)) {
            int i4 = (int) b;
            float c = m14256c(a, i4, iArr[2], i3);
            if (!Float.isNaN(c) && (!z || m14252a(i4, (int) c, iArr[2], i3))) {
                float f = ((float) i3) / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f19054c.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.f19054c.get(i5);
                    if (finderPattern.aboutEquals(f, b, c)) {
                        this.f19054c.set(i5, finderPattern.combineEstimate(b, c, f));
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    this.f19054c.add(new FinderPattern(c, b, f));
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private int m14255b() {
        if (this.f19054c.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern next : this.f19054c) {
            if (next.getCount() >= 2) {
                if (finderPattern == null) {
                    finderPattern = next;
                } else {
                    this.f19055d = true;
                    return ((int) (Math.abs(finderPattern.getX() - next.getX()) - Math.abs(finderPattern.getY() - next.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    /* renamed from: c */
    private boolean m14257c() {
        int size = this.f19054c.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (FinderPattern next : this.f19054c) {
            if (next.getCount() >= 2) {
                i++;
                f2 += next.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern estimatedModuleSize : this.f19054c) {
            f += Math.abs(estimatedModuleSize.getEstimatedModuleSize() - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    public int getContourDilateCount() {
        return this.f19057f;
    }

    public int getRealContourDilateCount() {
        return this.f19058g;
    }
}
