package com.microblink.blinkbarcode.metadata.detection.points;

import com.microblink.blinkbarcode.geometry.PointSet;
import com.microblink.blinkbarcode.metadata.detection.DisplayableDetection;

/* compiled from: line */
public final class DisplayablePointsDetection extends DisplayableDetection {
    private PointsType IllIIIIllI;
    private PointSet IllIIIllII;
    private PointSet llIIIlllll;

    public DisplayablePointsDetection(int i, float[] fArr, float[] fArr2, int i2) {
        super(i, fArr);
        this.IllIIIllII = new PointSet(fArr2);
        this.IllIIIIllI = PointsType.values()[i2];
    }

    public PointSet getPointSet() {
        return this.IllIIIllII;
    }

    public PointsType getPointsType() {
        return this.IllIIIIllI;
    }

    public PointSet getTransformedPointSet() {
        if (this.llIIIlllll == null) {
            float[] floatArray = this.IllIIIllII.toFloatArray();
            this.llIIlIlIIl.mapPoints(floatArray);
            this.llIIIlllll = new PointSet(floatArray);
        }
        return this.llIIIlllll;
    }
}
