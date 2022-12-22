package com.didi.dqr.qrcode.detector;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DetectorResult;
import com.didi.dqr.common.GridSampler;
import com.didi.dqr.common.MultiDetectorResult;
import com.didi.dqr.common.PerspectiveTransform;
import com.didi.dqr.common.detector.MathUtils;
import com.didi.dqr.qrcode.decoder.Version;
import com.didi.dqrutil.DqrConfigHelper;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import java.util.Map;

public class Detector {
    public static int detectCount;

    /* renamed from: a */
    private final int f19046a = DqrConfigHelper.newFinderRate();

    /* renamed from: b */
    private final BitMatrix f19047b;

    public Detector(BitMatrix bitMatrix) {
        this.f19047b = bitMatrix;
    }

    /* access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.f19047b;
    }

    public MultiDetectorResult detect() throws NotFoundException, FormatException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.dqr.common.MultiDetectorResult detect(java.util.Map<com.didi.dqr.DecodeHintType, ?> r7) throws com.didi.dqr.NotFoundException, com.didi.dqr.FormatException {
        /*
            r6 = this;
            int r0 = r6.f19046a
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            int r3 = detectCount
            int r0 = r3 % r0
            if (r0 == 0) goto L_0x000d
            goto L_0x001d
        L_0x000d:
            int r3 = r3 + r2
            detectCount = r3
            com.didi.dqr.qrcode.detector.FinderPatternFinder2 r0 = new com.didi.dqr.qrcode.detector.FinderPatternFinder2
            com.didi.dqr.common.BitMatrix r3 = r6.f19047b
            r0.<init>(r3)
            com.didi.dqr.qrcode.detector.FinderPatternInfo r7 = r0.find(r7)
            r3 = 0
            goto L_0x002e
        L_0x001d:
            int r0 = detectCount
            int r0 = r0 + r2
            detectCount = r0
            com.didi.dqr.qrcode.detector.FinderPatternFinder r0 = new com.didi.dqr.qrcode.detector.FinderPatternFinder
            com.didi.dqr.common.BitMatrix r3 = r6.f19047b
            r0.<init>(r3)
            com.didi.dqr.qrcode.detector.FinderPatternInfo r7 = r0.find(r7)
            r3 = 1
        L_0x002e:
            boolean r4 = r7.success
            r5 = 0
            if (r4 == 0) goto L_0x0045
            com.didi.dqr.common.DetectorResult r1 = new com.didi.dqr.common.DetectorResult
            r1.<init>((com.didi.dqr.common.BitMatrix) r5, (com.didi.dqr.qrcode.detector.FinderPatternInfo) r7, (boolean) r2, (boolean) r3)
            int r7 = r0.getContourDilateCount()
            r1.contourDilateCount = r7
            int r7 = r0.getRealContourDilateCount()
            r1.realContourDilateCount = r7
            goto L_0x004b
        L_0x0045:
            com.didi.dqr.common.DetectorResult r0 = new com.didi.dqr.common.DetectorResult
            r0.<init>((com.didi.dqr.common.BitMatrix) r5, (com.didi.dqr.qrcode.detector.FinderPatternInfo) r7, (boolean) r1, (boolean) r2)
            r1 = r0
        L_0x004b:
            com.didi.dqr.common.MultiDetectorResult r7 = new com.didi.dqr.common.MultiDetectorResult
            r7.<init>()
            r7.addDetectorResult(r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.qrcode.detector.Detector.detect(java.util.Map):com.didi.dqr.common.MultiDetectorResult");
    }

    /* access modifiers changed from: protected */
    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        return processFinderPatternInfo(finderPatternInfo, true);
    }

    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo, boolean z) throws NotFoundException, FormatException {
        float f;
        ResultPoint[] resultPointArr;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        if (z) {
            f = calculateModuleSize(topLeft, topRight, bottomLeft);
        } else {
            f = (((topLeft.getEstimatedModuleSize() * 2.0f) + topRight.getEstimatedModuleSize()) + bottomLeft.getEstimatedModuleSize()) / 4.0f;
        }
        if (f >= 1.0f) {
            int a = m14241a((ResultPoint) topLeft, (ResultPoint) topRight, (ResultPoint) bottomLeft, f);
            Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(a);
            int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
            AlignmentPattern alignmentPattern = null;
            if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
                float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
                float f2 = 1.0f - (3.0f / ((float) dimensionForVersion));
                int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f2));
                int y2 = (int) (topLeft.getY() + (f2 * (y - topLeft.getY())));
                int i = 4;
                while (true) {
                    if (i > 16) {
                        break;
                    }
                    try {
                        alignmentPattern = findAlignmentInRegion(f, x2, y2, (float) i);
                        break;
                    } catch (NotFoundException unused) {
                        i <<= 1;
                    }
                }
            }
            BitMatrix a2 = m14242a(this.f19047b, m14243a(topLeft, topRight, bottomLeft, alignmentPattern, a), a);
            if (alignmentPattern == null) {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight};
            } else {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern};
            }
            return new DetectorResult(a2, resultPointArr, true, false);
        }
        AnalysisManager.report(EventId.COMPUTE_MODEL_SIZE_FAILED);
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static PerspectiveTransform m14243a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f;
        float f2;
        float f3;
        float f4 = ((float) i) - 3.5f;
        if (resultPoint4 != null) {
            f2 = resultPoint4.getX();
            f = resultPoint4.getY();
            f3 = f4 - 3.0f;
        } else {
            f2 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            f = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f3 = f4;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f4, 3.5f, f3, f3, 3.5f, f4, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f2, f, resultPoint3.getX(), resultPoint3.getY());
    }

    /* renamed from: a */
    private static BitMatrix m14242a(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i, perspectiveTransform);
    }

    /* renamed from: a */
    private static int m14241a(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f)) / 2) + 7;
        int i = round & 3;
        if (i == 0) {
            return round + 1;
        }
        if (i == 2) {
            return round - 1;
        }
        if (i != 3) {
            return round;
        }
        AnalysisManager.report(EventId.COMPUTE_DIMENSION_FAILED);
        throw NotFoundException.getNotFoundInstance();
    }

    /* access modifiers changed from: protected */
    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (m14240a(resultPoint, resultPoint2) + m14240a(resultPoint, resultPoint3)) / 2.0f;
    }

    /* renamed from: a */
    private float m14240a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float a = m14239a((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float a2 = m14239a((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(a)) {
            return a2 / 7.0f;
        }
        return Float.isNaN(a2) ? a / 7.0f : (a + a2) / 14.0f;
    }

    /* renamed from: a */
    private float m14239a(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float b = m14244b(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = ((float) i) / ((float) (i - i5));
            i5 = 0;
        } else if (i5 >= this.f19047b.getWidth()) {
            f = ((float) ((this.f19047b.getWidth() - 1) - i)) / ((float) (i5 - i));
            i5 = this.f19047b.getWidth() - 1;
        } else {
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i7 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i7 < 0) {
            f2 = f3 / ((float) (i2 - i7));
        } else if (i7 >= this.f19047b.getHeight()) {
            f2 = ((float) ((this.f19047b.getHeight() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.f19047b.getHeight() - 1;
        } else {
            i6 = i7;
            f2 = 1.0f;
        }
        return (b + m14244b(i, i2, (int) (((float) i) + (((float) (i5 - i)) * f2)), i6)) - 1.0f;
    }

    /* renamed from: b */
    private float m14244b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        Detector detector;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i7 = i;
            i8 = i2;
            i5 = i3;
            i6 = i4;
        } else {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i6 - i8);
        int abs2 = Math.abs(i5 - i7);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i8 < i6 ? 1 : -1;
        if (i7 < i5) {
            i12 = 1;
        }
        int i14 = i6 + i13;
        int i15 = i8;
        int i16 = i7;
        int i17 = 0;
        while (true) {
            if (i15 == i14) {
                i9 = i14;
                break;
            }
            int i18 = z3 ? i16 : i15;
            int i19 = z3 ? i15 : i16;
            if (i17 == i10) {
                detector = this;
                z = z3;
                i9 = i14;
                z2 = true;
            } else {
                detector = this;
                z = z3;
                i9 = i14;
                z2 = false;
            }
            if (z2 == detector.f19047b.get(i18, i19)) {
                if (i17 == 2) {
                    return MathUtils.distance(i15, i16, i8, i7);
                }
                i17++;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (i16 == i5) {
                    break;
                }
                i16 += i12;
                i11 -= abs;
            }
            i15 += i13;
            i14 = i9;
            z3 = z;
            i10 = 1;
        }
        if (i17 == 2) {
            return MathUtils.distance(i9, i5, i8, i7);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f19047b.getWidth() - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.f19047b.getHeight() - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                return new C7902a(this.f19047b, max, max2, min, min2, f).mo58645a();
            }
            AnalysisManager.report(EventId.ALIGNMENT_PATTERN_FIND_FAILED);
            throw NotFoundException.getNotFoundInstance();
        }
        AnalysisManager.report(EventId.ALIGNMENT_PATTERN_FIND_FAILED);
        throw NotFoundException.getNotFoundInstance();
    }
}
