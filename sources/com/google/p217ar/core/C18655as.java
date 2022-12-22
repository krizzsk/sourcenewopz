package com.google.p217ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.as */
final /* synthetic */ class C18655as implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f53523a;

    /* renamed from: b */
    private final CameraCaptureSession f53524b;

    C18655as(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f53523a = stateCallback;
        this.f53524b = cameraCaptureSession;
    }

    public final void run() {
        this.f53523a.onConfigureFailed(this.f53524b);
    }
}
