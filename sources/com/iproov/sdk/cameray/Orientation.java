package com.iproov.sdk.cameray;

public enum Orientation {
    PORTRAIT(0, true),
    LANDSCAPE(90, false),
    REVERSE_PORTRAIT(180, true),
    REVERSE_LANDSCAPE(270, false);
    
    public final int angleDegrees;
    private boolean isPortrait;

    private Orientation(int i, boolean z) {
        this.angleDegrees = i;
        this.isPortrait = z;
    }

    public static Orientation findByDegrees(int i) {
        for (Orientation orientation : values()) {
            if (orientation.angleDegrees == i) {
                return orientation;
            }
        }
        return null;
    }

    public boolean isPortrait() {
        return this.isPortrait;
    }
}
