package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.util.llIIlIlIIl;

/* compiled from: line */
public class IIIIIIIIII extends IlIIIIIlll {
    public IIIIIIIIII(Camera camera, int i, Context context) {
        super(camera, i, context);
    }

    public void IlIllIlIIl() {
        Log.m40231i(this, "Using HQ strategy", new Object[0]);
    }

    public double llIIlIlIIl(Camera.Size size, double d, long j, CameraType cameraType) {
        if (!llIIlIlIIl(size, cameraType)) {
            return Double.POSITIVE_INFINITY;
        }
        return Math.abs(((((double) size.width) * ((double) size.height)) / ((double) j)) - 1.0d) * 1200.0d;
    }

    public String toString() {
        return "HQ camera strategy!";
    }

    public Camera.Size llIIlIlIIl(int i, int i2, CameraType cameraType) {
        if (this.IlIllIlIIl == null) {
            return null;
        }
        Log.m40233v(this, "surface size is: {}x{}", Integer.valueOf(i), Integer.valueOf(i2));
        Camera.Size llIIlIlIIl = llIIlIlIIl(cameraType);
        if (llIIlIlIIl != null) {
            return llIIlIlIIl;
        }
        if (llIIlIlIIl.llIIlIlIIl() == 1) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        return llIIlIlIIl(this.IlIllIlIIl, ((double) i) / ((double) i2), 2073600, cameraType);
    }
}
