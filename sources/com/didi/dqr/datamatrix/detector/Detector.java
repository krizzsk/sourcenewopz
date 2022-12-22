package com.didi.dqr.datamatrix.detector;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DetectorResult;
import com.didi.dqr.common.GridSampler;
import com.didi.dqr.common.detector.WhiteRectangleDetector;

public final class Detector {

    /* renamed from: a */
    private final BitMatrix f18609a;

    /* renamed from: b */
    private final WhiteRectangleDetector f18610b;

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.f18609a = bitMatrix;
        this.f18610b = new WhiteRectangleDetector(bitMatrix);
    }

    public DetectorResult detect() throws NotFoundException {
        int i;
        int i2;
        ResultPoint[] b = m13794b(m13793a(this.f18610b.detect()));
        b[3] = m13795c(b);
        if (b[3] != null) {
            ResultPoint[] d = m13796d(b);
            ResultPoint resultPoint = d[0];
            ResultPoint resultPoint2 = d[1];
            ResultPoint resultPoint3 = d[2];
            ResultPoint resultPoint4 = d[3];
            int a = m13788a(resultPoint, resultPoint4) + 1;
            int a2 = m13788a(resultPoint3, resultPoint4) + 1;
            if ((a & 1) == 1) {
                a++;
            }
            if ((a2 & 1) == 1) {
                a2++;
            }
            if (a * 4 >= a2 * 7 || a2 * 4 >= a * 7) {
                i2 = a;
                i = a2;
            } else {
                i2 = Math.max(a, a2);
                i = i2;
            }
            return new DetectorResult(m13791a(this.f18609a, resultPoint, resultPoint2, resultPoint3, resultPoint4, i2, i), new ResultPoint[]{resultPoint, resultPoint2, resultPoint3, resultPoint4});
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static ResultPoint m13790a(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float f = (float) (i + 1);
        return new ResultPoint(resultPoint.getX() + ((resultPoint2.getX() - resultPoint.getX()) / f), resultPoint.getY() + ((resultPoint2.getY() - resultPoint.getY()) / f));
    }

    /* renamed from: a */
    private static ResultPoint m13789a(ResultPoint resultPoint, float f, float f2) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        return new ResultPoint(x < f ? x - 1.0f : x + 1.0f, y < f2 ? y - 1.0f : y + 1.0f);
    }

    /* renamed from: a */
    private ResultPoint[] m13793a(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[3];
        ResultPoint resultPoint4 = resultPointArr[2];
        int a = m13788a(resultPoint, resultPoint2);
        int a2 = m13788a(resultPoint2, resultPoint3);
        int a3 = m13788a(resultPoint3, resultPoint4);
        int a4 = m13788a(resultPoint4, resultPoint);
        ResultPoint[] resultPointArr2 = {resultPoint4, resultPoint, resultPoint2, resultPoint3};
        if (a > a2) {
            resultPointArr2[0] = resultPoint;
            resultPointArr2[1] = resultPoint2;
            resultPointArr2[2] = resultPoint3;
            resultPointArr2[3] = resultPoint4;
            a = a2;
        }
        if (a > a3) {
            resultPointArr2[0] = resultPoint2;
            resultPointArr2[1] = resultPoint3;
            resultPointArr2[2] = resultPoint4;
            resultPointArr2[3] = resultPoint;
        } else {
            a3 = a;
        }
        if (a3 > a4) {
            resultPointArr2[0] = resultPoint3;
            resultPointArr2[1] = resultPoint4;
            resultPointArr2[2] = resultPoint;
            resultPointArr2[3] = resultPoint2;
        }
        return resultPointArr2;
    }

    /* renamed from: b */
    private ResultPoint[] m13794b(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[2];
        ResultPoint resultPoint4 = resultPointArr[3];
        int a = (m13788a(resultPoint, resultPoint4) + 1) * 4;
        if (m13788a(m13790a(resultPoint2, resultPoint3, a), resultPoint) < m13788a(m13790a(resultPoint3, resultPoint2, a), resultPoint4)) {
            resultPointArr[0] = resultPoint;
            resultPointArr[1] = resultPoint2;
            resultPointArr[2] = resultPoint3;
            resultPointArr[3] = resultPoint4;
        } else {
            resultPointArr[0] = resultPoint2;
            resultPointArr[1] = resultPoint3;
            resultPointArr[2] = resultPoint4;
            resultPointArr[3] = resultPoint;
        }
        return resultPointArr;
    }

    /* renamed from: c */
    private ResultPoint m13795c(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[2];
        ResultPoint resultPoint4 = resultPointArr[3];
        int a = m13788a(resultPoint, resultPoint4);
        ResultPoint a2 = m13790a(resultPoint, resultPoint2, (m13788a(resultPoint2, resultPoint4) + 1) * 4);
        ResultPoint a3 = m13790a(resultPoint3, resultPoint2, (a + 1) * 4);
        int a4 = m13788a(a2, resultPoint4);
        int a5 = m13788a(a3, resultPoint4);
        float f = (float) (a4 + 1);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + ((resultPoint3.getX() - resultPoint2.getX()) / f), resultPoint4.getY() + ((resultPoint3.getY() - resultPoint2.getY()) / f));
        float f2 = (float) (a5 + 1);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + ((resultPoint.getX() - resultPoint2.getX()) / f2), resultPoint4.getY() + ((resultPoint.getY() - resultPoint2.getY()) / f2));
        if (m13792a(resultPoint5)) {
            return (m13792a(resultPoint6) && m13788a(a2, resultPoint5) + m13788a(a3, resultPoint5) <= m13788a(a2, resultPoint6) + m13788a(a3, resultPoint6)) ? resultPoint6 : resultPoint5;
        }
        if (m13792a(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    /* renamed from: d */
    private ResultPoint[] m13796d(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[2];
        ResultPoint resultPoint4 = resultPointArr[3];
        ResultPoint a = m13790a(resultPoint, resultPoint2, (m13788a(resultPoint3, resultPoint4) + 1) * 4);
        ResultPoint a2 = m13790a(resultPoint3, resultPoint2, (m13788a(resultPoint, resultPoint4) + 1) * 4);
        int a3 = m13788a(a, resultPoint4) + 1;
        int a4 = m13788a(a2, resultPoint4) + 1;
        if ((a3 & 1) == 1) {
            a3++;
        }
        if ((a4 & 1) == 1) {
            a4++;
        }
        float x = (((resultPoint.getX() + resultPoint2.getX()) + resultPoint3.getX()) + resultPoint4.getX()) / 4.0f;
        float y = (((resultPoint.getY() + resultPoint2.getY()) + resultPoint3.getY()) + resultPoint4.getY()) / 4.0f;
        ResultPoint a5 = m13789a(resultPoint, x, y);
        ResultPoint a6 = m13789a(resultPoint2, x, y);
        ResultPoint a7 = m13789a(resultPoint3, x, y);
        ResultPoint a8 = m13789a(resultPoint4, x, y);
        int i = a4 * 4;
        int i2 = a3 * 4;
        return new ResultPoint[]{m13790a(m13790a(a5, a6, i), a8, i2), m13790a(m13790a(a6, a5, i), a7, i2), m13790a(m13790a(a7, a8, i), a6, i2), m13790a(m13790a(a8, a7, i), a5, i2)};
    }

    /* renamed from: a */
    private boolean m13792a(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.f18609a.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.f18609a.getHeight());
    }

    /* renamed from: a */
    private static BitMatrix m13791a(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = ((float) i) - 0.5f;
        float f2 = ((float) i2) - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    /* renamed from: a */
    private int m13788a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i = 0;
        int i2 = 1;
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        if (z) {
            int i3 = y;
            y = x;
            x = i3;
            int i4 = y2;
            y2 = x2;
            x2 = i4;
        }
        int abs = Math.abs(x2 - x);
        int abs2 = Math.abs(y2 - y);
        int i5 = (-abs) / 2;
        int i6 = y < y2 ? 1 : -1;
        if (x >= x2) {
            i2 = -1;
        }
        boolean z2 = this.f18609a.get(z ? y : x, z ? x : y);
        while (x != x2) {
            boolean z3 = this.f18609a.get(z ? y : x, z ? x : y);
            if (z3 != z2) {
                i++;
                z2 = z3;
            }
            i5 += abs2;
            if (i5 > 0) {
                if (y == y2) {
                    break;
                }
                y += i6;
                i5 -= abs;
            }
            x += i2;
        }
        return i;
    }
}
