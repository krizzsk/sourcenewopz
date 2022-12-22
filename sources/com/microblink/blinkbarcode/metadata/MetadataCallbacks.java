package com.microblink.blinkbarcode.metadata;

import com.microblink.blinkbarcode.metadata.detection.FailedDetectionCallback;
import com.microblink.blinkbarcode.metadata.detection.points.PointsDetectionCallback;
import com.microblink.blinkbarcode.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.blinkbarcode.metadata.image.DebugImageCallback;
import com.microblink.blinkbarcode.metadata.text.DebugTextCallback;

/* compiled from: line */
public final class MetadataCallbacks {
    private DebugTextCallback IlIllIlIIl;
    private FailedDetectionCallback IllIIIIllI;
    private QuadDetectionCallback IllIIIllII;
    private PointsDetectionCallback llIIIlllll;
    private DebugImageCallback llIIlIlIIl;

    public DebugImageCallback getDebugImageCallback() {
        return this.llIIlIlIIl;
    }

    public DebugTextCallback getDebugTextCallback() {
        return this.IlIllIlIIl;
    }

    public FailedDetectionCallback getFailedDetectionCallback() {
        return this.IllIIIIllI;
    }

    public PointsDetectionCallback getPointsDetectionCallback() {
        return this.llIIIlllll;
    }

    public QuadDetectionCallback getQuadDetectionCallback() {
        return this.IllIIIllII;
    }

    public void setDebugImageCallback(DebugImageCallback debugImageCallback) {
        this.llIIlIlIIl = debugImageCallback;
    }

    public void setDebugTextCallback(DebugTextCallback debugTextCallback) {
        this.IlIllIlIIl = debugTextCallback;
    }

    public void setFailedDetectionCallback(FailedDetectionCallback failedDetectionCallback) {
        this.IllIIIIllI = failedDetectionCallback;
    }

    public void setPointsDetectionCallback(PointsDetectionCallback pointsDetectionCallback) {
        this.llIIIlllll = pointsDetectionCallback;
    }

    public void setQuadDetectionCallback(QuadDetectionCallback quadDetectionCallback) {
        this.IllIIIllII = quadDetectionCallback;
    }
}
