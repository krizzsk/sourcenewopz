package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class IIllllIIlI {
    private boolean IlIllIlIIl = false;
    private boolean llIIlIlIIl = false;

    public void llIIlIlIIl(CameraCharacteristics cameraCharacteristics) {
        if (llIllIIlll.llIIlIlIIl()) {
            try {
                int[] iArr = (int[]) cameraCharacteristics.get(IIIlllIlII.IlIllIlIIl);
                if (iArr != null) {
                    int length = iArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (iArr[i] == 0) {
                            this.llIIlIlIIl = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
                Log.m40231i(this, "Unable to query device for OIS operation mode availability", new Object[0]);
                this.llIIlIlIIl = false;
            }
            Log.m40231i(this, "Samsung optical image stabilisation picture mode supported: {}", Boolean.valueOf(this.llIIlIlIIl));
        }
        int[] iArr2 = (int[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                } else if (iArr2[i2] == 1) {
                    this.IlIllIlIIl = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        Log.m40231i(this, "Optical image stabilisation supported: {}", Boolean.valueOf(this.IlIllIlIIl));
    }

    public void llIIlIlIIl(CaptureRequest.Builder builder) {
        if (this.IlIllIlIIl) {
            Log.m40227d(this, "Activating optical image stabilisation", new Object[0]);
            builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
            if (this.llIIlIlIIl) {
                Log.m40227d(this, "Activating Samsung picture mode for optical image stabilisation", new Object[0]);
                builder.set(lIIIIIllIl.IlIllIlIIl, 0);
            }
        }
    }
}
