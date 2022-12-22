package com.didi.dqr.pdf417.detector;

import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import java.util.List;

public final class PDF417DetectorResult {

    /* renamed from: a */
    private final BitMatrix f18965a;

    /* renamed from: b */
    private final List<ResultPoint[]> f18966b;

    public PDF417DetectorResult(BitMatrix bitMatrix, List<ResultPoint[]> list) {
        this.f18965a = bitMatrix;
        this.f18966b = list;
    }

    public BitMatrix getBits() {
        return this.f18965a;
    }

    public List<ResultPoint[]> getPoints() {
        return this.f18966b;
    }
}
