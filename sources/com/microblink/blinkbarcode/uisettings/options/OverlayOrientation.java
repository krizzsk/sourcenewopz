package com.microblink.blinkbarcode.uisettings.options;

import com.microblink.blinkbarcode.hardware.orientation.Orientation;

/* compiled from: line */
public enum OverlayOrientation {
    PORTRAIT,
    LANDSCAPE;

    public int toActivityInfoOrientation() {
        return this == PORTRAIT ? 1 : 0;
    }

    public Orientation toOrientation() {
        return this == PORTRAIT ? Orientation.ORIENTATION_PORTRAIT : Orientation.ORIENTATION_LANDSCAPE_RIGHT;
    }
}
