package com.microblink.blinkbarcode.util;

import android.hardware.Camera;
import com.microblink.blinkbarcode.hardware.IllIIIllII;

/* compiled from: line */
public class llIIlIlIIl {
    private static boolean IlIllIlIIl;
    private static int llIIlIlIIl;

    public static boolean IlIllIlIIl() {
        return IlIllIlIIl;
    }

    public static void llIIlIlIIl(int i, IllIIIllII illIIIllII) {
        Class<llIIlIlIIl> cls = llIIlIlIIl.class;
        Log.m40227d(cls, "Initializing default orientation to: {}", Integer.valueOf(i));
        if (!illIIIllII.llIIlIIIll()) {
            llIIlIlIIl = i;
            IlIllIlIIl = true;
        } else {
            Log.m40227d(cls, "Display orientation is blacklisted!", new Object[0]);
            llIIlIlIIl = 0;
            IlIllIlIIl = false;
        }
        Log.m40227d(cls, "Default orientation initialized to: {}", Integer.valueOf(llIIlIlIIl));
    }

    public static void llIIlIlIIl(Camera camera, int i, int i2, boolean z) {
        int i3;
        if (camera == null) {
            return;
        }
        if (IlIllIlIIl) {
            if (z) {
                i3 = (((i2 - 270) + i) + 360) % 360;
            } else {
                i3 = (((i2 - 90) + i) + 360) % 360;
            }
            camera.setDisplayOrientation(i3);
            return;
        }
        Log.m40235w(llIIlIlIIl.class, "Set DisplayOrientationMethod not supported.", new Object[0]);
    }

    public static int llIIlIlIIl() {
        return llIIlIlIIl;
    }
}
