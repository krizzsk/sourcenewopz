package com.microblink.blinkbarcode.geometry;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;

/* compiled from: line */
public class QuadrangleEvaluator implements TypeEvaluator<Quadrilateral> {
    private Quadrilateral IlIllIlIIl = new Quadrilateral();
    private ArgbEvaluator llIIlIlIIl = new ArgbEvaluator();

    public Quadrilateral evaluate(float f, Quadrilateral quadrilateral, Quadrilateral quadrilateral2) {
        int intValue = ((Integer) this.llIIlIlIIl.evaluate(f, Integer.valueOf(quadrilateral.getColor()), Integer.valueOf(quadrilateral2.getColor()))).intValue();
        Point makeCopy = quadrilateral2.getUpperLeft().makeCopy();
        makeCopy.operatorMinusEquals(quadrilateral.getUpperLeft()).operatorMultiplyEquals(f);
        Point makeCopy2 = quadrilateral2.getUpperRight().makeCopy();
        makeCopy2.operatorMinusEquals(quadrilateral.getUpperRight()).operatorMultiplyEquals(f);
        Point makeCopy3 = quadrilateral2.getLowerLeft().makeCopy();
        makeCopy3.operatorMinusEquals(quadrilateral.getLowerLeft()).operatorMultiplyEquals(f);
        Point makeCopy4 = quadrilateral2.getLowerRight().makeCopy();
        makeCopy4.operatorMinusEquals(quadrilateral.getLowerRight()).operatorMultiplyEquals(f);
        this.IlIllIlIIl.setPoints(quadrilateral.getUpperLeft().operatorPlus(makeCopy), quadrilateral.getUpperRight().operatorPlus(makeCopy2), quadrilateral.getLowerLeft().operatorPlus(makeCopy3), quadrilateral.getLowerRight().operatorPlus(makeCopy4));
        this.IlIllIlIIl.setColor(intValue);
        if (quadrilateral2.isDefaultQuad() && (((double) f) > 0.95d || quadrilateral.isDefaultQuad())) {
            this.IlIllIlIIl.setIsDefaultQuad(true);
        }
        return this.IlIllIlIIl;
    }
}
