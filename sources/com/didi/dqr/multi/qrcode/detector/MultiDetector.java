package com.didi.dqr.multi.qrcode.detector;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.ReaderException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DetectorResult;
import com.didi.dqr.qrcode.detector.Detector;
import com.didi.dqr.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Map;

public final class MultiDetector extends Detector {

    /* renamed from: a */
    private static final DetectorResult[] f18663a = new DetectorResult[0];

    public MultiDetector(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    public DetectorResult[] detectMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        FinderPatternInfo[] a = new MultiFinderPatternFinder(getImage()).mo58366a(map);
        if (a.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (FinderPatternInfo processFinderPatternInfo : a) {
                try {
                    arrayList.add(processFinderPatternInfo(processFinderPatternInfo));
                } catch (ReaderException unused) {
                }
            }
            if (arrayList.isEmpty()) {
                return f18663a;
            }
            return (DetectorResult[]) arrayList.toArray(new DetectorResult[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
