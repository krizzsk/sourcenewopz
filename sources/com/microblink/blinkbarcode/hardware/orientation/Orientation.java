package com.microblink.blinkbarcode.hardware.orientation;

/* compiled from: line */
public enum Orientation {
    ORIENTATION_PORTRAIT(0, true, false),
    ORIENTATION_LANDSCAPE_RIGHT(1, false, true),
    ORIENTATION_PORTRAIT_UPSIDE(2, true, false),
    ORIENTATION_LANDSCAPE_LEFT(3, false, true),
    ORIENTATION_UNKNOWN(4, false, false);
    
    private boolean IlIllIlIIl;
    private boolean IllIIIllII;
    private int llIIlIlIIl;

    private Orientation(int i, boolean z, boolean z2) {
        this.llIIlIlIIl = i;
        this.IlIllIlIIl = z;
        this.IllIIIllII = z2;
    }

    public static Orientation fromActivityInfoCode(int i) {
        if (i == 0) {
            return ORIENTATION_LANDSCAPE_RIGHT;
        }
        if (i == 1) {
            return ORIENTATION_PORTRAIT;
        }
        if (i == 8) {
            return ORIENTATION_LANDSCAPE_LEFT;
        }
        if (i != 9) {
            return ORIENTATION_PORTRAIT;
        }
        return ORIENTATION_PORTRAIT_UPSIDE;
    }

    public static Orientation fromInt(int i) {
        if (i == 0) {
            return ORIENTATION_PORTRAIT;
        }
        if (i == 1) {
            return ORIENTATION_LANDSCAPE_RIGHT;
        }
        if (i == 2) {
            return ORIENTATION_PORTRAIT_UPSIDE;
        }
        if (i != 3) {
            return ORIENTATION_UNKNOWN;
        }
        return ORIENTATION_LANDSCAPE_LEFT;
    }

    public int intValue() {
        return this.llIIlIlIIl;
    }

    public boolean isHorizontal() {
        return this.IllIIIllII;
    }

    public boolean isVertical() {
        return this.IlIllIlIIl;
    }

    public Orientation rotate180() {
        return fromInt((this.llIIlIlIIl + 2) % 4);
    }

    public Orientation rotate90Clockwise() {
        return fromInt((this.llIIlIlIIl + 3) % 4);
    }

    public Orientation rotate90CounterClockwise() {
        return fromInt((this.llIIlIlIIl + 1) % 4);
    }

    public String toString() {
        int i = this.llIIlIlIIl;
        if (i == 0) {
            return "Portrait";
        }
        if (i == 1) {
            return "Landscape right";
        }
        if (i != 2) {
            return i != 3 ? "Unknown" : "Landscape left";
        }
        return "Inverse portrait";
    }
}
