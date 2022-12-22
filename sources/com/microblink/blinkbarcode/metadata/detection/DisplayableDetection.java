package com.microblink.blinkbarcode.metadata.detection;

import com.microblink.blinkbarcode.metadata.DisplayableObject;
import com.microblink.blinkbarcode.view.recognition.DetectionStatus;

/* compiled from: line */
public abstract class DisplayableDetection extends DisplayableObject {
    public DetectionStatus IlIllIlIIl;

    public DisplayableDetection(int i, float[] fArr) {
        super(fArr);
        this.IlIllIlIIl = DetectionStatus.values()[i];
    }

    public final DetectionStatus getDetectionStatus() {
        return this.IlIllIlIIl;
    }
}
