package com.microblink.blinkbarcode.secured;

import com.microblink.blinkbarcode.geometry.Quadrilateral;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class IIlIIIllIl implements llIIlIIlll {
    public Orientation IlIllIlIIl = null;
    public float llIIlIlIIl = 0.45f;

    public IIlIIIllIl(float f, Orientation orientation) {
        this.llIIlIlIIl = f;
        this.IlIllIlIIl = orientation;
    }

    public void llIIlIlIIl(Orientation orientation) {
        if (orientation != null && orientation != Orientation.ORIENTATION_UNKNOWN) {
            this.IlIllIlIIl = orientation;
        }
    }

    public Orientation llIIlIlIIl() {
        return this.IlIllIlIIl;
    }

    public Quadrilateral llIIlIlIIl(Quadrilateral quadrilateral) {
        int ordinal = this.IlIllIlIIl.ordinal();
        if (ordinal == 0) {
            return new Quadrilateral(quadrilateral.getUpperLeft(), quadrilateral.getUpperRight(), quadrilateral.getLowerLeft().operatorPlus(quadrilateral.getUpperLeft().operatorMinus(quadrilateral.getLowerLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerRight().operatorPlus(quadrilateral.getUpperRight().operatorMinus(quadrilateral.getLowerRight()).operatorMultiply(this.llIIlIlIIl)));
        } else if (ordinal == 1) {
            return new Quadrilateral(quadrilateral.getUpperLeft(), quadrilateral.getUpperRight().operatorPlus(quadrilateral.getUpperLeft().operatorMinus(quadrilateral.getUpperRight()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerLeft(), quadrilateral.getLowerRight().operatorPlus(quadrilateral.getLowerLeft().operatorMinus(quadrilateral.getLowerRight()).operatorMultiply(this.llIIlIlIIl)));
        } else if (ordinal == 2) {
            return new Quadrilateral(quadrilateral.getUpperLeft().operatorPlus(quadrilateral.getLowerLeft().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getUpperRight().operatorPlus(quadrilateral.getLowerRight().operatorMinus(quadrilateral.getUpperRight()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerLeft(), quadrilateral.getLowerRight());
        } else if (ordinal == 3) {
            return new Quadrilateral(quadrilateral.getUpperLeft().operatorPlus(quadrilateral.getUpperRight().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getUpperRight(), quadrilateral.getLowerLeft().operatorPlus(quadrilateral.getLowerRight().operatorMinus(quadrilateral.getLowerLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerRight());
        } else if (ordinal != 4) {
            return null;
        } else {
            Log.m40229e(this, "Illegal orientation set as current orientation!", new Object[0]);
            return null;
        }
    }
}
