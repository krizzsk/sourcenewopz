package com.microblink.blinkbarcode.metadata;

import android.graphics.Matrix;

/* compiled from: line */
public abstract class DisplayableObject {
    public Matrix llIIlIlIIl;

    public DisplayableObject(float[] fArr) {
        Matrix matrix = new Matrix();
        this.llIIlIlIIl = matrix;
        matrix.setValues(fArr);
    }

    public final Matrix getTransformMatrix() {
        return this.llIIlIlIIl;
    }
}
