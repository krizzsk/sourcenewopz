package com.google.p217ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.aq */
final /* synthetic */ class C18653aq implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f53518a;

    /* renamed from: b */
    private final CameraCaptureSession f53519b;

    C18653aq(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f53518a = stateCallback;
        this.f53519b = cameraCaptureSession;
    }

    public final void run() {
        this.f53518a.onClosed(this.f53519b);
    }
}
