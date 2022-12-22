package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import com.microblink.blinkbarcode.secured.IIIllIIlIl;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class lIIlllIIlI {
    public static <T> CaptureRequest.Key<T> IlIllIlIIl(String str, Class<T> cls) {
        IIIllIIlIl.IlIllIlIIl ilIllIlIIl = new IIIllIIlIl.IlIllIlIIl(cls);
        if (!llIllIIlll.llIIlIlIIl()) {
            return null;
        }
        try {
            return (CaptureRequest.Key) lIllIlIlIl.llIIlIlIIl(new Object[]{str, ilIllIlIIl.llIIlIlIIl(), 1});
        } catch (Exception e) {
            Log.m40230e(lIIlllIIlI.class, e, "Failed to create Camera Key", new Object[0]);
            return null;
        }
    }

    public static <T> CameraCharacteristics.Key<T> llIIlIlIIl(String str, Class<T> cls) {
        IIIllIIlIl.IlIllIlIIl ilIllIlIIl = new IIIllIIlIl.IlIllIlIIl(cls);
        if (!llIllIIlll.llIIlIlIIl()) {
            return null;
        }
        try {
            return (CameraCharacteristics.Key) lIllIlIlIl.llIIlIlIIl(new Object[]{str, ilIllIlIIl.llIIlIlIIl(), 0});
        } catch (Exception e) {
            Log.m40230e(lIIlllIIlI.class, e, "Fail to create Camera Key.", new Object[0]);
            return null;
        }
    }
}
