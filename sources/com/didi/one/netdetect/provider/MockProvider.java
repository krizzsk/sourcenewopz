package com.didi.one.netdetect.provider;

import com.didi.one.netdetect.model.DetectionGroup;

public class MockProvider implements IDetectionGroupProvider {
    public DetectionGroup providerDetectionGroup() {
        DetectionGroup detectionGroup = new DetectionGroup();
        detectionGroup.detectInterval = 180;
        detectionGroup.detecTimeout = 2000;
        detectionGroup.pingCount = 5;
        detectionGroup.pingTimeout = 1000;
        detectionGroup.trInterval = 3600;
        detectionGroup.trPercent = 100;
        detectionGroup.pingOutputInterval = 3600;
        detectionGroup.pingOutputPercent = 100;
        detectionGroup.checkValid();
        return detectionGroup;
    }
}
