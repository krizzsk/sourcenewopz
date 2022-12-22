package com.didi.dqr.qrcode.detector;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.NotFoundException;
import java.util.Map;

public interface FinderPatternFinderInter {
    FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException;

    int getContourDilateCount();

    int getRealContourDilateCount();
}
