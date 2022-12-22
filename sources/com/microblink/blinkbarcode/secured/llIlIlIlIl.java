package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl;
import com.microblink.blinkbarcode.hardware.camera.VideoResolutionPreset;
import com.microblink.blinkbarcode.util.Log;
import java.util.List;

/* compiled from: line */
public class llIlIlIlIl implements lIlIIlIIll {
    public IlIIIIIlll llIIlIlIIl(Context context, Camera camera, IlIllIlIIl ilIllIlIIl) {
        IlIIIIIlll ilIIIIIlll;
        boolean z;
        if (context == null) {
            Log.m40229e(this, "Device manager must be set to create CameraStrategy", new Object[0]);
            throw new NullPointerException("Device manager must be set to create CameraStrategy");
        } else if (camera == null) {
            Log.m40229e(this, "Cannot create strategy for null camera!", new Object[0]);
            throw new NullPointerException("Cannot create strategy for null camera!");
        } else if (ilIllIlIIl != null) {
            if (ilIllIlIIl.IIlIIIllIl() == VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT) {
                List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    for (Camera.Size next : supportedPreviewSizes) {
                        if (Math.min(next.width, next.height) >= 720) {
                            Log.m40231i(this, "Device camera is HD ready!", new Object[0]);
                            z = true;
                            break;
                        }
                    }
                    Log.m40231i(this, "Device camera is not HD ready!", new Object[0]);
                }
                z = false;
                if (z) {
                    ilIIIIIlll = new IIIIIIIIII(camera, ilIllIlIIl.IllIIIIllI(), context);
                } else {
                    ilIIIIIlll = new IIIllIlIIl(camera, ilIllIlIIl.IllIIIIllI(), context);
                }
            } else {
                ilIIIIIlll = new lIIIlIIllI(camera, ilIllIlIIl.IllIIIIllI(), context, ilIllIlIIl.IIlIIIllIl());
            }
            int IllIIIllII = IllIIIllII.llIIlIIlll().IllIIIllII();
            if (IllIIIllII != -1) {
                ilIIIIIlll.llIIlIlIIl(IllIIIllII);
            } else {
                List<String> supportedFocusModes = camera.getParameters().getSupportedFocusModes();
                if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
                    ilIIIIIlll.llIIlIlIIl(300);
                } else {
                    ilIIIIIlll.llIIlIlIIl(0);
                }
            }
            ilIIIIIlll.IlIllIlIIl();
            return ilIIIIIlll;
        } else {
            Log.m40229e(this, "Cannot create strategy with empty settings", new Object[0]);
            throw new NullPointerException("Cannot create strategy with empty settings");
        }
    }
}
