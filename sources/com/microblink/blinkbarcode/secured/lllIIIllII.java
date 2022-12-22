package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraCaptureSession;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
class lllIIIllII extends CameraCaptureSession.StateCallback {
    public void onActive(CameraCaptureSession cameraCaptureSession) {
        super.onActive(cameraCaptureSession);
        Log.m40227d(IIlIlIIlll.class, "Session is now active", new Object[0]);
    }

    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        super.onClosed(cameraCaptureSession);
        Log.m40227d(IIlIlIIlll.class, "Session is now closed", new Object[0]);
    }

    public void onReady(CameraCaptureSession cameraCaptureSession) {
        super.onReady(cameraCaptureSession);
        Log.m40227d(IIlIlIIlll.class, "Session is now ready", new Object[0]);
    }
}
