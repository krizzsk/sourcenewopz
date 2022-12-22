package com.didi.dqr.common;

import com.didi.dqr.ResultPoint;
import com.didi.dqr.qrcode.detector.FinderPatternInfo;

public class DetectorResult {

    /* renamed from: a */
    private final BitMatrix f18537a;

    /* renamed from: b */
    private final ResultPoint[] f18538b;
    public int contourDilateCount;
    public FinderPatternInfo info;
    public boolean reCaculateMoudleSize;
    public int realContourDilateCount;
    public boolean success;

    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr) {
        this(bitMatrix, resultPointArr, true, false);
    }

    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr, boolean z, boolean z2) {
        this.f18537a = bitMatrix;
        this.f18538b = resultPointArr;
        this.success = z;
        this.reCaculateMoudleSize = z2;
    }

    public DetectorResult(BitMatrix bitMatrix, FinderPatternInfo finderPatternInfo, boolean z, boolean z2) {
        this.f18537a = bitMatrix;
        this.f18538b = finderPatternInfo.getPatternCenters();
        this.info = finderPatternInfo;
        this.success = z;
        this.reCaculateMoudleSize = z2;
    }

    public final BitMatrix getBits() {
        return this.f18537a;
    }

    public final ResultPoint[] getPoints() {
        return this.f18538b;
    }
}
