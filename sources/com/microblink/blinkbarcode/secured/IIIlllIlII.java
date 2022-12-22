package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraCharacteristics;

/* compiled from: line */
public class IIIlllIlII extends IlllIlllll {
    public static final CameraCharacteristics.Key<int[]> IlIllIlIIl;
    public static final CameraCharacteristics.Key<Boolean> llIIlIlIIl = lIIlllIIlI.llIIlIlIIl("samsung.android.control.pafAvailableMode", Boolean.TYPE);

    static {
        Class<int[]> cls = int[].class;
        lIIlllIIlI.llIIlIlIIl("samsung.android.control.meteringAvailableMode", cls);
        IlIllIlIIl = lIIlllIIlI.llIIlIlIIl("samsung.android.lens.info.availableOpticalStabilizationOperationMode", cls);
    }
}
