package com.microblink.blinkbarcode.fragment.overlay.components.settings;

import com.microblink.blinkbarcode.geometry.Rectangle;

/* compiled from: line */
public class ScanRegionOfInterestSettings {
    public final boolean isRotatable;
    public final Rectangle roi;

    public ScanRegionOfInterestSettings(Rectangle rectangle, boolean z) {
        this.roi = rectangle;
        this.isRotatable = z;
    }
}
