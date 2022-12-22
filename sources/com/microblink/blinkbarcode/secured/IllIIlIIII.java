package com.microblink.blinkbarcode.secured;

import android.hardware.Camera;
import com.microblink.blinkbarcode.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: line */
public class IllIIlIIII {
    private static List<String> IlIllIlIIl = Arrays.asList(new String[]{"continuous-picture", "macro", DebugKt.DEBUG_PROPERTY_VALUE_AUTO});
    private static List<String> IllIIIIllI = Collections.singletonList(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
    private static List<String> IllIIIllII = Arrays.asList(new String[]{"continuous-picture", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "macro"});
    private static List<String> llIIIlllll = Arrays.asList(new String[]{"macro", DebugKt.DEBUG_PROPERTY_VALUE_AUTO});
    private Camera.Parameters llIIlIlIIl;

    static {
        Arrays.asList(new String[]{"macro", DebugKt.DEBUG_PROPERTY_VALUE_AUTO});
    }

    public IllIIlIIII(Camera camera) {
        this.llIIlIlIIl = camera.getParameters();
    }

    public String IIlIIIllIl() {
        return llIIlIlIIl(IllIIIllII);
    }

    public void IlIllIlIIl() {
        if (this.llIIlIlIIl.isVideoStabilizationSupported()) {
            Log.m40231i(this, "Enabling video stabilization", new Object[0]);
            this.llIIlIlIIl.setVideoStabilization(true);
        }
    }

    public void IlIllIlllI() {
        this.llIIlIlIIl.setPictureFormat(256);
        this.llIIlIlIIl.setJpegQuality(100);
        List<Camera.Size> supportedPictureSizes = this.llIIlIlIIl.getSupportedPictureSizes();
        if (!supportedPictureSizes.isEmpty()) {
            Camera.Size size = supportedPictureSizes.get(0);
            int i = size.height * size.width;
            for (Camera.Size next : supportedPictureSizes) {
                int i2 = next.height * next.width;
                if (i2 > i) {
                    size = next;
                    i = i2;
                }
            }
            this.llIIlIlIIl.setPictureSize(size.width, size.height);
        }
    }

    public Boolean IllIIIIllI() {
        List<String> supportedFlashModes = this.llIIlIlIIl.getSupportedFlashModes();
        if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
            Log.m40231i(this, "Camera does not support torch!", new Object[0]);
            return Boolean.FALSE;
        }
        Log.m40231i(this, "Camera supports torch!", new Object[0]);
        return Boolean.TRUE;
    }

    public Camera.Parameters IllIIIllII() {
        return this.llIIlIlIIl;
    }

    public void lIIIIIllll() {
        this.llIIlIlIIl.setPreviewFpsRange(30000, 30000);
    }

    public void lIlIIIIlIl() {
        List<String> supportedWhiteBalance = this.llIIlIlIIl.getSupportedWhiteBalance();
        if (supportedWhiteBalance == null || !supportedWhiteBalance.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            Log.m40235w(this, "Automatic white balance not supported!!!", new Object[0]);
            return;
        }
        this.llIIlIlIIl.setWhiteBalance(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        Log.m40233v(this, "Activated automatic white balance correction", new Object[0]);
    }

    public boolean llIIIlllll() {
        return this.llIIlIlIIl.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
    }

    public String llIIlIIlll() {
        return llIIlIlIIl(IlIllIlIIl);
    }

    public IllIIlIIII llIIlIlIIl(Camera.Size size) {
        this.llIIlIlIIl.setPreviewSize(size.width, size.height);
        return this;
    }

    public void lllIIIlIlI() {
        this.llIIlIlIIl.setRecordingHint(true);
        this.llIIlIlIIl.setPictureSize(3264, 2448);
    }

    public String toString() {
        return this.llIIlIlIIl.flatten();
    }

    public IllIIlIIII llIIlIlIIl(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.llIIlIlIIl.setZoom(Math.round(f * ((float) this.llIIlIlIIl.getMaxZoom())));
        return this;
    }

    public boolean IlIllIlIIl(boolean z) {
        if (z) {
            this.llIIlIlIIl.setFlashMode("torch");
            return true;
        }
        List<String> supportedFlashModes = this.llIIlIlIIl.getSupportedFlashModes();
        if (supportedFlashModes == null || !supportedFlashModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            Log.m40229e(this, "Flash mode OFF not supported!!!!", new Object[0]);
            return false;
        }
        this.llIIlIlIIl.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        return true;
    }

    public void llIIlIlIIl(boolean z) {
        if (z) {
            llIIlIlIIl(llIIIlllll);
        } else {
            llIIlIlIIl(IllIIIIllI);
        }
    }

    public void llIIlIlIIl() {
        String str = this.llIIlIlIIl.get("phase-af-values");
        Log.m40231i(this, "Supported Phase AutoFocus modes: {}", str);
        if (str != null) {
            for (String equals : str.split(",")) {
                if ("on".equals(equals)) {
                    Log.m40231i(this, "Activating Phase Autofocus!", new Object[0]);
                    this.llIIlIlIIl.set("phase-af", "on");
                }
            }
        }
    }

    public void llIIlIlIIl(int i) {
        this.llIIlIlIIl.setPreviewFrameRate(i);
    }

    public void llIIlIlIIl(Camera camera) {
        camera.setParameters(this.llIIlIlIIl);
    }

    private String llIIlIlIIl(List<String> list) {
        List<String> supportedFocusModes = this.llIIlIlIIl.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return "noSupport";
        }
        for (String next : list) {
            if (supportedFocusModes.contains(next)) {
                this.llIIlIlIIl.setFocusMode(next);
                return next;
            }
        }
        return "noSupport";
    }
}
