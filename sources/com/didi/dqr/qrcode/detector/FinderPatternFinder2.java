package com.didi.dqr.qrcode.detector;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqrutil.DqrConfigHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder2 implements FinderPatternFinderInter {
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;

    /* renamed from: a */
    private static final int f19059a = 2;

    /* renamed from: b */
    private final BitMatrix f19060b;

    /* renamed from: c */
    private List<FinderPattern> f19061c = new ArrayList();

    /* renamed from: d */
    private boolean f19062d;

    /* renamed from: e */
    private final int[] f19063e = new int[3];

    /* renamed from: f */
    private int f19064f;

    /* renamed from: g */
    private int f19065g;

    public FinderPatternFinder2(BitMatrix bitMatrix) {
        this.f19060b = bitMatrix;
    }

    /* access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.f19060b;
    }

    /* access modifiers changed from: protected */
    public final List<FinderPattern> getPossibleCenters() {
        return this.f19061c;
    }

    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.f19060b.getHeight();
        int width = this.f19060b.getWidth();
        int i = (height * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[3];
        int i2 = i - 1;
        boolean z3 = false;
        while (i2 < height && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.f19060b.get(i3, i2)) {
                    if (i4 == 1) {
                        i4 = 2;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 0) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 2) {
                    if (!foundPatternCross(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = 1;
                        iArr[2] = 0;
                    } else if (handlePossibleCenter(iArr, i2, i3, z2)) {
                        if (this.f19062d) {
                            z3 = m14263c();
                        } else {
                            int b = m14262b();
                            if (b > iArr[2]) {
                                i2 += (b - iArr[2]) - 2;
                                i3 = width - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        i = 2;
                        i4 = 0;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = 1;
                        iArr[2] = 0;
                    }
                    i4 = 1;
                } else {
                    iArr[i4] = iArr[i4] + 1;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width, z2)) {
                i = iArr[0];
                if (this.f19062d) {
                    z3 = m14263c();
                }
            }
            i2 += i;
        }
        if (this.f19061c.size() < 3 && DqrConfigHelper.useContourFinder()) {
            ContourFinder contourFinder = new ContourFinder();
            this.f19061c = contourFinder.getBestCenter(this.f19061c, this.f19060b);
            this.f19064f = contourFinder.contourDilateCount;
            this.f19065g = contourFinder.realContourDilateCount;
        }
        if (this.f19061c.size() < 3) {
            return new FinderPatternInfo((FinderPattern[]) this.f19061c.toArray(new FinderPattern[this.f19061c.size()]), false);
        }
        FinderPattern[] findBestPoint = FindBestPatternUtil.findBestPoint(this.f19061c, BestPatternMethodEnum.TYPE_SHAPE);
        ResultPoint.orderBestPatterns(findBestPoint);
        return new FinderPatternInfo(findBestPoint);
    }

    /* renamed from: a */
    private static float m14259a(int[] iArr, int i) {
        return ((float) i) - (((float) ((iArr[2] + iArr[1]) + iArr[0])) / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
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
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs((f * 5.0f) - ((float) iArr[1])) >= 5.0f * f2 || Math.abs(f - ((float) iArr[2])) >= f2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private int[] m14260a() {
        int[] iArr = this.f19063e;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        return iArr;
    }

    /* renamed from: a */
    private float m14258a(int i, int i2, int i3, int i4) {
        int width = this.f19060b.getWidth();
        int i5 = i4 / 2;
        int i6 = i2 - i5;
        int i7 = i4 / 7;
        int i8 = i6 + i7;
        int i9 = (i4 * 2) / 7;
        int i10 = i6 + i9;
        int i11 = i5 + i2;
        int i12 = i11 - i9;
        int i13 = i11 - i7;
        if (i8 < 0 || i13 > width) {
            return Float.NaN;
        }
        Point[] pointArr = {new Point(Float.NaN, Float.NaN), new Point(Float.NaN, Float.NaN)};
        while (true) {
            if (i8 > i10) {
                break;
            }
            float b = m14261b(i, i8, i3, i4);
            if (!Float.isNaN(b)) {
                pointArr[0] = new Point(b, (float) i8);
                break;
            }
            i8++;
        }
        if (Float.isNaN(pointArr[0].f19066i)) {
            return Float.NaN;
        }
        while (true) {
            if (i12 > i13) {
                break;
            }
            float b2 = m14261b(i, i12, i3, i4);
            if (!Float.isNaN(b2)) {
                pointArr[1] = new Point(b2, (float) i12);
                break;
            }
            i12++;
        }
        if (Float.isNaN(pointArr[1].f19066i)) {
            return Float.NaN;
        }
        float f = (float) i2;
        float access$100 = (f - pointArr[0].f19067j) / (pointArr[1].f19067j - f);
        return ((pointArr[1].f19066i * access$100) + pointArr[0].f19066i) / (access$100 + 1.0f);
    }

    /* renamed from: b */
    private float m14261b(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f19060b;
        int height = bitMatrix.getHeight();
        int[] a = m14260a();
        int i5 = i;
        while (i5 >= 0 && !bitMatrix.get(i2, i5)) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i2, i5) && a[0] <= i3 / 2) {
            a[0] = a[0] + 1;
            i5--;
        }
        int i6 = i3 / 2;
        if (a[0] > i6) {
            return Float.NaN;
        }
        int i7 = i + 1;
        while (i7 < height && !bitMatrix.get(i2, i7)) {
            a[1] = a[1] + 1;
            i7++;
        }
        if (i7 == height) {
            return Float.NaN;
        }
        while (i7 < height && bitMatrix.get(i2, i7) && a[2] < i6) {
            a[2] = a[2] + 1;
            i7++;
        }
        if (a[2] < i6 && ((float) Math.abs(((a[0] + a[1]) + a[2]) - i4)) < DqrConfigHelper.patternTolerant() * ((float) i4) && foundPatternCross(a)) {
            return m14259a(a, i7);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float a = m14259a(iArr, i2);
        float a2 = m14258a(i, (int) a, iArr[1], i3);
        if (Float.isNaN(a2) || Float.isNaN(a)) {
            return false;
        }
        float f = ((float) i3) / 7.0f;
        int i4 = 0;
        while (true) {
            if (i4 >= this.f19061c.size()) {
                break;
            }
            FinderPattern finderPattern = this.f19061c.get(i4);
            if (finderPattern.aboutEquals(f, a2, a)) {
                this.f19061c.set(i4, finderPattern.combineEstimate(a2, a, f));
                z2 = true;
                break;
            }
            i4++;
        }
        if (!z2) {
            this.f19061c.add(new FinderPattern(a, a2, f));
        }
        return true;
    }

    /* renamed from: b */
    private int m14262b() {
        if (this.f19061c.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern next : this.f19061c) {
            if (next.getCount() >= 2) {
                if (finderPattern == null) {
                    finderPattern = next;
                } else {
                    this.f19062d = true;
                    return ((int) (Math.abs(finderPattern.getX() - next.getX()) - Math.abs(finderPattern.getY() - next.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    /* renamed from: c */
    private boolean m14263c() {
        int size = this.f19061c.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (FinderPattern next : this.f19061c) {
            if (next.getCount() >= 2) {
                i++;
                f2 += next.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern estimatedModuleSize : this.f19061c) {
            f += Math.abs(estimatedModuleSize.getEstimatedModuleSize() - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    private class Point {
        /* access modifiers changed from: private */

        /* renamed from: i */
        public float f19066i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public float f19067j;

        public Point(float f, float f2) {
            this.f19066i = f;
            this.f19067j = f2;
        }
    }

    public int getContourDilateCount() {
        return this.f19064f;
    }

    public int getRealContourDilateCount() {
        return this.f19065g;
    }
}
