package com.microblink.blinkbarcode.metadata.detection.quad;

import com.microblink.blinkbarcode.geometry.Quadrilateral;
import com.microblink.blinkbarcode.metadata.detection.DisplayableDetection;

/* compiled from: line */
public final class DisplayableQuadDetection extends DisplayableDetection {
    private Quadrilateral IllIIIllII;
    private Quadrilateral llIIIlllll;

    public DisplayableQuadDetection(int i, float[] fArr, float[] fArr2) {
        super(i, fArr);
        this.IllIIIllII = new Quadrilateral(fArr2);
    }

    public Quadrilateral getDisplayLocation() {
        return this.IllIIIllII;
    }

    public Quadrilateral getTransformedDisplayLocation() {
        if (this.llIIIlllll == null) {
            float[] fArr = new float[8];
            this.IllIIIllII.toFloatArray(fArr);
            this.llIIlIlIIl.mapPoints(fArr);
            this.llIIIlllll = new Quadrilateral(fArr);
        }
        return this.llIIIlllll;
    }
}
