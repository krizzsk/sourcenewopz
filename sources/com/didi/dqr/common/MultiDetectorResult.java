package com.didi.dqr.common;

import java.util.ArrayList;
import java.util.List;

public class MultiDetectorResult {
    public List<DetectorResult> detectorResults = new ArrayList();
    public boolean fromAutoCompete;
    public boolean fromAutoCorrect;

    public void addDetectorResult(DetectorResult detectorResult) {
        this.detectorResults.add(detectorResult);
    }

    public boolean success() {
        return this.detectorResults.get(0).success;
    }
}
